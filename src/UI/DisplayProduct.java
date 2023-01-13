package UI;

// Imports

import Database.ProductDatabase;

import java.io.IOException;
import java.util.List;

public class DisplayProduct {
    public void DisplayProducts(int choice) throws IOException {
        // Variables
        ProductDatabase productDatabase = new ProductDatabase();
        List<List<String>> menu = productDatabase.Products(choice);

        System.out.printf("\t%50s\t%50s\t%50s\n\n", menu.get(0).get(0), menu.get(0).get(1), menu.get(0).get(2));
        for (int i = 1; i < menu.size(); i++) {
            System.out.printf("%5d.", i);
            for (int j = 0; j < menu.get(i).size(); j++) {
                System.out.printf("\t\t%50s", menu.get(i).get(j));
            }
            System.out.println();
        }
    }
}
