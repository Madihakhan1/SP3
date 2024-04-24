public abstract class Media {

    protected String title;
    protected String[] genre;
    protected double rating;


public Media(String title, String[] genre, double rating) {

        this.title = title;
        this.genre = genre;
        this.rating = rating;
}

public String getTitle() {
        return title;
}

public String[] getGenre() {
        return genre;
}

public double getRating() {
        return rating;
    }
}
