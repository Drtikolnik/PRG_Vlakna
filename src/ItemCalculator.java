public class ItemCalculator implements Runnable {
    private double result = 1;
    private double base;
    private double power;

    public ItemCalculator(double base, double power) {
        this.base = base;
        this.power = power;
    }

    public void run() {
        result = Math.pow(base, power);
    }

    public double getResult() { return result; }
}