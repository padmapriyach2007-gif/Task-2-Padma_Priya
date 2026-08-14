import java.util.Scanner;
class StudentData {
    private String place;
    private int id;
    private String name;
    private String section;
    private int totalSubjects;
    private String scu;
    public void inputStudentData(Scanner sc) {
        System.out.print("Enter School/College/University Name: ");
        this.scu = sc.nextLine();
        System.out.print("Enter City/Place: ");
        this.place = sc.nextLine();
        System.out.print("Enter Student ID: ");
        this.id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Student Name: ");
        this.name = sc.nextLine();
        System.out.print("Enter Student Section: ");
        this.section = sc.nextLine().trim();
        System.out.print("Enter total number of subjects: ");
        this.totalSubjects = Integer.parseInt(sc.nextLine().trim());
    }
    public String getScu() { return scu; }
    public String getPlace() { return place; }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSection() { return section; }
    public int getTotalSubjects() { return totalSubjects; }
}
class GradeCalculator {
    public float calculateAverage(int totalMarks, int totalSubjects) {
        return (float) totalMarks / totalSubjects;
    }
    public float calculateGPA(float averagePercentage) {
        return averagePercentage / 10.0f;
    }
    public String determineGrade(float averagePercentage) {
        if (averagePercentage >= 90) return "Outstanding";
        if (averagePercentage >= 80) return "First Class with Distinction";
        if (averagePercentage >= 70) return "First Class";
        if (averagePercentage >= 60) return "Second Class";
        if (averagePercentage >= 50) return "Third Class";
        return "Fail";
    }
}
class StudentDisplay {
    public void printReport(StudentData student, int totalMarks, float avg, float gpa, String grade) {
        System.out.println("\n\t\t--- " + student.getScu() + " , " + student.getPlace() + " ---");
        System.out.println("\t\t--- Performance Report ---");
        System.out.println("\t\tStudent ID: " + student.getId());
        System.out.println("\t\tStudent Name: " + student.getName());
        System.out.println("\t\tStudent Section: " + student.getSection());
        System.out.println("\t\tTotal Marks: " + totalMarks + " / " + (student.getTotalSubjects() * 100));
        System.out.println("\t\tAverage Percentage: " + String.format("%.2f", avg) + "%");
        System.out.println("\t\tGrade Point Average: " + String.format("%.2f", gpa));
        System.out.println("\t\tGrade: " + grade);
    }
}
public class DecodeLabs_Java_P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentData student = new StudentData();
        StudentDisplay sd = new StudentDisplay();
        GradeCalculator gc = new GradeCalculator();
        try {
            student.inputStudentData(sc);

            if (student.getTotalSubjects() <= 0) {
                System.out.println("Error: Number of subjects must be greater than zero.");
                return;
            }
            int totalMarks = 0;
            System.out.println("\nEnter subject marks:");
            for (int i = 0; i < student.getTotalSubjects(); i++) {
                System.out.print("Subject " + (i + 1) + " score out of 100: ");
                totalMarks += Integer.parseInt(sc.nextLine().trim());
            }
            float avg = gc.calculateAverage(totalMarks, student.getTotalSubjects());
            float gpa = gc.calculateGPA(avg);
            String grade = gc.determineGrade(avg);
            sd.printReport(student, totalMarks, avg, gpa, grade);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input detected. Please enter numeric values where required.");
        } finally {
            sc.close();
        }
    }
}