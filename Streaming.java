import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Læs filmen, opret bruger eller indlæs allerede oprettet bruger.
public class Streaming {

    private List<Movie> allMovies = new ArrayList<>();
    private ArrayList<String> listOfOptions;


    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    StartMenu startMenu = new StartMenu();


public boolean loginOrRegister(){
ui.displayMessage("Welcome to ChillFlex, do you want to create a user or login?");

String options = "";
boolean running = true;
//while (choosing){

    options = ui.getInput("Choose an option: \n Option 1: create a user \n option 2: login \n option 3: Exit");

while(running) {
    switch (options) {
        case "1":
            startMenu.createUser();
            running = false;
            ui.displayMessage("\n Please login again");
            startMenu.login();
            displayMainMenu();
            break;
        case "2":
            boolean isLoggedIn = startMenu.login();
            if(isLoggedIn){
                running = false;
                return true;
            }else {
                return false;
            }


        case "3":
            running = false;
            ui.displayMessage("\nPlease login again");
            startMenu.login();
            displayMainMenu();
            break;


        default:
           running = false;
    }

}

return false;
}

public void displayMainMenu (){

  String options =   ui.getInput("Choose an option \n Option 1: see Movielist \n option 2: Search after genre \n option 3: display saved list \n option 4: see watched list");


    switch (options) {
        case "1":
          ui.displayMovieList(allMovies);

            break;
        case "2":
            searchForMovieByGenre();
            break;

        case "3":
            break;


        default:
    }



}

public void displaySavedList (){


}
public void searchForMovieByGenre(){
    System.out.println(" ");
   String input = ui.getInput("Write the genre you are looking for");
   List<Movie> moviesByGenre = new LinkedList<>();
   for(Movie m: allMovies){
       for(String s : m.getGenre()){
           if(s.equalsIgnoreCase(input)){
               moviesByGenre.add(m);
           }
       }
   }
   ui.displayMovieList(moviesByGenre);
   int chosenMovie = ui.chooseMovie(moviesByGenre, "Please choose a movie. ");
   ui.displayMessage("Du har valgt " + moviesByGenre.get(chosenMovie));
   // moviesByGenre.get(chosenMovie).play();


}

public void displayWatchedList (){

}



public void setup(){
    allMovies = io.readMovieData();



}


    public void startStreaming() {
        setup();
        boolean isLoggedIn = loginOrRegister();
        if (isLoggedIn) {
            displayMainMenu();
        }
    }


}



