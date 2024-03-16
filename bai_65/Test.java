import java.io.IOException;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException {
        TreeMap<String,String> tm = new TreeMap<>();
        MyDictionary dict = new MyDictionary(tm);
        boolean flag = true;
        while (flag){
            System.out.println("---------My Dictionary---------");
            System.out.println("-------------MENU--------------");
            System.out.println("1. Add a keyword");
            System.out.println("2. Remove a keyword");
            System.out.println("3. Look up a word");
            System.out.println("4. Print out words");
            System.out.println("5. Print out the number of words");
            System.out.println("6. Clear the dictionary");
            System.out.println("7. Save words to file");
            System.out.println("8. Read words from file");
            System.out.println("0. Exit");
            System.out.println("---------------------------------");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the word: ");
                    String w = sc.nextLine();
                    System.out.println("Enter the meaning");
                    String m = sc.nextLine();
                    dict.addKeyWords(w,m);
                    break;
                case 2:
                    System.out.println("Enter the word: ");
                    String s = sc.nextLine();
                    dict.removeWords(s);
                    break;
                case 3:
                    System.out.println("Enter the word");
                    String word = sc.nextLine();
                    System.out.println("The meaning is: "+ dict.lookUpWords(word));
                    break;
                case 4:
                    dict.printOutKeywords();
                    break;
                case 5:
                    System.out.println("The number of words is: "+dict.numberOfWords());
                    break;
                case 6:
                    dict.clear();
                    break;
                case 7:
                    System.out.println("Enter file name: ");
                    String f = sc.nextLine();
                    dict.saveWordsToFile(f);
                    break;
                case 8:
                    System.out.println("Enter file name: ");
                    String file = sc.nextLine();
                    dict.readWordsFromFile(file);
                    break;
                case 0:
                    flag = false;
                    System.out.println("Bye");
                    break;
            }


        }
    }
}
