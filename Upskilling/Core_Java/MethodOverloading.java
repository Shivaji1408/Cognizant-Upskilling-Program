public class MethodOverloading {

    // Method for two integers
    static int add(int a, int b) {
        return a + b;
    }

    // Method for two doubles
    static double add(double a, double b) {
        return a + b;
    }

    // Method for three integers
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        System.out.println("Sum of two integers: " + add(10, 20));
        System.out.println("Sum of two doubles: " + add(12.5, 7.8));
        System.out.println("Sum of three integers: " + add(5, 10, 15));

    }
}