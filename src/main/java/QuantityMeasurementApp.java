public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Quantity<TemperatureUnit> temp1 = new Quantity<>(0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> temp2 = new Quantity<>(32, TemperatureUnit.FAHRENHEIT);

        System.out.println(temp1.equals(temp2));       
        System.out.println(temp1.convertTo(TemperatureUnit.FAHRENHEIT));
    }
}