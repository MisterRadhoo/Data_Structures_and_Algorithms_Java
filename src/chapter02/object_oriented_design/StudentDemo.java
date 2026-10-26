package chapter02.object_oriented_design;

public class StudentDemo {

    public static void main(String[] args) {

         Student student1 = new Student("S01", "Ana Popescu", 27);
         Student student2 = new Student("S02", "Elena Ionescu", 26);

         System.out.println(student1.toString());
         System.out.println(student2.toString());
         System.out.println();
         System.out.println("Student 1 is equal with student 2: " + student1.equals(student2));

    }
}
