import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    boolean running = true;
    Streaming streaming = new Streaming();

        streaming.setup();
        boolean isLoggedIn = streaming.loginOrRegister();
        if(isLoggedIn){
            streaming.displayMainMenu();
        }

    }


}