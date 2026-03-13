package application;
import controller.QuantityMeasurementController;
import quantity.Quantity;
import repository.IQuantityMeasurementRepository;
import repository.QuantityMeasurementDatabaseRepository;
import service.QuantityMeasurementServiceImpl;
import units.LengthUnit;

public class QuantityMeasurementApp {
    public static void main(String[] args) {
        IQuantityMeasurementRepository repository = new QuantityMeasurementDatabaseRepository();
        
        QuantityMeasurementController controller = new QuantityMeasurementController(new QuantityMeasurementServiceImpl());

        Quantity<LengthUnit> length1 = new Quantity<>(1, LengthUnit.FEET);
        Quantity<LengthUnit> length2 = new Quantity<>(12, LengthUnit.INCH);

        controller.demonstrateEquality(length1, length2);
        controller.demonstrateAddition(length1, length2);
    }
}