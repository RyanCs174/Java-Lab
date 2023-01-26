import java.util.Scanner;
class Student
{
    String USN;
    String name;
    int[] credits = new int[20];
    int[] marks = new int[20];
    public void input(int n)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Student USN: ");
        USN = s.nextLine();
        System.out.print("Enter Student Name: ");
        name = s.nextLine();
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter the Subject "+(i+1)+" marks and credits respectively: ");
            marks[i] = s.nextInt();
            credits[i] = s.nextInt();
        }
    }
    public float calculate(int n)
    {
        int sum_of_credits = 0;
        float result=0.0f;
        for(int i=0;i<n;i++)
        {
            sum_of_credits+=credits[i];
            if(calculate_grade_point(marks[i])==-1)
                return -1.0f;
            else
            {
                result = result +(float) (calculate_grade_point(marks[i])*credits[i]);
            }
        }
        return (result/sum_of_credits);
    }

    public int calculate_grade_point(int marks)
    {
        if(marks>=90)
            return 10;
        else if ((marks>=80)&&(marks<90))
            return 9;
        else if ((marks>=70)&&(marks<80))
            return 8;
        else if ((marks>=60)&&(marks<70))
            return 7;
        else if ((marks>=50)&&(marks<60))
            return 6;
        else if ((marks>=40)&&(marks<50))
            return 5;
        return -1;
    }

    public void display(int n,float result)
    {
        System.out.println("\n");
        System.out.println("Student Details");
        System.out.println();
        System.out.println("Student USN: "+USN);
        System.out.println("Student Name: "+name);
        System.out.println("Student Marks and Credits");
        for(int i=0;i<n;i++)
        {
            System.out.println("Subject " + (i+1) + "-->\tMarks: "+marks[i]+" Credits: "+credits[i]);
        }
        System.out.println("SGPA: "+result);
    }
}
public class SGPA
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Student s1 = new Student();
        System.out.print("Enter the number of subjects: ");
        int n = s.nextInt();
        s1.input(n);
        float result = s1.calculate(n);
        if(result == -1.0f)
        {
            System.out.println();
            System.out.println("The Student has failed in a subject. SGPA cannot be calculated!");
            System.exit(0);
        }
        s1.display(n,result);
    }
}
