public abstract class Music {
    private String title;
    protected double price;

    public Music(String title) {
        this.title = title;
    }
    
    public Music(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public abstract void setPrice(double price);
    public abstract void setPrice();
}
