import java.util.HashMap;
import java.util.Stack;

public class nothing {
    public static int priortity(String c){
        HashMap<String,Integer> myMap = new HashMap<>();
        myMap.put("^",4);
        myMap.put("%",3);
        myMap.put("/",3);
        myMap.put("+",2);
        myMap.put("-",2);
        myMap.put("=",1);

        return myMap.get(c);
    }
    public static void main(String[] args) {
        Stack<String> s1 = new Stack<>();
        s1.push("*");
        System.out.println(s1.peek());
        String s = s1.peek();
        //System.out.println(priortity(s));
    }
}
