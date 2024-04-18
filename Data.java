import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Data {

    ArrayList<User> readUserData(String path);

 void saveUserData (List<User> users);
List<User> loadAllUserData();
 void saveWatchedMovie (List<Movie> watched);
 void saveSavedMovie (List<Movie> saved);
 List<Movie> readMovieData ();

}
