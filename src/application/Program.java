package application;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import model.entities.Product;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o caminho do arquivo de entrada: ");
        String strPath = sc.nextLine();
        
        List<Product> products = Product.productsFileConvert(strPath);

        File path = new File(strPath);
        String originalDir = path.getParent();
        boolean success = new File(originalDir + "//out").mkdir();

        System.out.println("Diretorio criado? " + success);

        String strSubDir = originalDir + "//out//summary.csv";

        Product.productsFileWrite(strSubDir, products);

        sc.close();
    }
}
