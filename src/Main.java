import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
//        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
//        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
//        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
//        students.add(new Student(5, "Đào Như Anh", "Hà Nội"));
//        writeToFile("student.txt",students);
        List<Student> studentList = readDataFromFile("student.txt");
        for (Student student : studentList){
            System.out.println(student);
        }
    }
    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Student>) ois.readObject();
            fis.close();;
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
