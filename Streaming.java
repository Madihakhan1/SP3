import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Læs filmen, opret bruger eller indlæs allerede oprettet bruger.
public class Streaming {

    private List<Movie> allMovies = new ArrayList<>();
    private List<Serie> allSeries = new ArrayList<>();

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
            }
        }
        return false;
    }

    public void displayMainMenu (){
        String options =   ui.getInput("Choose an option \n Option 1: see Movielist \n option 2: see Serielist \n option 3: search after title \n option 4: search after genre \n option 5 display saved list \n option 6: see watched list");

        switch (options) {
            case "1":
                ui.displayMovieList(allMovies);
                break;

            case "2":
                ui.displaySerieList(allSeries);
                break;

            case  "3":
                searchForMovieByTitle();
                break;

            case "4":
                searchForMovieByGenre();
                break;

            case"5":
                displaySavedList();
                break;

            case"6":
                displayWatchedList();
                break;

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
                    io.saveWatchedAndSaved(currentUser);
                    break;

                case "2":
                    ui.displayMessage("you have saved " + chosenMovie);
                    currentUser.addToSaveList(chosenMovie);
                    io.saveWatchedAndSaved(currentUser.getSaved());
                    break;
            }
            //play(chosenMovie); // Pass the chosen movie to the play() method
        } else {
            ui.displayMessage("Invalid selection.");
        }
    }

    public void searchForMovieByTitle(){
        System.out.println(" ");
        String input = ui.getInput("Write the title you are looking for");
        List<Movie> moviesByTitle = new LinkedList<>();
        for(Movie mTitle: allMovies){
            String s = mTitle.getTitle();
            if(s.equalsIgnoreCase(input)){
                moviesByTitle.add(mTitle);
            }
        }

        Movie chosenMovie = moviesByTitle.get(0);
        ui.displayMessage("You have chosen: " + chosenMovie.getTitle());
        String choice = ui.getInput("Do you want to play the movie or add it to your saved list? \n(Choose 1: play' or 2: save)");

        switch (choice) {

        case "1":
        play(chosenMovie);
        currentUser.userWatched(chosenMovie.getTitle());
        io.saveWatchedAndSaved(currentUser);
        break;

        case "2":
            ui.displayMessage("you have saved " + chosenMovie);
            currentUser.addToSaveList(chosenMovie.getTitle());
            io.saveWatchedAndSaved(currentUser.getSaved());
            break;

        }
    }


    public void play(Movie chosenMovie) {
        if (chosenMovie != null) {
            ui.displayMessage("Now playing: " + chosenMovie.getTitle());
            currentUser.watched(chosenMovie.getTitle());
        } else {
            ui.displayMessage("Invalid selection. Please try again.");
        }
    }

    public void displayWatchedList() {
        List<String> watchedList = Streaming.currentUser.getWatched();
        if (watchedList.isEmpty()) {
            ui.displayMessage("Your watched list is empty.");
        } else {
            ui.displayMessage("List of watched media:");
            for (String media : watchedList) {
                ui.displayMessage(media.toString());
            }
            //io.saveWatchedMedia(watchedList);
        }
    }

    public void displaySavedList() {
        List<String> savedList = Streaming.currentUser.getSaved();
        ui.displayMessage("Your saved list ");
        for (String media : savedList) {
            ui.displayMessage(media.toString());
        }


        public void setup () {
            allMovies = io.readMovieData();
            allSeries = io.readSerieData();
        }

        public void startStreaming () {
            setup();
            boolean isLoggedIn = loginOrRegister();
            if (isLoggedIn) {
                displayMainMenu();
            }
        }
    }



