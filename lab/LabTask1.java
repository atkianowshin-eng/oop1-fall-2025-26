class Student {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private Student[] students;
    private int count = 0;

    public School(String schoolName, int numberOfStudents) {
        this.schoolName = schoolName;
        this.students = new Student[numberOfStudents];
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("Cannot add more students to " + schoolName);
        }
    }

    public void showStudents() {
        System.out.println("School: " + schoolName);
        System.out.println("Students:");
        for (int i = 0; i < count; i++){
            System.out.println(" - " + students[i].getName());
        }
    }
}

class Contact {
    private String phone;
    private String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
     
    public String toString() {
        return phone + ", " + email;
    }
}

class Stu {
    private String name;
    private Contact contact;

    public Stu(String name, Contact contact) {
        this.name = name;
        this.contact = contact;
    }

    public void showStuInfo() {
         System.out.println("Student Name: " + name);
         System.out.println("Contact: " + contact);
    }
}

public class LabTask1 {
    public static void main(String[] args) {
        School s = new School("Ideal School and College", 3);
        s.addStudent(new Student("Nafisa"));
        s.addStudent(new Student("Apshora"));
        s.addStudent(new Student("Nubah"));

        s.showStudents();
        System.out.println();

        Contact cont = new Contact ("01365893261", "iscmc345@gmail.com");
        Stu s1 = new Stu ("Alexa", cont);
        
        s1.showStuInfo();
    }

          
}
