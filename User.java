import java.util.ArrayList;
import java.util.List;

//navn og kode på brugeren.
//Eks. vis brugernes sete liste og gemte liste.

public class User {

    private String userName;
    private String password;
    private List<String> watched;
    private List<String> saved;


    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.watched = new ArrayList<>();
        this.saved = new ArrayList<>();
    }

    public void setWatched(List<String> watched) {
        this.watched = watched;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return password;
    }

    public void userWatched(String m) {
        getWatched().add(m);
    }

    public void userSaved(String m) {
        getSaved().add(m);
    }

    public void watched(String media) {
        watched.add(media);
    }

    public List<String> getWatched() {

        return watched;
    }


    public List<String> getSaved() {
        return saved;
    }

    public  void addToSaveList(String movie){
        saved.add(movie);
    }

    //Skal tjekke hvad vi skal skrive i vores toString.
    @Override
    public String toString() {
        return "Login: " + userName +
                "\n" + "Watched: " + watched;
    }
}



