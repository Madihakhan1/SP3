public class Serie extends Media{


    private String title;
    private int yearsRunning;
    private String[] genre;
    private double rating;
    private double season;
    private double episode;


    public Serie(String title, int publicationYear, String[] genre, double rating) {
        super(title, publicationYear, genre, rating);
    }


    public String getTitle() {

        return title;
    }

    public int getYearsRunning() {
        return yearsRunning;
    }

    public String[] getGenre() {
        return genre;
    }

    public double getRating() {

        return rating;
    }

    public double getSeason(){
        return season;
    }

    public double getEpisode(){
        return episode;
    }
    @Override
    public String toString() {
        String genres = "";
        for(String s : this.genre){
            genres += ", ";
            genres += s;
        }
        StringBuilder out = new StringBuilder();
        out.append(this.title).append(", ").append(this.yearsRunning).append(", "+genres).append(", ").append(rating).append(", " + season).append(", " + episode);

        return out.toString();
    }

}
