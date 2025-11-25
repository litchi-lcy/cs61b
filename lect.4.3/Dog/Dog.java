public class Dog {
    public String name;
    public int size;
    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark() {
        System.out.println(name + "says:bark");
    }

    public String toString() {
        return name + " (size=" + size + ")";
    }
}