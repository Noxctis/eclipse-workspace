
public class ScentedCandle extends Candle {
    private String scent;
    private double PPI = 3;

    public ScentedCandle() {
        super();
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height) {
        super(color, height);
        this.price = height * PPI;
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height, String scent) {
        super(color, height);
        this.price = height * PPI;
        this.scent = scent;
    }

    public String getScent() {
        return scent;
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        this.price = height * PPI;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }
}