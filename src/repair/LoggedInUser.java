
package repair;

/**
 *
 * @author thefo
 */
public class LoggedInUser {
    private static User loggedInUser;

    // Сетване на логнатия потребител
    public static void setUser(User user) {
        loggedInUser = user;
    }

    public static User getUser() {
        return loggedInUser;
    }
}

