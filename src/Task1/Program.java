package Task1;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Student student = new Student("Andrey", 22, 4.5);
        try(FileOutputStream fileOutputStream = new FileOutputStream("StudentBook.bin")) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(student);
                System.out.println("Объект сериализован");
            }
        }
        Student copyStudent;
        try(FileInputStream fileInputStream = new FileInputStream("StudentBook.bin")) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                copyStudent = (Student) objectInputStream.readObject();
                System.out.println("Объект десериализован");
            }
        }
        System.out.println("Имя: " + copyStudent.getName());
        System.out.println("Возраст: " + copyStudent.getAge());
        System.out.println("Средний балл: " + copyStudent.getGPA());
    }
}
