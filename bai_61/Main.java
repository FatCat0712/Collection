import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        StudentList studentList = new StudentList(students);
        boolean flag = true;

        while (flag){
            System.out.println("---------------- Student Manager -----------------");
            System.out.println("| 1. Add students to list                        |");
            System.out.println("| 2. Print out student                           |");
            System.out.println("| 3. Check if list is empty                      |");
            System.out.println("| 4. Print the number of students present in list|");
            System.out.println("| 5. Empty the student list                      |");
            System.out.println("| 6. Remove a student by ID                      |");
            System.out.println("| 7. Check if student is exist by ID             |");
            System.out.println("| 8. Find a student by name                      |");
            System.out.println("| 9. Print the list decreasing by average score  |");
            System.out.println("| 10. Save student list as file                  |");
            System.out.println("| 11. Read list from a file                      |");
            System.out.println("| 0. Exit                                        |");
            System.out.println("--------------------------------------------------");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("How many students do you want to add ?");
                    int number = sc.nextInt();
                    sc.nextLine();
                    for(int i = 0; i < number; i++){
                        System.out.println("Enter the ID of the student: ");
                        String studentId = sc.nextLine();
                        System.out.println("Enter FullName of the student: ");
                        String fullName = sc.nextLine();
                        System.out.println("Enter year of birth of the student: ");
                        int year = sc.nextInt();
                        System.out.println("Enter average score of the student: ");
                        double averageScore = sc.nextDouble();
                        sc.nextLine();
                        studentList.addStudent(new Student(studentId,fullName,year,averageScore));
                    }
                    break;
                case 2:
                    studentList.printStudentList();
                    break;
                case 3:
                    if(!studentList.isEmpty()){
                        System.out.println("The list is not empty");
                    }
                    else{
                        System.out.println("The list is empty");
                    }

                    break;
                case 4:
                    System.out.println("The number of students now is: ");
                    System.out.println(studentList.printNumberOfStudent());
                    break;
                case 5:
                    studentList.clearList();
                    break;
                case 6:
                    System.out.println("Enter the ID of the student: ");
                    String id = sc.nextLine();
                    studentList.removeStudent(id);
                    break;
                case 7:
                    System.out.println("Enter the ID of the student: ");
                    String sid = sc.nextLine();
                    System.out.println(studentList.checkIfExist(sid));
                    break;
                case 8:
                    System.out.println("Enter name of the student: ");
                    String name = sc.nextLine();
                    studentList.findAStudentByName(name);
                    break;
                case 9:
                    studentList.printDecreasingListByScore();
                    break;
                case 10:
                    System.out.println("Save as file");
                    String fileName = sc.nextLine();
                    studentList.saveAsFile(fileName);
                    break;
                case 11:
                    System.out.println("Read from file");
                    String file = sc.nextLine();
                    studentList.readListFromFile(file);
                    break;
                case 0:
                    System.out.println("Bye");
                    flag = false;
                    break;



            }



        }
    }
}
