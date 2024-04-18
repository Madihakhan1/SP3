import java.util.ArrayList;
import java.util.List;

//Læs filmen, opret bruger eller indlæs allerede oprettet bruger.
public class Streaming {

    private List<Movie> allMovies = new ArrayList<Movie>();
    private ArrayList<String> listOfOptions;


    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    StartMenu startMenu = new StartMenu();


public void displayStartMenu (){
ui.displayMessage("Welcome to ChillFlex, do you want to create a user or login?");

String options = "";
boolean choosing = true;
//while (choosing){

    options = ui.getInput("Choose an option: \n Option 1: create a user \n option 2: login");


    switch(options) {
        case "1":
            startMenu.createUser();
            startMenu.login();


            break;
        case "2":

            break;

        case "3":

            break;

        case "4":

            break;


        default:
            // code block
    }


//}


}

public void displayMainMenu (){

}

public void displaySavedList (){

}
public void searchForMovie (){

}

public void displayWatchedList (){

}

public void logOut (){

}


}
