//Vi skal ha en file reader og en scanner.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO implements Data{


    public ArrayList<User> readUserData (String path){
        return readUserData(".idea/Doc/Users");
    }


public void saveUserData (List<User> users){

    try {
        FileWriter writer = new FileWriter(".idea/Doc/Users");
        writer.write("Name, Password \n"); //Giv csv filen en header
        for (User u: users) {
            String textTosave = u.getUserName()+ u.getUserPassword() + "\n";
            writer.write(textTosave);
        }
        writer.close();
    }catch (IOException e){
        System.out.println("File was not found");
    }

}

public void saveWatchedMovie (List<Movie> watched){

    try {
        FileWriter writer = new FileWriter(".idea/Doc/Watched");

        for (Movie m: watched) {
            String textToSave = (m.getTitle() + m.getPublicationYear() + m.getGenre() + m.getRating() + "\n");
            writer.write(textToSave);
        }
        writer.close();
    }catch (IOException e){
        System.out.println("File was not found");
    }
}

public void saveSavedMovie(List<Movie> saved){
try{
    FileWriter writer = new FileWriter(".idea/Doc/saved");

    for(Movie m: saved){
        String textToSave = (m.getTitle() + m.getPublicationYear() + m.getGenre() + m.getRating() + "\n");
        writer.write(textToSave);
    }
    writer.close();
}catch (IOException e){
    System.out.println("File was not found");
    }
}

    @Override
    public String[] readMovieData (String path, int length) {
        int count = 0;
        String[] data = new String[length];
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                data[count] = s;
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File was not found");
        }
        return data;
    }

}
