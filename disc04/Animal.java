public class Animal {
2 protected String name, noise;
3 protected int age;
4
        5 public Animal(String name, int age) {
        6 this.name = name;
        7 this.age = age;
        8 this.noise = "Huh?";
        9 }
10
        11 public String makeNoise() {
        12 if (age < 5) {
            13 return noise.toUpperCase();
            14 } else {
            15 return noise;
            16 }
        17 }
18
        19 public void greet() {
        20 System.out.println("Animal " + name + " says: " + makeNoise());
        21 }
22 }
