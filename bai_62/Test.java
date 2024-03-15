import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        //Reverse a string
        String name = "Mai Son Hai";
        Stack<Character> stackChar = new Stack<>();
        for(int i = 0; i < name.length(); i++){
            stackChar.push(name.charAt(i));
        }
        System.out.println("Reverse a string :");
        String result = "";
        for(int i = 0; i < name.length(); i++){
            result += stackChar.pop();
        }
        System.out.println(result);

        // Convert a number to bit
        Stack<Integer> stackNum = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while(number > 0){
            int soDu = number % 2;
            stackNum.push(soDu);
            number /= 2;
        }
        String numResult = "";
        while(!stackNum.isEmpty()){
            numResult += stackNum.pop();
        }
        System.out.println(numResult);


    }
}
