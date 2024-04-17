
import java.util.ArrayList;
import java.util.List;

//navn og kode på brugeren.
//Eks. vis brugernes sete liste og gemte liste.

public class User {

    private String userName;
    private String password;
    private List<Movie> watched;
    private List<Movie> saved;


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
        watched().add(m);
    }

    public void userSaved(Movie m) {
        saved().add(m);
    }

    public List<Movie> watched() {
        return watched;
    }

    public List<Movie> saved() {
        return saved;
    }


    //Skal tjekke hvad vi skal skrive i vores toString.
    @Override
    public String toString() {
        return "Login: " + userName +
                "\n" + "Watched: " + watched;
    }
}



