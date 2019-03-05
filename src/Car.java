import org.junit.Test;

class Car extends Vehicle {
    public static void main(String[] args) {
        new Car().run();

        String s = "hello world";
        s = s + 100;
        System.out.println(s);

    }

    private final void run() {
        System.out.println("Car");
    }

    @Test
    public void test() {
        System.out.println();
    }
}

class Vehicle {
    private final void run() {
        System.out.println("Vehicle");
    }


}
