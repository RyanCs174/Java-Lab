
import java.util.*;



class Book {

	String title, author;
	double price;
	int numPages;

	Book() {
		
		title="Default"; 
		author="Default";
		price=0.0;
		numPages=0;
	}
	void setTitle(String t) {

		title=t; 
		
	}
	void setAuthor(String a) {
		
	
		author=a;
	
	}
	void setPrice(double p) {
		
		
		price=p;
		
	}
	void setPages(int np) {
		
	
		numPages=np;
	}

	public String toString() {

		return title+"\t"+author+"\t"+price+"\t"+numPages+"\n";
	}
}

class BookDetails {

	public static void main(String args[]) {
		String t, a;
		double p;
		int np,n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Books");
		n = sc.nextInt();
		Book b[]= new Book[n];
 		for(int i=0; i<n;i++) {
			System.out.println("Enter the Title of  the Books");			
			t= sc.next();
			System.out.println("Enter the Author of  the Books");		
			a= sc.next();
			System.out.println("Enter the Price of  the Books");				
			p= sc.nextDouble();
			System.out.println("Enter the Number of pages of  the Books");	
			np= sc.nextInt();
					
			b[i] = new Book();
			b[i].setTitle(t);
			b[i].setAuthor(a);
			b[i].setPrice(p);
			b[i].setPages(np);
		}

		System.out.println("Title \t Author \t Price \t Pages\n");
		for(int i=0; i<n;i++) {
			System.out.println(b[i]);
		}
		
	}
}