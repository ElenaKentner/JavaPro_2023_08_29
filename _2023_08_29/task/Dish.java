package _2023_08_29.task;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
class Dish {
    private String name;

    private long preparationTime; // in milliseconds

}