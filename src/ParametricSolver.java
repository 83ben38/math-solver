import java.util.Arrays;
import java.util.Scanner;

public class ParametricSolver{
    static double rate;
    static double time;
    static double angle;
    static double startingY;
    static double startingX;
    static String xEquation;
    static String yEquation;
    static double x;
    static double y;
    static double wind;
    public static String[] ways = new String[]{"posAtTime","groundHitTime","maxHeight", "heightAtDistance"};
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
            System.out.println("What is the rate?");
            rate = results.nextDouble();
            System.out.println("What is the angle?");
            angle = results.nextDouble();
            System.out.println("What is the time");
            time = results.nextDouble();
            System.out.println("What is the starting x?");
            startingX = results.nextDouble();
            System.out.println("What is the starting y?");
            startingY = results.nextDouble();
            System.out.println("What is the wind?");
            wind = results.nextDouble();
        }
        if (method == 1 || method == 2){
            System.out.println("What is the rate?");
            rate = results.nextDouble();
            System.out.println("What is the angle?");
            angle = results.nextDouble();
            System.out.println("What is the starting x?");
            startingX = results.nextDouble();
            System.out.println("What is the starting y?");
            startingY = results.nextDouble();
            System.out.println("What is the wind?");
            wind = results.nextDouble();
        }
        if (method == 3){
            System.out.println("What is the rate?");
            rate = results.nextDouble();
            System.out.println("What is the angle?");
            angle = results.nextDouble();
            System.out.println("What is the starting x?");
            startingX = results.nextDouble();
            System.out.println("What is the starting y?");
            startingY = results.nextDouble();
            System.out.println("What is the wind?");
            wind = results.nextDouble();
            System.out.println("What is the x?");
            x = results.nextDouble();
        }
    }
    public static void solve(){
        if(method == 3){
            time = (x-startingX)/(rate*cos(angle) + wind);
        }
        if(method == 1){
            double i = 1;
            double s = 1;
            while (Math.abs(-16 * i * i + rate * sin(angle) * i + startingY) > 0.001) {
                while (-16 * i * i + rate * sin(angle) * i + startingY > 0) {
                    i += s;
                }
                s*=0.1;
                while (-16 * i * i + rate * sin(angle) * i + startingY < 0) {
                    i -= s;
                }
                s*=0.1;
            }
            time = i;
        }
        if(method == 2){
            double i = 1;
            double max = startingY;
            double s = 1;
            while (s > 0.0000001) {
                while (-16 * i * i + rate * sin(angle) * i + startingY > max){
                    max = -16 * i * i + rate * sin(angle) * i + startingY;
                    i += s;
                }
                i-=s;
                s*=0.1;
                while (-16 * i * i + rate * sin(angle) * i + startingY > max){
                    max = -16 * i * i + rate * sin(angle) * i + startingY;
                    i += s;
                }
                i-=s;
                s*=0.1;
            }
            time = i;
        }
        if (method == 0  || method == 1 || method == 2 || method == 3){
            x = (rate*cos(angle) + wind)*time + startingX;
            y = -16*time*time + rate*sin(angle)*time + startingY;
            xEquation = (rate*cos(angle) + wind) + "t";
            yEquation = "-16t^2+" + (rate*sin(angle)) + "t+" + startingY;
        }
    }
    public static void printResults(){
        System.out.println("x: " + x + ",y:" + y);
        System.out.println("Angle: " + angle);
        System.out.println("time: "+ time);
        System.out.println("Rate: " + rate);
        System.out.println("starting x: " + startingX + " starting y: " + startingY);
        System.out.println("X equation: " + xEquation);
        System.out.println("Y equation: " + yEquation);
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
    }
}
