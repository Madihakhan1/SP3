import java.util.*;

public class StartMenu {

    private String userName;
    private String userPassword;
    private User currentUser;
    protected List<User> registeredUsers = new LinkedList<>();

    private TextUI ui = new TextUI();
    private FileIO io = new FileIO();

    StartMenu() {
        this.registeredUsers = io.loadAllUserData();
    }

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
    this.registeredUsers.add(createdUser);
    io.saveUserData(this.registeredUsers);


}


public User login(){
    Scanner userinput = new Scanner(System.in);
    ui.displayMessage("type your username");
    userName = userinput.nextLine();
    ui.displayMessage("type your password");
    userPassword = userinput.nextLine();



    for(User u : registeredUsers){
        if(u.getUserName().equals(userName) && u.getUserPassword().equals(userPassword)){
            currentUser = u;
            System.out.println("current user: "+currentUser.getUserName());
            return currentUser;

        }
    }

    return null;
}


}
