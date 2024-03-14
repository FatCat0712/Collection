import java.io.Serializable;

public class Student implements Serializable {
    private String studentId;
    private String fullName;
    private int yearOfBirth;
    private double averageScore;

    public Student(String studentId, String fullName, int yearOfBirth,double averageScore){
            this.studentId = studentId;
            this.fullName = fullName;
            this.yearOfBirth = yearOfBirth;
            this.averageScore = averageScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if(!studentId.isEmpty()){
            this.studentId = studentId;
        }
    }

    public String getFullName() {
        return fullName;
    }


    public String getName(){
        String s = fullName.trim();
        if(s.contains(" ")){
            s = s.substring(s.lastIndexOf(" ")+1);
        }
        return s;
    }
    public void setFullName(String fullName) {
        if(!fullName.isEmpty()){
            this.fullName = fullName;
        }
    }



    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        if(yearOfBirth > 0){
            this.yearOfBirth = yearOfBirth;
        }
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        if(averageScore > 0){
            this.averageScore = averageScore;
        }
    }

    public String toString(){
        return String.format("%5s%15s%10d%10.1f",studentId,fullName,yearOfBirth,averageScore);
    }



}

