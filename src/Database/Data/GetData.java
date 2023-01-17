package Database.Data;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GetData {
    // Global Variable
    public static Scanner input = new Scanner(System.in);

    public List<List<String>> GetUserData() throws IOException {
        // Variables
        List<List<String>> records = new ArrayList<>();
        String[] values;

        // Getting the File Specified
        FileReader fileReader = new FileReader("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv");

        try (CSVReader csvReader = new CSVReader(fileReader)) {
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            return records;
        }
    }

    public boolean SignUp() {
        String choice;
        System.out.println("User Account not Found, Do you want to Sign Up?: ");
        choice = input.nextLine().toLowerCase();
        return switch (choice.charAt(0)) {
            case 'y' -> true;
            case 'n' -> false;
            default -> false;
        };
    }

    public void AddUserData(String[] credentialData) throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\LGU MACO\\IdeaProjects\\JavaTestSystem\\src\\Users\\Credentials\\Credentials.csv", true);

        try (CSVWriter csvWriter = new CSVWriter(fileWriter)) {
            csvWriter.writeNext(credentialData);
        }
        System.out.println("User Data Successfully Added!");
    }

    public String[][] getCredentials(List<List<String>> records) {
        String[] username = new String[records.size()];
        String[] password = new String[records.size()];
        String[] userID = new String[records.size()];

        for (int i = 0; i < records.size(); i++) {
            username[i] = records.get(i).get(0);
            password[i] = records.get(i).get(1);
            userID[i] = records.get(i).get(2);
        }

        return new String[][]{username, password, userID};
    }

    public int VerificationStatus(String name, String password, String[][] credentials, List<List<String>> records) {
        CredentialVerifier credentialVerifier = new CredentialVerifier();
        return credentialVerifier.checkCredentials(name, password, credentials, records);
    }


    public static class CredentialVerifier {
        public static String userID = "";
        public static String userName = "";

        public static boolean checkUserNameAndPassword(List<List<String>> records, String username, String password) {
            for (int i = 1; i < records.size(); i++) {
                if (Objects.equals(records.get(i).get(0), username) && Objects.equals(records.get(i).get(1), password)) {
                    userID = records.get(i).get(2);
                    userName = records.get(i).get(0);
                    return true;
                }
            }
            return false;
        }

        public static boolean checkIfUserNameIsUsed(String[] userName, String name) {
            for (String s : userName) {
                if (Objects.equals(s, name)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean checkIsPasswordIsUsed(String[] passwordArray, String password) {
            for (String s : passwordArray) {
                if (Objects.equals(s, password)) {
                    return true;
                }
            }
            return false;
        }

        public int checkCredentials(String name, String password, String[][] credentials, List<List<String>> records) {
            if (checkUserNameAndPassword(records, name, password)) {
                return 1;
            } else if (checkIfUserNameIsUsed(credentials[0], name)) {
                return 2;
            } else if (checkIsPasswordIsUsed(credentials[1], password)) {
                return 3;
            }
            return 0;
        }
    }
}

