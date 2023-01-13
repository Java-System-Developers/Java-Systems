import UI.DisplayProduct;

import java.io.IOException;

/*
* This just runs the process, and not actually doing any process itself
*/
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hi Lance Gwapo");
        DisplayProduct displayProduct = new DisplayProduct();
        displayProduct.DisplayProducts(1);
    }
}