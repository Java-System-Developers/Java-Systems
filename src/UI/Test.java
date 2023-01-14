package UI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        Scanner scanf = new Scanner(System.in);
        DisplayProduct displayProduct = new DisplayProduct();
        Buy store = new Buy();

        int choice, quantity;

        displayProduct.displayProducts(1);

        System.out.print("Which item do you want to buy? No.: ");
        choice = scanf.nextInt();

        System.out.print("How many would you like to buy?: ");
        quantity = scanf.nextInt();

        store.purchaseCSGO(choice, quantity);

    }

}
