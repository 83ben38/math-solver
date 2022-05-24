import java.util.Scanner;

public class SolveController {
    public static void main(String[] args) {
        go();
    }
    public static void go(){
        System.out.println("Which solver would you like?");
        String answer = new Scanner(System.in).next();
        if (answer.equals("parametric")) {
            ParametricSolver.go();
        }
        if (answer.equals("vector")){
            VectorSolver.go();
        }
        if (answer.equals("triangle")){
            TriangleSolver.go();
        }
        if (answer.equals("equation")){
            EquationSolver.go();
        }
        if (answer.equals("quad")){
            QuadSolver.go();
        }
        System.out.println("Would you like to do another one?");
        if (getYesOrNo()) {
            go();
        }
    }
    public static boolean getYesOrNo(){
        return !new Scanner(System.in).next().equalsIgnoreCase("no");
    }
}
