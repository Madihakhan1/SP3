import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    User createdUser = new User(userName, userPassword);
    this.users.add(createdUser);
    io.saveUserData(users);


}


public void login(){

    ui.displayMessage("Please ");




}
public void loadUser(){


}

public void saveUser(){


}

}
