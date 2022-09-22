package model.entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double amount;
    private double quantity;

    public Product(String name, double amount, double quantity) {
        this.name = name;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double totalAmount(){
        return amount * quantity;
    }

    public static List<Product> productsFileConvert(String strPath){
        List<Product> products = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(strPath))) {
            
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] dataLine = line.split(",");
                String name = dataLine[0];
                double amount = Double.parseDouble(dataLine[1]);
                double quantity = Double.parseDouble(dataLine[2]);
                products.add(new Product(name, amount, quantity));
                line = bufferedReader.readLine();
            }

            return products;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return products = null;
        }
        
    }

    public static void productsFileWrite(String strSubDir, List<Product> products){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(strSubDir))) {
            for (Product product : products) {
                bw.write(product.getName() + ", " + product.totalAmount());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return name + ", " + amount + ", " + quantity;
    }
}
