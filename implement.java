import java.io.*;

class Product implements Serializable {
    private int id;
    private String name;
    private String category;
    private double price;

    
    public Product(int id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: $" + price);
    }
}

public class Main {
    
    public static Product deserializeProduct(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Product product = (Product) in.readObject();
            in.close();
            fileIn.close();
            return product;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        
        Product product = new Product(1, "Laptop", "Electronics", 999.99);
        String fileName = "product.ser";

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(product);
            out.close();
            fileOut.close();
            System.out.println("Product object serialized and saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        System.out.println("\nDeserializing Product object from file...");
        Product deserializedProduct = deserializeProduct(fileName);

        
        if (deserializedProduct != null) {
            System.out.println("\nDeserialized Product details:");
            deserializedProduct.printDetails();
        }
    }
}
