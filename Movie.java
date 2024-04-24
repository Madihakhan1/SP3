public class Movie extends String {

    private int publicationYear;

    public Movie(String title, int publicationYear, String[] genre, double rating) {
        super(title, genre, rating);
        this.publicationYear = publicationYear;

    }

    public int getPublicationYear() {
        return publicationYear;
    }


    @Override
    public String toString() {
        String genres = "";

        if (genre != null && genre.length > 0) {
            genres = String.join(", ", genre);
        }
      /*  for(String s : this.genre){
            genres += ", ";
            genres += s;
        }*/
        StringBuilder out = new StringBuilder();
        out.append(this.title).append(", ").append(this.publicationYear).append(", "+genres).append(", ").append(rating);

        return out.toString();
    }
}
