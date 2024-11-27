
public class ScentedCandle extends Candle {
    private String scent;
    private final double PPI = 3; // Price Per Inch

    public ScentedCandle() {
        super();
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height) {
        super(color, height);
        //this.price = height * PPI;
        setHeight(height,this.PPI);
        this.scent = "Unknown";
    }

    public ScentedCandle(String color, double height, String scent) {
        super(color, height);
        //this.price = height * PPI;
        setHeight(height,this.PPI);
        this.scent = scent;
    }

    public String getScent() {
        return scent;
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        //this.price = height * PPI;
        setHeight(height,this.PPI);
    }

    public void setScent(String scent) {
        this.scent = scent;
    }
}