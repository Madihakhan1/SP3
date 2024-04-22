import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Læs filmen, opret bruger eller indlæs allerede oprettet bruger.
public class Streaming {

    private List<Movie> allMovies = new ArrayList<>();


    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    StartMenu startMenu = new StartMenu();

    public static User currentUser;


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
                    currentUser = startMenu.login();
                    if(currentUser!=null){
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

            case"4":
                displayWatchedList();
                break;


            default:
        }



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
        int chosenIndexMovie = ui.chooseMovie(moviesByGenre, "Please choose a movie. ");
        if (chosenIndexMovie >= 0 && chosenIndexMovie < moviesByGenre.size()) {
            Movie chosenMovie = moviesByGenre.get(chosenIndexMovie);
            ui.displayMessage("You have chosen " + chosenMovie.getTitle());
            ui.displayMessage("Do you want to play the movie or add it to your saved list? ");
            String choice = ui.getInput("1. Play, 2. Save to list");
            switch (choice) {
                case "1":
                    play(chosenMovie); // Pass the chosen movie to the play() method
                    break;

                case "2":
                    //save to savedlist
                    currentUser.addToSaveList(chosenMovie);
                    break;
            }
            //play(chosenMovie); // Pass the chosen movie to the play() method
        } else {
            ui.displayMessage("Invalid selection.");
        }


    }
    public void play(Movie chosenMovie) {
        if (chosenMovie != null) {
            ui.displayMessage("Now playing: " + chosenMovie.getTitle());
            currentUser.watched(chosenMovie);
            // Implement logic to play the chosen movie
        } else {
            ui.displayMessage("Invalid selection. Please try again.");
        }


    }


    public void displayWatchedList() {
        List<Media> watchedList = Streaming.currentUser.getWatched(); // Assuming this returns a list of watched media
        ui.displayMessage("Chosen media you've already watched or want to continue watching: ");
        for (Media media : watchedList) {
            ui.displayMessage(media.toString()); // Assuming media.toString() provides appropriate information
        }
    }





    public void displaySavedList(){


        List<Media> savedList  = Streaming.currentUser.getSaved(); // Assuming this returns a list of watched media
        ui.displayMessage("You have saved this movie ");
        for (Media media : savedList) {
            ui.displayMessage(media.toString()); // Assuming media.toString() provides appropriate information
        }


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



