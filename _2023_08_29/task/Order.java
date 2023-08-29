package _2023_08_29.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
class Order {
    private String id;
    private List<Dish> dishes;

    @Setter
    private Status status;

    public void addDish(Dish dish) {
        dishes.add(dish);
    }
}

