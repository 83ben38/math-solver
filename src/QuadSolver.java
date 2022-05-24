import java.util.Arrays;
import java.util.Scanner;

public class QuadSolver {
    static double a;
    static double b;
    static double c;
    static double answer1;
    static double answer2;
    public static void go(){
        getInputs();
        solve();
        printResults();
    }
    public static void getInputs(){
        System.out.println("A?");
        Scanner results = new Scanner(System.in);
        a = results.nextInt();
        System.out.println("B?");
        b = results.nextInt();
        System.out.println("C?");
        c = results.nextInt();
    }
    public static void solve(){
        answer1 = (-b+Math.sqrt((b*b)-(4*a*c)))/(2*a);
        answer2 = (-b-Math.sqrt((b*b)-(4*a*c)))/(2*a);
    }
    public static void printResults(){
        System.out.println("answers: " + answer1 +"," + answer2);
    }
}
