package com.app.gateway.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.util.List;

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> {

    private static final String SECRET = "THE_SECRET_KEYTHE_SECRET_KEYTHE_SECRET_KEYTHE_SECRET_KEY";

    private static final List<String> OPEN_PATHS = List.of(
            "/swagger-ui", "/v3/api-docs", "/swagger-resources",
            "/webjars", "/user-service/v3/api-docs", "/measurement-service/v3/api-docs",
            "/oauth2", "/login", "/auth", "/api/quantities"
    );

    public JwtAuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getURI().getPath();

            boolean isOpen = OPEN_PATHS.stream().anyMatch(path::startsWith);
            if (isOpen) return chain.filter(exchange);

            String authHeader = exchange.getRequest()
                    .getHeaders()
                    .getFirst(HttpHeaders.AUTHORIZATION);

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return unauthorized(exchange);
            }

            String token = authHeader.substring(7);

            try {
                SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());
                Claims claims = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(token)
                        .getPayload();

                exchange = exchange.mutate()
                        .request(r -> r.header("X-User-Email", claims.getSubject()))
                        .build();

            } catch (Exception e) {
                return unauthorized(exchange);
            }

            return chain.filter(exchange);
        };
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    public static class Config { }
}
