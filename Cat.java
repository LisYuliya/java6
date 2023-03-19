import java.util.Random;

public class Cat {
    private String name;
    private int appetite;
    private int satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = 0;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite - satiety) {
            plate.decreaseFood(appetite - satiety);

            System.out.println(name + " ate " + (appetite - satiety));
            satiety += appetite - satiety;
            System.out.println("Current level of satiety: " + satiety);
        } else {
            System.out.println(name + " cannot eat, there is not enough food in the plate.");
        }

    }

    public int getSatiety() {
        return satiety;
    }

    public void decreaseSatiety() {
        if (satiety > 0) {
            Random random = new Random();
            satiety -= random.nextInt(5) + 1;
        }
    }

}
