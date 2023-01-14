package Users;

import Database.Data.GetData;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDatabase {
    // Global Variable
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
         * Writing to CSV File
         */

        // Variables
        String name, password, randomID;
        List<List<String>> records = new ArrayList<>();
        GetData data = new GetData();
        records = data.GetUserData();
        int verificationStatus;

        // Input
        /* Checking Credentials */

        System.out.print("Enter Username: ");
        name = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();
        randomID = RandomStringUtils.randomNumeric(6);
        String[] credentialData = {name, password, randomID};

        // Dili ko sure kung unsay gamit ani karon, basta naka 2d array na ang mga credentials
        String[][] credentials = data.getCredentials(records); // [[Usernames] [Passwords] [User ID's]] in order
        verificationStatus = data.VerificationStatus(name, password, credentials, records);

        switch (verificationStatus) {
            case 1 -> System.out.println("You are already logged in!");
            case 2 -> System.out.println("Username is already taken!");
            case 3 -> System.out.println("Password is already taken!");
            case 0 -> {
                // Adding Credentials
                data.AddUserData(credentialData);
            }
            default -> System.out.println("Invalid Input!");
        }
    }

}
