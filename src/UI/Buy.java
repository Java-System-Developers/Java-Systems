package UI;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Buy {

    public void purchase(int choice, int quantity) throws IOException {

        FileWriter filewriter = new FileWriter("C:\\Users\\bajed\\IdeaProjects\\BootlegSteamMarket\\src\\Database\\Games\\CSGO.csv", true);

        quantity++;

        try(CSVWriter csvWriter = new CSVWriter(filewriter)){

        }catch(Exception ignored){

        }


    }

}
