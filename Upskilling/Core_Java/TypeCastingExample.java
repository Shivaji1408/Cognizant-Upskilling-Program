public class TypeCastingExample {
    public static void main(String[] args) {

        double num1 = 15.89;
        int intValue = (int) num1;

        System.out.println("Double Value : " + num1);
        System.out.println("After Casting to int : " + intValue);

        int num2 = 25;
        double doubleValue = (double) num2;

        System.out.println("Integer Value : " + num2);
        System.out.println("After Casting to double : " + doubleValue);
    }
}