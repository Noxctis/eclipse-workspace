public class Pop extends Music {
    public Pop(String title) {
        super(title);
        this.price = 4.99;
    }

    public Pop(String title, double price) {
        super(title, price);
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

	@Override
	public void setPrice() {
		this.price = 4.99;
	}

}
