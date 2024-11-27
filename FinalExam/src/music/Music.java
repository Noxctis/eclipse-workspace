public abstract class Music {
    private String title;
    private String artist;
    private int year;
    private String genre;
    private double price;

    public Music(String title, String artist, int year, String genre, double price) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void play();
}
