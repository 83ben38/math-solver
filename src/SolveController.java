import java.util.Scanner;

public class SolveController {
    public static void main(String[] args) {
        go();
    }
    public static void go(){
        ParametricSolver.go();
        System.out.println("Would you like to do another one?");
        if (getYesOrNo()) {
            go();
        }
    }
    public static boolean getYesOrNo(){
        return !new Scanner(System.in).next().equalsIgnoreCase("no");
    }
}
