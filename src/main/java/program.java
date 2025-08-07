import java.util.ArrayList;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        // This is a placeholder for the main method.
        // You can add code here to initialize your application or run tests.
        System.out.println("Hello, World! This is a placeholder for the main method.");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        char[] array = word.toCharArray();
        for(int i =0;i<array.length;i++) {
            int count = 0;
            for(int j =0;j<array.length;j++) {

                if(array[i]==array[j]) {
                    count++;
                }

            }
            if(count==1) {
                System.out.println(array[i]);
            }
        }

    }
}
