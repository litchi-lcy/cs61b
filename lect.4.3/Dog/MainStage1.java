public class MainStage1 {
    public static Dog maxDog(Dog[] dogs) {
        if (dogs == null || dogs.length == 0) {
            return null;
        }
        Dog max = dogs[0];
        for (Dog d : dogs) {
            if (d.size > max.size) {
                max = d;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog("Elyse", 3),
                new Dog("Sture", 9),
                new Dog("Benjamin", 15)
        };

        Dog largest = maxDog(dogs);
        System.out.println("largest dog is: " + largest);
        largest.bark();
    }
}