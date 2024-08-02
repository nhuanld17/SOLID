package IV_Interface_Segregation_Principle;

public class Cube implements IAreaCalculator, ICalculateVolume{
    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double CalculateVolume() {
        return 0;
    }
}
