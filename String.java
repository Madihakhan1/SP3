public abstract class String {

    protected java.lang.String title;
    protected java.lang.String[] genre;
    protected double rating;


    public String(java.lang.String title, java.lang.String[] genre, double rating) {

        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public java.lang.String getTitle() {
        return title;
    }



    public java.lang.String[] getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }


}
