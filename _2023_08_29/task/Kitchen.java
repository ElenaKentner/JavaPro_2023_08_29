package _2023_08_29.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Ваша задача - разработать систему обработки заказов в ресторане, используя многопоточность и соответствующие механизмы,
такие как ThreadPool, wait, notifyAll и interrupt.

Создайте класс Order, который представляет заказ в ресторане.
У заказа должен быть уникальный идентификатор, состоящий из буквы "O" и номера (например, "O123").
Заказ также должен иметь статус (новый, готовится, готов) и список блюд.

Создайте класс Dish, представляющий отдельное блюдо.
У каждого блюда должно быть имя и время приготовления в миллисекундах.

Разработайте класс Kitchen, который будет имитировать работу кухни в ресторане.
У кухни есть повара, которые готовят блюда. Используйте ThreadPool для ограничения количества одновременно работающих поваров.

Создайте класс OrderProcessor, который будет получать заказы и передавать их на кухню для приготовления.
Этот класс также будет имитировать ожидание приготовления блюд и изменение статуса заказа.

Реализуйте механизмы wait и notifyAll для синхронизации работы между классами Kitchen и OrderProcessor.
Когда заказ передается на кухню, он должен перейти в статус "готовится", а потом "готов", как только все блюда будут приготовлены.

Добавьте обработку прерывания потоков в случае,
если заказу требуется время для готовности (например, блюда не готовятся более определенного времени).
 */
class Kitchen {
    private final ExecutorService chefThreadPool;

    public Kitchen(int chefCount) {
        chefThreadPool = Executors.newFixedThreadPool(chefCount);
    }

    public void cookDish(Dish dish) {
        chefThreadPool.execute(() -> {
            try {
                Thread.sleep(dish.getPreparationTime());
                System.out.println(Thread.currentThread().getName() + ": cooking");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }


    public void shutdown() {
        chefThreadPool.shutdown();
    }
}
