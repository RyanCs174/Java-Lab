import java.util.*;

class Father extends Exception
{
 int father_age;
 Father(int Fage)
 {
  father_age=Fage;
 }
 public String toString()
 {
  return "Wrong age";
 }
}

class Son extends Father
{
 int son_age;
 Son(int Fage,int Sage)
 {
  super(Fage);
  son_age=Sage;
 }
 public String toString()
 {
  return " Invalid son's age is greater than or equal to Father's age";
 }
}

class Main
{
 static int a,b;
 static void fatherage(int a) throws Father
 {
  System.out.println("Called father's age is: "+a);
  if(a<0)
  throw new Father(a);
  System.out.println("No exception in Father's age:"+a);
 }
 static void sonage(int a,int b) throws Son
 {
  System.out.println("Called son's age is: "+b);
  if(b>=a)
  throw new Son(a,b);
  System.out.println("No exception in Son's age:"+b);
 }
 public static void main(String args[])
 {
  Scanner age=new Scanner(System.in);
  System.out.println("Enter Father's age:");
  a=age.nextInt();
  System.out.println("Enter Son's age:");
  b=age.nextInt();
  try
  {
   fatherage(a);
  }
  catch(Father e)
  {
   System.out.println(e);
  }
  try
  {
   sonage(a,b);
  }
  catch(Son e)
  {
   System.out.println(e);
  }
 }
}
