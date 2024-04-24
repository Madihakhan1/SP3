public class Serie extends Media {

    private String yearsRunning;
    private String[] seasonsAndEpisodes;


    public Serie(String title, String yearsRunning, String[] genre, double rating, String[] seasonsAndEpisodes) {
        super(title, genre, rating);
        this.yearsRunning = yearsRunning;
        this.seasonsAndEpisodes = seasonsAndEpisodes;
    }

    public String getYearsRunning() {
        return yearsRunning;
    }

    public String[] getSeasonsAndEpisodes(){
        return seasonsAndEpisodes;
    }


    @Override
    public String toString() {
        String genres = "";
        for(String s : this.genre){
            genres += ", ";
            genres += s;
        }
        StringBuilder out = new StringBuilder();
        out.append(this.title).append(", ").append(this.yearsRunning).append(", "+genres).append(", ").append(rating).append(", " + seasonsAndEpisodes);

        return out.toString();
    }

}
