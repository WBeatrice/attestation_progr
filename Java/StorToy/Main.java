import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore("prizes.txt");

        store.addToy(1, "Мяч", 10, 20);
        store.addToy(2, "Кукла", 5, 10);
        store.addToy(3, "Машинка", 7, 15);
        store.addToy(4, "Кубики", 12, 25);

        store.getToyById(1).setIsPrize(true);
        store.getToyById(4).setIsPrize(true);

        store.changeWeight(2, 12.5);

        store.raffle();

        store.getPrize();

        store.printAllToys();

        store.printPrizeToys();

    }

}
