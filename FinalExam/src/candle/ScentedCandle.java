
public class ScentedCandle extends Candle {
    private String scent;

    public ScentedCandle() {
        super();
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height) {
        super(color, height);
        this.price = height * 3;
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height, String scent) {
        super(color, height);
        this.price = height * 3;
        this.scent = scent;
    }

    public String getScent() {
        return scent;
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        this.price = height * 3;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }
}