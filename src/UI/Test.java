package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanf = new Scanner(System.in);
        List<List<String>> products = new ArrayList<>();
        List<String> item = new ArrayList<>();
        int i = 0;


        item.add("Manifold Paradox");
        item.add("Phantom Assassin");
        item.add("Arcana");

        products.add(0, item);

        System.out.println(products);

        item = new ArrayList<>();

        item.add("Magus Apex");
        item.add("Invoker");
        item.add("Immortal");

        products.add(1, item);

        System.out.println(products);

        products.remove(0);

        System.out.println(products);




    }

}
