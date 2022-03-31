import java.util.Arrays;
import java.util.Scanner;


public class TriangleSolver {
    public static double C;
    public static double A;
    public static double B;
    public static double c;
    public static double b;
    public static double a;
    public static int method;
    public static String[] ways = new String[]{"AAS", "SSA", "SAS", "SSS"};
    public static void go(){
        getInputs();
        solve();
        printResults();
        System.out.println("Would you like to do another one?");
        if (getYesOrNo()) {
            go();
        }
    }
    public static void getInputs(){
        System.out.println("Which method are you solving with?");
        Scanner results = new Scanner(System.in);
        String stuff = results.next();
        while (!Arrays.asList(ways).contains(stuff)){
            System.out.println("Which method are you solving with?");
            stuff = results.next();
        }
        method = Arrays.asList(ways).indexOf(stuff);
        if (method == 0){
            System.out.println("What is the first angle?");
            A = results.nextDouble();
            System.out.println("What is the second angle?");
            B = results.nextDouble();
            System.out.println("What is the side?");
            a = results.nextDouble();
        }
        else if (method == 1){
            System.out.println("What is the first side?");
            c = results.nextDouble();
            System.out.println("What is the second side?");
            b = results.nextDouble();
            System.out.println("What is the angle?");
            B = results.nextDouble();
        }
        else if (method == 2){
            System.out.println("What is the first side?");
            c = results.nextDouble();
            System.out.println("What is the second side?");
            b = results.nextDouble();
            System.out.println("What is the angle?");
            A = results.nextDouble();
        }
        else if (method == 3){
            System.out.println("What is the first side?");
            c = results.nextDouble();
            System.out.println("What is the second side?");
            b = results.nextDouble();
            System.out.println("What is the last side?");
            a = results.nextDouble();
        }
    }
    public static void solve(){
        if (method == 0){
            double F = sin(A)/a;
            System.out.println(F);
            C = 180-(A+B);
            c = sin(C)/F;
            b = sin(B)/F;
        }
        else if (method == 1){
            double F = sin(B)/b;
            C = asin(F*c);
            A = 180 - (C+B);
            a = sin(A)/F;
        }
        else if (method == 2){
            a = Math.sqrt((b*b)+(c*c)-(2*b*c*cos(A)));
            double F = sin(A)/a;
            C = asin(F*c);
            B = asin(F*b);
        }
        else if (method == 3){
            A = acos(((b*b)+(c*c)-(a*a))/(2*b*c));
            double F = sin(A)/a;
            C = asin(F*c);
            B = asin(F*b);
        }
    }
    public static void printResults(){
        if (Double.isNaN(a) || Double.isNaN(b)|| Double.isNaN(c)|| Double.isNaN(A)|| Double.isNaN(B)|| Double.isNaN(C) || a < 0 || b < 0 || c < 0 || A < 0 || B < 0 || C < 0){
            System.out.println("This triangle does not exist.");
            return;
        }
        System.out.println("Sides: " + a + "," + b + "," + c);
        System.out.println("Angles (corresponding): " + A + "," + B + "," + C);
    }
    public static double sin(double number){
        return Math.sin(Math.toRadians(number));
    }
    public static double asin(double number){
        return Math.toDegrees(Math.asin(number));
    }
    public static double cos(double number){
        return Math.cos(Math.toRadians(number));
    }
    public static double acos(double number){
        return Math.toDegrees(Math.acos(number));
    }
    public static boolean getYesOrNo(){
        return !new Scanner(System.in).next().equalsIgnoreCase("no");
    }
}
