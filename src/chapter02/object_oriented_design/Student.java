package chapter02.object_oriented_design;

public class Student implements Person {

    String id;
    String name;
    int age;

    // Simple Constructor
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // just a guess
    protected int studyHours() {
        return this.age / 2;
    }

    public String getId() {                 // id of the student
        return this.id;
    }

    @Override
    public String getName() {                // from Person interface
        return this.name;
    }

    @Override
    public int getAge() {                    // from Person interface
        return this.age;
    }

    @Override
    public boolean equals(Person other) {       // from Person interface
        if(!(other instanceof Student)) {       // cannot possibly be equal
            return false;
        }
        Student s = (Student) other;             // explicit cast now safe
        return id.equals(s.id);                  // compare id's
    }

    @Override
    public String toString() {
        return "Student (Id: " + id + ",  Name: " + name + ", Age: " + age + ")";
    }
}



