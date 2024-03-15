import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        System.out.println("--- Testing Queue ---");
        Queue<String> queueString = new LinkedList<>();
        queueString.offer("Mai Son Hai");
        queueString.offer("Mai Thanh Ha");
        queueString.offer("Mai Hac Son");
        queueString.offer("Vo Thi Kim Thanh");

        while (!queueString.isEmpty()){
            String name = queueString.poll();
            System.out.println(name);
        }


        System.out.println("--- Testing PriorityQueue ---");
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();
        stringPriorityQueue.offer("A2");
        stringPriorityQueue.offer("T1");
        stringPriorityQueue.offer("A1");
        stringPriorityQueue.offer("T2");

        while(!stringPriorityQueue.isEmpty()){
            System.out.println(stringPriorityQueue.poll());
        }


        System.out.println("--- Testing ArrayDeque ---");
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();

        stringArrayDeque.offer("A");
        stringArrayDeque.offer("B");
        stringArrayDeque.offer("C");
        stringArrayDeque.offer("D");
        stringArrayDeque.offerFirst("E");
        stringArrayDeque.offerLast("F");

        while (!stringArrayDeque.isEmpty()){
            String s = stringArrayDeque.peek();
            if(s != null){
                System.out.print(stringArrayDeque.poll()+ " ");
            }

        }

    }
}
