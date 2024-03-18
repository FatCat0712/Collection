public class Main {
    public static void main(String[] args) {

        System.out.println("---Test 1---");
        Box<Integer> box1 = new Box<>(2);
        System.out.println(box1.getValue());

        System.out.println("---Test 2---");
        Box<String> box2 = new Box<>("This is a string");
        System.out.println(box2.getValue());

        System.out.println("---Test 3---");
        Box<Double> box3 = new Box<>(15.5);
        System.out.println(box3.getValue());





    }
}
