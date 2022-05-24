

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class EquationSolver {
    public static ArrayList<Double> answers = new ArrayList<>();
    public static int answerAmount;
    public static double starter;
    public static String equation;
    public static void go(){
        getInputs();
        solve();
        printResults();
    }
    public static void getInputs(){
        System.out.println("What is the equation?");
        Scanner results = new Scanner(System.in);
        equation = results.next();
        System.out.println("How many answers would you like?");
        answerAmount = results.nextInt();
        System.out.println("What is the minimal answer?");
        starter = results.nextInt();
    }
    public static void solve(){
        equation = "((" + equation.substring(0,equation.indexOf("=")) + ")-(" + equation.substring(equation.indexOf("=")+1) + "))";
        ArrayList<Operator> operators = new ArrayList<>();
        operators.add(EquationSolver::sin);
        equation = equation.replaceAll("sin", Matcher.quoteReplacement("$0"));
        operators.add(EquationSolver::cos);
        equation = equation.replaceAll("cos", Matcher.quoteReplacement("$1"));
        operators.add(EquationSolver::asin);
        equation = equation.replaceAll("asin",Matcher.quoteReplacement("$2"));
        operators.add(EquationSolver::acos);
        equation = equation.replaceAll("acos",Matcher.quoteReplacement("$3"));
        while (getInnerMostParentheses() > -1){
            int s = getInnerMostParentheses();
            String workWith = equation.substring(s+1);
            workWith = workWith.substring(0,workWith.indexOf(")"));
            if (workWith.equals("x")){
                operators.add(input -> input);
            }
            else if (workWith.contains("+")){
                String part1 = workWith.substring(0,workWith.indexOf("+"));
                String part2 = workWith.substring(workWith.indexOf("+")+1);
                if (part1.contains("$")){
                    int index = Integer.parseInt(part1.substring(1));
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> operators.get(index).result(input) + operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> operators.get(index).result(input) + input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> operators.get(index).result(input) + index2);
                    }
                }
                else if (part1.contains("x")){
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> input + operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> input + input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> input + index2);
                    }
                }
                else{
                    int index1 = Integer.parseInt(part1);
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> index1 + operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> index1 + input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> index1 + index2);
                    }
                }
            }
            else if (workWith.contains("*")){
                String part1 = workWith.substring(0,workWith.indexOf("*"));
                String part2 = workWith.substring(workWith.indexOf("*")+1);
                if (part1.contains("$")){
                    int index = Integer.parseInt(part1.substring(1));
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> operators.get(index).result(input) * operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> operators.get(index).result(input) * input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> operators.get(index).result(input) * index2);
                    }
                }
                else if (part1.contains("x")){
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> input * operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> input * input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> input * index2);
                    }
                }
                else{
                    int index1 = Integer.parseInt(part1);
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> index1 * operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> index1 * input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> index1 * index2);
                    }
                }
            }
            else if (workWith.contains("-")){
                String part1 = workWith.substring(0,workWith.indexOf("-"));
                String part2 = workWith.substring(workWith.indexOf("-")+1);
                if (part1.contains("$")){
                    int index = Integer.parseInt(part1.substring(1));
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> operators.get(index).result(input) - operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> operators.get(index).result(input) - input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> operators.get(index).result(input) - index2);
                    }
                }
                else if (part1.contains("x")){
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> input - operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> input - input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> input - index2);
                    }
                }
                else{
                    int index1 = Integer.parseInt(part1);
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> index1 - operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> index1 - input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> index1 - index2);
                    }
                }
            }
            else if (workWith.contains("/")){
                String part1 = workWith.substring(0,workWith.indexOf("/"));
                String part2 = workWith.substring(workWith.indexOf("/")+1);
                if (part1.contains("$")){
                    int index = Integer.parseInt(part1.substring(1));
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> operators.get(index).result(input) / operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> operators.get(index).result(input) / input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> operators.get(index).result(input) / index2);
                    }
                }
                else if (part1.contains("x")){
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> input / operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> input / input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> input / index2);
                    }
                }
                else{
                    int index1 = Integer.parseInt(part1);
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> index1 / operators.get(index2).result(input));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> index1 / input);
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> index1 / index2);
                    }
                }
            }
            else if (workWith.contains("^")){
                String part1 = workWith.substring(0,workWith.indexOf("^"));
                String part2 = workWith.substring(workWith.indexOf("^")+1);
                if (part1.contains("$")){
                    int index = Integer.parseInt(part1.substring(1));
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> Math.pow(operators.get(index).result(input),  operators.get(index2).result(input)));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> Math.pow(operators.get(index).result(input) , input));
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> Math.pow(operators.get(index).result(input) , index2));
                    }
                }
                else if (part1.contains("x")){
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> Math.pow(input , operators.get(index2).result(input)));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> Math.pow(input , input));
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> Math.pow(input , index2));
                    }
                }
                else{
                    int index1 = Integer.parseInt(part1);
                    if (part2.contains("$")){
                        int index2 = Integer.parseInt(part2.substring(1));
                        operators.add(input -> Math.pow(index1 , operators.get(index2).result(input)));
                    }
                    else if (part2.contains("x")){
                        operators.add(input -> Math.pow(index1 , input));
                    }
                    else{
                        int index2 = Integer.parseInt(part2);
                        operators.add(input -> Math.pow(index1 , index2));
                    }
                }
            }
            else if (workWith.indexOf("$") != workWith.lastIndexOf("$") && workWith.contains("$")){
                int part1 = Integer.parseInt(workWith.substring(1,workWith.lastIndexOf("$")));
                int part2 = Integer.parseInt(workWith.substring(workWith.lastIndexOf("$")+1));
                operators.add(input -> operators.get(part1).result(operators.get(part2).result(input)));
            }
            workWith = equation.substring(s);
            workWith = workWith.substring(0,workWith.indexOf(")")+1);
            String replacement = "$" + (operators.size()-1);
            equation = equation.replace(workWith,replacement);
        }
        int d = Integer.parseInt(equation.substring(1));
        for (int i = 0; i < answerAmount; i++) {
            double z = starter;
            double s = 1;
            if (operators.get(d).result(z) > 0) {
                s = 10;
            }
            while (Math.abs(operators.get(d).result(z)) > 0.0000001) {
                while (operators.get(d).result(z) > 0) {
                    z += s;
                }
                s *= 0.1;
                while (operators.get(d).result(z) < 0) {
                    z -= s;
                }
                s *= 0.1;
            }
            answers.add(z);
            starter = z;
            while (Math.abs(operators.get(d).result(starter)) <= 0.0000001) {
                starter += 0.001;
            }
        }
    }
    public static int getInnerMostParentheses(){
        int s = 0;
        int d = 0;
        int e = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '('){
                s++;
            }
            if (equation.charAt(i) == ')'){
                s--;
            }
            if (s > d){
                d = s;
                e = i;
            }
        }
        if (d != 0) {
            return e;
        }
        else{
            return -1;
        }
    }
    public static void printResults(){
        System.out.println("The solution(s) to this equation are: ");
        for (Double integer : answers) {
            System.out.println(integer);
        }
    }
    public static double sin(double number){
        return Math.sin(number);
    }
    public static double asin(double number){
        return Math.asin(number);
    }
    public static double cos(double number){
        return Math.cos(number);
    }
    public static double acos(double number){
        return Math.acos(number);
    }
}
