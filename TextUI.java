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



}
