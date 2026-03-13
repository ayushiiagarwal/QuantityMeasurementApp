package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.QuantityMeasurementEntity;
import support.DatabaseConnection;


public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository{
    @Override
    public void save(QuantityMeasurementEntity entity){
        String sql = "INSERT INTO entities(value, unit, operation, result) VALUES (?, ?, ?, ?)";

        
        try(Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, entity.getOperation());
            ps.setString(2, entity.getOperand1());
            ps.setString(3, entity.getOperand2());
            ps.setString(4, entity.getResult());
            ps.executeUpdate();

            System.out.println(entity);
        }
        catch(SQLException e){
            throw new RuntimeException("Databse Error: " + e.getMessage());
        }
    }
}
