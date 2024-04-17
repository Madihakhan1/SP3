import java.util.Scanner;

public class TextUI {

    private Scanner scanner = new Scanner(System.in);

   public String getInput(String msg){

       System.out.println(msg);

       return msg;


    }

    public void displayMessage(String msg){

        System.out.println(msg);
    }



}
