import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ToyStore {
    private ArrayList<Toy> toys;
    private ArrayList<Toy> prizes;
    private String fileName;

    public ToyStore(String fileName) {
        toys = new ArrayList<Toy>();
        prizes = new ArrayList<Toy>();
        this.fileName = fileName;
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void changeWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void raffle() {
        Random random = new Random();
        double number = random.nextDouble() * 100;
        double sum = 0;
        for (Toy toy : toys) {
            sum += toy.getWeight();
            if (sum >= number) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    prizes.add(toy);
                    System.out.println("Вы выиграли игрушку: " + toy.getName());
                } else {
                    System.out.println("К сожалению, такая игрушка закончилась: " + toy.getName());
                }
                break;
            }
        }
    }

    public void getPrize() {
        if (prizes.size() > 0) {
            Toy toy = prizes.get(0);
            prizes.remove(0);
            writeToFile(toy);
            System.out.println("Вы получили игрушку: " + toy.getName());
        } else {
            System.out.println("К сожалению, призовые игрушки закончились.");
        }
    }

    private void writeToFile(Toy toy) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            writer.write("ID: " + toy.getId() + "\n");
            writer.write("Название: " + toy.getName() + "\n");
            writer.write("Вес: " + toy.getWeight() + "%\n");
            writer.write("--------------------\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void printAllToys() {
        System.out.println("Все игрушки в магазине:");
        for (Toy toy : toys) {
            toy.printInfo();
            System.out.println("--------------------");
        }
    }

    public void printPrizeToys() {
        System.out.println("Призовые игрушки в магазине:");
        int prizeCount = 0;
        for (Toy toy : toys) {
            if (toy.getIsPrize()) {
                toy.printInfo();
                prizeCount++;
                System.out.println("--------------------");
            }
        }
        System.out.println("Всего призовых игрушек: " + prizeCount);
    }

    public Toy getToyById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

}