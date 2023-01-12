package UI;

// Imports
import Database.ProductDatabase;
import java.io.IOException;
import java.util.List;

public class DemoUI {
    public static void main(String[] args) throws IOException {
        // Variables
        ProductDatabase productDatabase = new ProductDatabase();
        List<List<String>> menu = productDatabase.getValues();

        for (int i = 0; i < menu.size(); i++) {
            for (int j = 0; j < menu.get(i).size(); j++) {
                System.out.printf("\t%40s", menu.get(i).get(j));
//                System.out.print(menu.get(i).get(j) + "\t\t\t\t\t\t\t\t\t");
            }
            System.out.println();
        }
    }
}
