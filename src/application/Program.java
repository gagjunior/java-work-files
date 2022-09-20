package application;

import model.entities.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Digite o caminho do arquivo de entrada: ");
        String path = sc.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String name = dataLine[0];
                double amount = Double.parseDouble(dataLine[1]);
                double quantity = Double.parseDouble(dataLine[2]);
                products.add(new Product(name, amount, quantity));
                line = bufferedReader.readLine();
            }

            for (Product product : products) {
                System.out.println(product);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
