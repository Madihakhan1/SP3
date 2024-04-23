public abstract class Media {

    private String title;
    private int publicationYear;
    private String[] genre;
    private double rating;


    public Media (String title, int publicationYear, String[] genre, double rating) {

        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.rating = rating;

    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String[] getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }


}
