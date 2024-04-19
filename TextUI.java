import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUI {

    private Scanner scanner = new Scanner(System.in);

   public String getInput(String msg){

       System.out.println(msg);
       String res = scanner.nextLine();

       return res;


    }

    public void displayMessage(String msg){

        System.out.println(msg);
    }

    public int chooseMovie(List<Movie> optionslist, String msg){
        displayMessage(msg);
        //displayList(optionslist, "");
        String input = getInput("");//1
        //  lav input om til en int
        int choice = Integer.parseInt(input);
        return choice;

    }


    public void displayMovieList(List<Movie> in){
        for(Movie m: in){
            displayMessage(in.indexOf(m) + ". " + m.toString());
        }
    }
}
