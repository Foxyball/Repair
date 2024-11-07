/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repair;

/**
 *
 * @author thefo
 */
public class LoggedInUser {
    private static User loggedInUser;

    // Set the logged-in user
    public static void setUser(User user) {
        loggedInUser = user;
    }

    // Get the logged-in user
    public static User getUser() {
        return loggedInUser;
    }
}

