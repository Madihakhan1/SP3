import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.lang.String;

public class FileIO {


    public ArrayList<User> readUserData (String path){
        return readUserData(".idea/Doc/Users");
    }


public void saveUserData (List<User> users){
        File file = new File(".idea/Doc/Users");

    try {
        Scanner scan = new Scanner(file);
        scan.nextLine();
        FileWriter writer = new FileWriter(".idea/Doc/Users");
        writer.write("Name, Password \n");//Giv csv filen en header
        for (User u: users) {
            String textTosave = u.getUserName()+ "," +u.getUserPassword() + "\n";
            writer.write(textTosave);
        }
        writer.close();
    }catch (IOException e){
        System.out.println("File was not found");
    }
}

//Vi starter med at lave en liste med bruger --> linkedlist: Den sørger for at alle brugere kommer i den rækkefølge vi har oprettet den i.
    //Vi henter filen brugerne ligger i
    //Så skipper vi header
    //Så henter vi en linje, som brugeren ligger på.
    //Så splitter vi linjen på komma
    //Vi gemmer splittet i et array, 0 pladsen er brugernavnet, 1 pladsen er adgangskoden også bruger vi trim til at fjerne mellemrum i mellem username og password.
    //Også bruger vi de split til at lave bruger objekter og tilføjer det til listen loadedUsers.


    public List<User> loadAllUserData() {
        List<User> loadedUsers = new LinkedList<>();
        try{
            File file = new File(".idea/Doc/Users");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                line = line.trim();
                String[] splitted = line.split(",");
                User loaded = new User(splitted[0].trim(),splitted[1].trim());
                List<String> w = readWatchMedia(loaded);
                loaded.setWatched(w);
                loadedUsers.add(loaded);
            }
            scanner.close();
        }catch (Exception e){
            System.out.println("File was not found: "+e.getMessage());
        }
        return loadedUsers;
    }

    public void saveWatchedMedia (User user){
        List<String> watched = user.getWatched();
    try {
        FileWriter writer = new FileWriter(".idea/Doc/Watched");
        String textToSave = user.getUserName() + ":";
        for (String m: watched) {
            textToSave += m + ",";
        }
        writer.write(textToSave + "\n");
        writer.close();
    }catch (IOException e){
        System.out.println("File was not found");
    }
}

public List<String> readWatchMedia(User user){
    File file = new File(".idea/Doc/MovieList");
    List<String> medias = new LinkedList<>();
    //Scanner er sat ind i paranteser så behøver vi ikke at lukke den.
    try(Scanner scan = new Scanner(file)){
        while(scan.hasNext()){
            String dataLine = scan.nextLine(); //Scanner næste linje i movieFilen
            String[] splitted = dataLine.split(";"); //Her splitter den på hele linjen pr semikolon
            String userName = splitted[0].trim();
            String[] movies = splitted[1].split(","); // det trejdesplit er genrene, der splitter vi igen for at få genrens egen liste
            for(int i = 0; i < movies.length; i++){ // For hver genre i den liste, der trimmer vi den så der ikke er mellemrum.
                movies[i] = movies[i].trim();
                if(userName.equals(user.getUserName())) {
                    medias.add(movies[i]);
                }
            }
             //Intenger.parseint --> Tager den årstallet som er en String og laver den om til et tal.
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    return  medias;
}

public void savedMedia(List<String> saved){

try{
    FileWriter writer = new FileWriter(".idea/Doc/saved");

    for(String m: saved) {
        String genres = "";
        String[] genre = m.getGenre();
        for(int i = 0; i < genre.length; i++) {
        genres += genre[i] + ",";
        }
            // pil genrer ud og kør igennem med for-loop og lav string ud af dem (fx crime, romance, drama)
            String textToSave = (m.getTitle() + "; " + "; " + genres +  "; " + m.getRating() + "\n");
            writer.write(textToSave);
        }

    writer.close();
}catch (IOException e){
    System.out.println("File was not found");
    }
}

    public List<Movie> readMovieData(){
        File file = new File(".idea/Doc/MovieList");
        List<Movie> movies = new LinkedList<>();
        //Scanner er sat ind i paranteser så behøver vi ikke at lukke den.
        try(Scanner scan = new Scanner(file)){
            while(scan.hasNext()){
                String movieLine = scan.nextLine(); //Scanner næste linje i movieFilen
                String[] splitted = movieLine.split(";"); //Her splitter den på hele linjen pr semikolon
                String[] genres = splitted[2].split(","); // det trejdesplit er genrene, der splitter vi igen for at få genrens egen liste
                for(int i = 0; i < genres.length; i++){ // For hver genre i den liste, der trimmer vi den så der ikke er mellemrum.
                    genres[i] = genres[i].trim();
                }
                movies.add(new Movie(splitted[0].trim(), Integer.parseInt(splitted[1].trim()), genres, Double.parseDouble(splitted[3].trim()))); //Intenger.parseint --> Tager den årstallet som er en String og laver den om til et tal.
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  movies;
    }


    public List<Serie> readSerieData(){
        File file = new File(".idea/Doc/SeriesList");
        List<Serie> series = new LinkedList<>();
        //Scanner er sat ind i paranteser så behøver vi ikke at lukke den.
        try(Scanner scan = new Scanner(file)){

            while(scan.hasNext()){
                String serieLine = scan.nextLine(); //Scanner næste linje i serieFilen
                String[] splitted = serieLine.split(";"); //Her splitter den på hele linjen pr semikolon
                String[] genres = splitted[2].split(","); // det trejdesplit er genrene, der splitter vi igen for at få genrens egen liste
                String[] seasonsAndEpisodes = splitted[4].split(",");
                for(int i = 0; i < genres.length; i++){ // For hver genre i den liste, der trimmer vi den så der ikke er mellemrum.
                    genres[i] = genres[i].trim();
                }
                series.add(new Serie(splitted[0].trim(),splitted[1].trim(), genres, Double.parseDouble(splitted[3].trim()), seasonsAndEpisodes)); //Intenger.parseint --> Tager den årstallet som er en String og laver den om til et tal.
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return series;
    }
}
