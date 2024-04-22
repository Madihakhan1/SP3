
import java.util.ArrayList;
import java.util.List;

//navn og kode på brugeren.
//Eks. vis brugernes sete liste og gemte liste.

public class User {

    private String userName;
    private String password;
    private List<Media> watched;
    private List<Media> saved;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.watched = new ArrayList<>();
        this.saved = new ArrayList<>();
    }


    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return password;
    }

    public void userWatched(Movie m) {
        getWatched().add(m);
    }

    public void userSaved(Movie m) {
        getSaved().add(m);
    }

    public List<Media> getWatched() {
        return watched;
    }
    public void watched(Media movie) {
        watched.add(movie);
    }

    public List<Media> getSaved() {
        return saved;
    }

    public  void addToSaveList(Media movie){
        saved.add(movie);
    }

    //Skal tjekke hvad vi skal skrive i vores toString.
    @Override
    public String toString() {
        return "Login: " + userName +
                "\n" + "Watched: " + watched;
    }
}



