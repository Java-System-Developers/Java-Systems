// TODO: Add a Registration Function Since we can Already Log In
// TODO: Separate SignIn and SignOut Function

import Database.Data.GetData;
import Users.UserDatabase;

import java.io.IOException;

/*
 * This just runs the process, and not actually doing any process itself
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String userID;
        String userName;
        // Login
        System.out.println("Welcome to Bootleg Steam Market!\n");
        while (!UserDatabase.isLoggedIn) {
            UserDatabase.CheckUser();
        }
        userID = GetData.CredentialVerifier.userID;
        userName = GetData.CredentialVerifier.userName;

        System.out.printf("\n\n\nWelcome to Bootleg Steam Market: %s #%s\n\n", userName, userID);
    }
}