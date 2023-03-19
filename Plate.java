import java.util.Random;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }

    public void increaseFood() {
        Random random = new Random();
        int amount = random.nextInt(10) + 1;
        food += amount;
        System.out
                .println("Added " + amount + " units of food to the plate. The plate now contains " + food + " units.");
    }

    public boolean isEmpty() {
        return food == 0;
    }

}