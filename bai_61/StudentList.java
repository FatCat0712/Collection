import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList{
    private ArrayList<Student> studentList;

    public StudentList(){
        this.studentList = new ArrayList<Student>();
    }

    public StudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student s){
        studentList.add(s);
    }

    public void printStudentList(){
        for(Student st: studentList){
            System.out.println(st);
        }
    }

    public boolean isEmpty(){
        return studentList.isEmpty();
    }

    public int printNumberOfStudent(){
        return studentList.size();
    }

    public void clearList(){
        studentList.clear();
    }

    public void removeStudent(String studentId){
        for(int i = 0; i < studentList.size(); i++){
            if(studentList.get(i).getStudentId().equals(studentId)){
                studentList.remove(i);
                break;
            }
        }
    }

    public boolean checkIfExist(String studentId){
       ArrayList<String> arrayId = new ArrayList<>();
        for (Student student : studentList) {
            arrayId.add(student.getStudentId());
        }
       return arrayId.contains(studentId);
    }

    public void findAStudentByName(String name){
        for(Student s: studentList){
            if(s.getName().equals(name)){
                System.out.println(s);
                break;
            }
        }
    }


    public void printDecreasingListByScore() {
        Collections.sort(studentList, new Comparator <Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getAverageScore() > o2.getAverageScore()){
                    return -1;
                }
                else if(o1.getAverageScore() <= o2.getAverageScore()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });
        for(Student s: studentList){
            System.out.println(s);
        }
    }

    public void saveAsFile(String fileName){
        File file = new File(fileName);
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for(Student s: studentList){
                oos.writeObject(s);
            }
            oos.flush();
            oos.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void readListFromFile(String fileName){
        File file = new File(fileName);
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            while (is.available() > 0){
                Student s = (Student)ois.readObject();
                studentList.add(s);
            }
        }
        catch (IOException e){
            e.getMessage();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
