public class Movie {

    private String title;
    private int publicationYear;
    private String[] genre;
    private double rating;


    public Movie(String title, int publicationYear, String[] genre, double rating) {

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

    @Override
    public String toString() {
        String genres = "";
        for(String s : this.genre){
            genres += ", ";
            genres += s;
        }
        StringBuilder out = new StringBuilder();
        out.append(this.title).append(", ").append(this.publicationYear).append(", "+genres).append(", ").append(rating);

        return out.toString();
    }


}
