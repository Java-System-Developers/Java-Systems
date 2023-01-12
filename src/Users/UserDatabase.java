package Users;

import com.opencsv.CSVWriter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

        // Input
        System.out.print("Enter Username: ");
        name = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();
        randomID = RandomStringUtils.randomNumeric(6);


        FileWriter fileWriter = new FileWriter("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv", true);

        try (CSVWriter csvWriter = new CSVWriter(fileWriter)){
            // Adding Header to CSV
            /*String[] header = {"Name", "Password", "ID"};
            csvWriter.writeNext(header);*/

            // Adding Credentials
            String[] credentialData = {name, password, randomID};
            csvWriter.writeNext(credentialData);

            // Closing Writer Connection
            csvWriter.close();
        } catch (Exception ignored){
        }
    }

    public static boolean isLoggedIn(){
        return false;
    }
}
