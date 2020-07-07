package application_polymorphism_product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			System.out.println("Product #"+ i + " data: ");
			System.out.print("Common, used or imported (c/u/i) ?");
			char chr = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String np = sc.nextLine();
			
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (chr == 'i') {
				
				System.out.print("Customs fee: ");
				double cf = sc.nextDouble();
				list.add(new ImportedProduct(np, price, cf));
				
			} else if(chr == 'u') {
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				Date date = sdf.parse(sc.nextLine());
				list.add(new UsedProduct(np, price, date));
				
			} else if (chr == 'c') {
				list.add(new Product(np, price));
			}
			
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		sc.close();

	}

}
