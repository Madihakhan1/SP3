public class Movie {

private String title;
private int publicationYear;
private String genre;
private double rating;



public Movie(String title, int year, String genre, double rating){

    this.title = title;
    this.publicationYear = publicationYear;
    this.genre = genre;
    this.rating = rating;

}

public String getTitle(){

    return title;
}

public int getPublicationYear(){
    return publicationYear;
}

public String getGenre(){
    return genre;
}

public double getRating(){

    return rating;
}

@Override
public String toString(){
    return "Title: " + title +
            "\n" + "Year: " + publicationYear +
            "\n" + "Genre: " + genre +
            "\n" + "Rating: " + rating;

}

}
