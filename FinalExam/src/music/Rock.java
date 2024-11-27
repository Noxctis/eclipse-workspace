public class Rock extends Music {
    public Rock(String title) {
        super(title);
        this.price = 7.99;
    }

    public Rock(String title, double price) {
        super(title, price);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setPrice() {
        this.price = 7.99;
    }
}