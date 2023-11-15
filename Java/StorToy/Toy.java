public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;
    private boolean isPrize;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.isPrize = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getIsPrize() {
        return isPrize;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIsPrize(boolean isPrize) {
        this.isPrize = isPrize;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Название: " + name);
        System.out.println("Количество: " + quantity);
        System.out.println("Вес: " + weight + "%");
        System.out.println("Приз: " + isPrize);
    }
}
