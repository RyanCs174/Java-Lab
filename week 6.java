import java.util.Scanner;
import java.util.Arrays;

public class Anchor
{
public static void main(String[] args)
{
Scanner s = new Scanner(System.in);
int choice;
System.out.print("\n1. UnderGraduate Student\n2. GraduateStudent\nEnter your choice: ");
choice = s.nextInt();
switch(choice)
{
case 1:
{
System.out.print("\nEnter the student name: ");
UnderGraduate u = new UnderGraduate(s.next());
System.out.println("Enter the subject number and marks of 4 subjects");
for(int i=0;i<4;i++)
{
u.setTestScore(s.nextInt(),s.nextInt());
}
u.setTestResult();
u.display();
}
break;
case 2:
{
System.out.print("\nEnter the student name: ");
Graduate g = new Graduate(s.next());
System.out.println("Enter the subject number and marks of 4 subjects");
for(int i=0;i<4;i++)
{
g.setTestScore(s.nextInt(),s.nextInt());
}
g.setTestResult();
g.display();
}
break;
default: System.out.println("Invalid Choice!");
}
}
}

interface A
{
public String getName();
public void setTestScore(int no,int marks);
public int[] getTestScore();
public void setTestResult();
public int getTestResult();
public void display();
}

abstract class Student implements A
{
String name;
int[] test = new int[4];
int sum;
abstract public void generateResult();
Student()
{}
Student(String name)
{
this.name = name;
}
public String getName()
{
return this.name;
}
public void setTestScore(int no,int marks)
{
test[no-1] = marks;
}
public int[] getTestScore()
{
return test;
}
public void setTestResult()
{
for(int i=0;i<4;i++)
{
sum=sum+test[i];
}
sum/=4;
}
public int getTestResult()
{
return sum;
}
public void display()
{
System.out.println("\nStudent Name : "+getName());
System.out.println("Student Marks : "+Arrays.toString(getTestScore()));
System.out.print("Result : ");
generateResult();
}
}
class UnderGraduate extends Student
{
UnderGraduate()
{}
UnderGraduate(String name)
{
this.name = name;
}
public void generateResult()
{
if(getTestResult()>=60)
System.out.print("Pass");
else
System.out.print("Fail");
}
}
class Graduate extends Student
{
Graduate()
{}
Graduate(String name)
{
this.name = name;
}
public void generateResult()
{
if(getTestResult()>=70)
System.out.print("Pass");
else
System.out.print("Fail");
}
}
