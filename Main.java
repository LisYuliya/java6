
// Кот (имя, аппетит, сытность)
// Тарелка (содержит какое-то количество еды)
// Кот ест из тарлеки. Если в тарелке недостаточно еды - кот ее не трогает

// ДЗ:
// while (true) -> while (!plate.isEmpty())
// 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
// В конце каждого цикла мы досыпаем в тарелку еду.
// Для досыпания еды сделать метод increaseFood в классе Plate.
// 2. Поменять поле satiety у кота с boolean на int.
// Допустим у кота апптит 10, сытность 3. Значит кот захочет поесть 7 единиц.
// 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.// Кот (имя, аппетит, сытность)

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 7),
                new Cat("Pushok", 10)
        };
        Plate plate = new Plate(20);

        while (!plate.isEmpty()) {
            System.out.println("Plate: " + plate.getFood());

            boolean allSatiated = true;

            for (Cat cat : cats) {
                if (cat.getSatiety() < cat.getAppetite()) {
                    System.out.println(cat.getName() + ": appetite=" + cat.getAppetite() +
                            ", satiety=" + cat.getSatiety());

                    cat.eat(plate);

                    if (cat.getSatiety() >= cat.getAppetite()) {
                        System.out.println(cat.getName() + " is satiated.");
                    }

                    allSatiated &= (cat.getSatiety() >= cat.getAppetite());
                }
                cat.decreaseSatiety();
            }

            if (allSatiated) {
                System.out.println("All cats are satiated.");
                break;
            }

            plate.increaseFood();
            Thread.sleep(1000);
            System.out.println("");
        }
        System.out.println("Plate is empty.");
    }
}