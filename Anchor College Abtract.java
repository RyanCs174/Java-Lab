public class ScoreCalc {
    public static void main(String[] args) {
        Student student;

        System.out.println("\n Undergraduate Student");
        student = new UndergraduateStudent("Philip");
        student.setTestScore(0, 70);
        student.setTestScore(1, 69);
        student.setTestScore(2, 71);
        student.setTestScore(3, 55);
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Result: " + student.getTestResult());

        System.out.println("\n Graduate Student");
        student = new GraduateStudent("Jerry");

        student.setTestScore(0, 70);
        student.setTestScore(1, 69);
        student.setTestScore(2, 71);
        student.setTestScore(3, 55);
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Result: " + student.getTestResult());
    }

}

abstract class Student {
    String studentName;
    int[] testScores = new int[4];
    String testResult;

    Student(String studentName) {
        this.studentName = studentName;
        testResult = "Default";
    }

    abstract void generateResult();

    void setTestScore(int testNumber, int testScore) {
        testScores[testNumber] = testScore;
    }

    String getStudentName() {
        return this.studentName;
    }

    void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    int[] getTestScores() {
        return this.testScores;
    }

    String getTestResult() {
        this.generateResult();
        return testResult;
    }

    void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}

class UndergraduateStudent extends Student {
    UndergraduateStudent(String studentName) {
        super(studentName);
    }

    @Override
    void generateResult() {
        int a[] = this.getTestScores();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += a[i];
        }
        int avg = sum / 4;
        if (avg >= 60)
            this.setTestResult("Pass");
        else
            this.setTestResult("Fail");
    }
}

class GraduateStudent extends Student {
    GraduateStudent(String studentName) {
        super(studentName);
    }

    @Override
    void generateResult() {
        int a[] = this.getTestScores();
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += a[i];
        }
        int avg = sum / 4;
        if (avg >= 70)
            this.setTestResult("Pass");
        else
            this.setTestResult("Fail");
    }
}
