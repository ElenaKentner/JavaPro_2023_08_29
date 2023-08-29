package _2023_08_29.task;

import java.util.List;

class OrderProcessor {
    private Kitchen kitchen;

    public OrderProcessor(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void processOrder(Order order) {
        List<Dish> dishList = order.getDishes();
        order.setStatus(Status.COOKING);
        for (Dish dish : dishList ) {
            kitchen.cookDish(dish);
        }

    }
}
