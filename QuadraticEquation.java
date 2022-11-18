import java.util.Scanner;
import java.lang.Math;


class QuadraticEquation{
	public static void main(String[] args){
	int a,b,c;
	double d,r1,r2;
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the values of a,b,c");
	a=in.nextInt();
	b=in.nextInt();
	c=in.nextInt();
	d=b*b-4*a*c;
	if(d>0){
	r1=(-b+Math.sqrt(d))/(2*a);
	r2=(-b-Math.sqrt(d))/(2*a);
	System.out.println("Roots are real and distinct");
	System.out.println("The Roots are : "+r1+" "+r2);
	}
	else if(d==0){
	r1=r2=(-b)/(2*a);
	System.out.println("Roots are real and equal ");
	System.out.println("The roots are : "+r1);
	}
	else{
	r1=(-b)/(2*a);
	r2=(Math.sqrt(Math.abs(d)))/(2*a);
	System.out.println("Roots are distinct and imaginary ");
	System.out.println(r1+"+i"+r2+"\n"+r1+"-i"+r2);
	}


}	

}