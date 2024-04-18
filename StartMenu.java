import java.util.*;

public class StartMenu {

    private String userName;
    private String userPassword;
    private User currentUser;
    protected List<User> users = new LinkedList<>();
    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();


public void createUser(){

    ui.displayMessage("Create a user");

    this.userName = ui.getInput("Please type a username:");
    this.userPassword = ui.getInput("Please type a password");

    List<User>registeredUsers = io.loadAllUserData();

    for(User u: registeredUsers){
        if(u.getUserName().equals(this.userName)){
            ui.displayMessage("User name is not available");
            return;
        }
    }

    User createdUser = new User(userName, userPassword);
    this.users.add(createdUser);
    io.saveUserData(users);


}


public boolean login(){
    Scanner userinput = new Scanner(System.in);
    ui.displayMessage("type your username");
    userName = userinput.nextLine();
    ui.displayMessage("type your password");
    userPassword = userinput.nextLine();


    List<User> registeredUsers = io.loadAllUserData();
    for(User u : registeredUsers){
        if(u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword)){
            currentUser = u;
            System.out.println("current user: "+currentUser.getUserName());
            return true;

        }
    }

    return false;
}


}
