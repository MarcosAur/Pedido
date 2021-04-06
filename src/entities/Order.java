/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enuns.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author default
 */
public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> itens = new ArrayList();
    private Client client;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItens() {
        return itens;
    }

    public Client getClient() {
        return client;
    }
    
    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String text = "";
        double totalPrice = 0;
        for (OrderItem item : itens){
            text += item.getProduct().getName() +", "+ item.getProduct().getPrice()+ 
                    ", Quantity: " + item.getQuantity() + ", Subtotal: " + item.subTotal() + "\n";
            totalPrice += item.subTotal();
        }
        return "Order Moment: " + sdf.format(moment)
                +"\nOrder Status: " + status
                +"\nClient: " + client.getName() + " " + client.getBirthDate() + " - " + client.getEmail() 
                +"\nOrder Itens: "
                +"\n" + text
                +"\nTotal price: $" + String.format("%.2f",totalPrice);
    }
    
    
}
