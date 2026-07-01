import java.util.Scanner;

public class StringReversal {
    
    // First Approach
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder(str);

        System.out.println("Reversed String: " + sb.reverse());

        sc.close();

        // Second Approach
        
        // Scanner sc = new Scanner(System.in);

        // System.out.print("Enter a string: ");
        // String str = sc.nextLine();

        // String reversed = "";

        // for (int i = str.length() - 1; i >= 0; i--) {
        //     reversed += str.charAt(i);
        // }

        // System.out.println("Reversed String: " + reversed);

        // sc.close();
    }

    
}