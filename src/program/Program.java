/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author default
 */
public class Program {

    public static void main(String args[]) {
        //Objetos
        Locale.setDefault(Locale.US);
        //Programa
        try (Scanner sc = new Scanner(System.in)) {
            //Programa
            System.out.println("Enter client data:");
            
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            
            System.out.print("Email: ");
            String email = sc.nextLine();
            
            System.out.print("Birth date (DD/MM/YYYY): ");
            String birthDate = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse(birthDate);
            
            Client client = new Client(nome, email, d);
            
            System.out.println("Enter order data: ");
            System.out.print("Status: ");
            String status = sc.nextLine();
            
            System.out.print("How many items to this order: ");
            int repeticoes = sc.nextInt();
            
            Order order = new Order(new Date(), OrderStatus.valueOf(status) , client);
            
            for (int cont = 1; cont<=repeticoes; cont++){
                System.out.println("Enter #"+ cont+" item data:");
                System.out.print("Product name: ");
                sc.nextLine();
                String productName = sc.nextLine();
                System.out.print("Product price: ");
                double productPrice = sc.nextDouble();
                System.out.print("Product quantity: ");
                int productQuantity = sc.nextInt();
                order.addItem(new OrderItem(productQuantity, new Product(productName, productPrice) ));
            }
            System.out.println("\nORDER SUMMARY:");
            System.out.println(order);
            
        } catch (ParseException ex) {
            Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
