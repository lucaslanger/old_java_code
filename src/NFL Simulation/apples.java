import java.util.Scanner;

class apples{
    public static void main (String args[]){
        Scanner lucas = new Scanner (System.in);
        double one;
        double two;
        double answer;
        System.out.println("Enter your first number; ");
        one = lucas.nextDouble();
        System.out.println("Enter a second number; ");
        two = lucas.nextDouble();
        answer = one + two;
        System.out.println(answer);
    }
}