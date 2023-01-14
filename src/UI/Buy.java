package UI;

import Database.ProductDatabase;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Buy {

    public void purchaseCSGO(int choice, int quantity) throws IOException {

        ProductDatabase productDatabase = new ProductDatabase();
        List<List<String>> menu = productDatabase.Products(1);
        Scanner scanf;
        String tempFile = "temp.txt";
        File oldFile = new File("C:\\Users\\bajed\\IdeaProjects\\BootlegSteamMarket\\src\\Database\\Games\\CSGO.csv");
        File newFile = new File(tempFile);

        String newQty = "" + (Integer.parseInt(menu.get(choice).get(1)) - quantity);

        String itemName, itemQty, price;

        try{
            FileWriter fileWriter = new FileWriter(tempFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            scanf = new Scanner(new File("C:\\Users\\bajed\\IdeaProjects\\BootlegSteamMarket\\src\\Database\\Games\\CSGO.csv"));
            scanf.useDelimiter("[,\n]");

            while(scanf.hasNext()){
                itemName = scanf.next();
                itemQty = scanf.next();
                price = scanf.next();

                if(itemName.equals(menu.get(choice).get(0))){
                    printWriter.print(itemName + "," + newQty + "," + price);
                }else{
                    printWriter.print(itemName + "," + itemQty + "," + price);
                }
            }

            scanf.close();
            printWriter.flush();
            printWriter.close();
            oldFile.delete();
            File dump = new File("C:\\Users\\bajed\\IdeaProjects\\BootlegSteamMarket\\src\\Database\\Games\\CSGO.csv");
            newFile.renameTo(dump);

        }catch(Exception e){
            System.out.println("Error");
        }

    }

}
