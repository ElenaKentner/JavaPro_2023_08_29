package _2023_08_29.task;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {
        Dish pasta = new Dish("pasta", 2000);
        Dish salad = new Dish("salad", 1500);
        Dish soup = new Dish("soup", 3000);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(pasta);
        dishes.add(salad);
        dishes.add(soup);

        Order order = new Order("O1", dishes, Status.NEW);

        Kitchen kitchen = new Kitchen(2);
        OrderProcessor orderProcessor = new OrderProcessor(kitchen);

        System.out.println("Order " + order.getId() + " new.");
        orderProcessor.processOrder(order);
        System.out.println("Order " + order.getId() + " ready.");
        kitchen.shutdown();
    }
}

