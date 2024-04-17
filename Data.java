import java.util.ArrayList;
import java.util.List;

public interface Data {

    ArrayList<User> readUserData(String path);

 void saveUserData (List<User> users);
 void saveWatchedMovie (List<Movie> watched);
 void saveSavedMovie (List<Movie> saved);
 String[] readMovieData (String path, int length);

}
