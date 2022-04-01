import java.util.Arrays;
import java.util.Scanner;

public class VectorSolver {
    static double x;
    static double y;
    static double r;
    static double angle;
    static double[] startingPosition = new double[2];
    static double[] endingPosition= new double[2];
    public static String[] ways = new String[]{"trig","rect"};
    static int method;
    public static void go(){
        getInputs();
        solve();
        printResults();
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
            System.out.println("What is the angle?");
            angle = results.nextDouble();
            System.out.println("What is the magnitude?");
            r = results.nextDouble();
            System.out.println("What is the starting x?");
            startingPosition[0] = results.nextDouble();
            System.out.println("What is the starting y?");
            startingPosition[1] = results.nextDouble();
        }
        if (method == 1){
            System.out.println("What is the x?");
            x = results.nextDouble();
            System.out.println("What is the y?");
            y = results.nextDouble();
            System.out.println("What is the starting x?");
            startingPosition[0] = results.nextDouble();
            System.out.println("What is the starting y?");
            startingPosition[1] = results.nextDouble();
        }
    }
    public static void solve(){
        if (method == 0 ){
            x = r*cos(angle);
            y = r*sin(angle);
            endingPosition[0] = startingPosition[0]+x;
            endingPosition[1] = startingPosition[1]+y;
        }
        if (method == 1){
            angle = atan(y/x);
            r = Math.sqrt((y*y)+(x*x));
            endingPosition[0] = startingPosition[0]+x;
            endingPosition[1] = startingPosition[1]+y;
        }
    }
    public static void printResults(){
        System.out.println("x:" + x + ",y:" + y);
        System.out.println("Magnitude: "+ r);
        System.out.println("Angle: " + angle);
        System.out.println("Starting position: (" + startingPosition[0] + "," + startingPosition[1] + ")");
        System.out.println("Ending position: (" + endingPosition[0] + "," + endingPosition[1] + ")");
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
    public static double atan(double number){
        return Math.toDegrees(Math.atan(number));
    }}
