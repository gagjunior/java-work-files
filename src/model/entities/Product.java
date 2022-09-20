package model.entities;

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

    @Override
    public String toString() {
        return name + ", " + amount + ", " + quantity;
    }
}
