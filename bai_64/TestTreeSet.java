import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for(int i = 0; i < n; i++){
//            int num = sc.nextInt();
//            set.add(num);
//        }
        String s = sc.nextLine();
        String[] arr = s.split(" ");
        set.addAll(Arrays.asList(arr));
        for(String x: set){
            System.out.println(x);
        }
    }
}
