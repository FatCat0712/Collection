import java.util.*;

public class Convert {
    // 5 + ((1 + 2) * 4) + 3
    // 5 * ( 7 -4 ) + 4 * ( 5 - 3)
    public static int priortity(String c){
        HashMap<String,Integer> myMap = new HashMap<>();
        myMap.put("^",4);
        myMap.put("%",3);
        myMap.put("/",3);
        myMap.put("*",3);
        myMap.put("+",2);
        myMap.put("-",2);
        myMap.put("=",1);

        return myMap.get(c);
    }

    public static String infixToPrefix(String s){
        s = s.replaceAll(" ","");
        Stack<String> operatorStack = new Stack<>();
        Queue<String> operandQueue = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                operatorStack.push(s.charAt(i)+"");
            }
            else if(s.charAt(i) == ')'){
                while (!operatorStack.peek().equals("(")){
                    String pop = operatorStack.pop();
                    operandQueue.offer(pop);
                }
                operatorStack.pop();
            }
            else{
                if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                    if(operatorStack.isEmpty() || operatorStack.peek().equals("(")){
                        operatorStack.push(s.charAt(i)+"");
                    }
                    else{
                        int num1 = priortity(s.charAt(i)+"");
                        String p = operatorStack.peek();
                        int num2 = priortity(p);
                        if(num1 > num2){
                            operatorStack.push(s.charAt(i)+"");
                        }
                        else{
                            String pop = operatorStack.pop();
                            operandQueue.offer(pop);
                            operatorStack.push(s.charAt(i)+"");
                        }
                    }
                }
                else{
                    operandQueue.offer(s.charAt(i)+"");
                }

            }
        }
        while(!operatorStack.isEmpty()){
            String remain = operatorStack.pop();
            operandQueue.offer(remain);
        }
        String result = "";
        while(!operandQueue.isEmpty()){
            result += operandQueue.poll();
        }
        return result;
    }

    public static int printResult(String s){
        Stack<Integer> resultStack = new Stack<>();
        int result = 0;
        s = s.replaceAll(" ","");
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i)== '-' || s.charAt(i) == '*' || s.charAt(i) == '/'){
                int x = resultStack.pop();
                int y = resultStack.pop();
                switch (s.charAt(i)){
                    case '+':
                        result = x + y;
                        break;
                    case '-':
                        result = y - x;
                        break;
                    case '*' :
                        result =  x * y;
                        break;
                    case '/':
                        result = y / x;
                        break;
                }
                resultStack.push(result);
            }
            else {
                resultStack.push(Integer.parseInt(s.charAt(i)+""));
            }
        }
        return resultStack.peek();
    }
    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("What can we do for u: ");
            System.out.println("1. Convert Infix to PostFix ");
            System.out.println("2. Print the result: ");
            System.out.println("0. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter an expression");
                    String e = sc.nextLine();
                    System.out.println(infixToPrefix(e));
                    break;
                case 2:
                    System.out.println("Enter an expression");
                    String a = sc.nextLine();
                    System.out.println(printResult(a));
                    break;
                case 0:
                    System.out.println("Bye");
                    flag = false;
                    break;
            }

        }
    }
}
