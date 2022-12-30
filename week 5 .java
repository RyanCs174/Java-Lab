import java.util.Scanner;
/*Develop a Java program to create a class Bank that maintains two kinds of account 
for its customers, one called Saving Account and the  
Current Account. The savings account provides compound 
interest and withdrawal facilities but no cheque book facility. 
The current account provides cheque book facility but with no interest. 
Current account holders should also maintain a minimum balance and if the 
balance falls below minimum balance, a service charge is imposed(levied).

Create a class Account that stores customer name, account number and type 
of account. From this derive the classes CurrentAccount and SavingAccount
 to make them more specific to their requirements. Include the necessary methods
in order to achieve the following tasks:

a)     Accept deposit from customer and update the balance.

b)     Display the balance.

c)     Compute and deposit interest

d)     Permit withdrawal and update the balance

Check for the minimum balance, impose penalty if necessary and update the balance.*/
class Account
{
    String customer_name;
    long acc_no;
    float bal;
    Scanner s = new Scanner(System.in);
    public void input()
    {
        System.out.print("\nEnter the Customer Name: ");
        customer_name = s.nextLine();
        System.out.print("\nEnter the Account Number: ");
        acc_no = s.nextLong();
        System.out.print("\nEnter the Starting Amount ");
        bal = s.nextFloat();
        if(bal<5000f)
        {
            System.out.println("\nAccount Balance cannot be less than 5000.0 \n");
            System.exit(0);
        }
    }
    public void display()
    {
        System.out.println("\nCustomer Name: "+customer_name);
        System.out.println("Account Number: "+acc_no);
        System.out.println("Amount: "+bal);
    }
}

class Savings extends Account
{
    int n;
    Scanner s = new Scanner(System.in);
    double deposit,withdraw,interest;
    public void deposit()
    {
        System.out.print("\nEnter the amount to be deposited: ");
        deposit = s.nextFloat();
        bal+=deposit;
        System.out.println("\nBalance: "+bal);
    }
    public void withdraw()
    {
        System.out.print("\nEnter the amount to be withdrawn: ");
        withdraw = s.nextFloat();
        if(bal<withdraw){

        System.out.println("INsufficient balance");}
else{
        bal-=withdraw;
        System.out.println("\nAmount Withdrawn: "+withdraw+"\nBalance: "+bal);
}
        
    }
    public void check_Bal()
    {
    System.out.println("\nBalance: "+bal);
}

    public void interest()
    {
    System.out.println("Enter the amount of times interestr is applied");
    n=s.nextInt();
        interest=bal*Math.pow((1+(0.06/n)),n)-bal;
    System.out.print("Interest accumulated is : "+interest);
    }
}

class Current extends Account
{
    float deposit, withdraw, penalty;

    public void deposit()
    {
        System.out.print("\nEnter Amount to be deposited: ");
        deposit = s.nextFloat();
        bal += deposit;
        System.out.println("Balance: " + bal);
    }

    public void check_Bal()
    {
        if (bal < 5000)
        {
            penalty = (0.1f * bal);
            System.out.println("\nInitial Account Balance: "+bal);
            bal = bal-penalty;
            System.out.println("\nLow balance!\nPenalty Amount: " + penalty + "\nAccount balance: " + bal);
        }
        else
        {
            System.out.println("\n Balance: " + bal);
        }
    }

    public boolean check_Bal_part_2()
    {
        if (bal < 5000)
        {
            penalty = (0.1f * bal);
            System.out.println("\nInitial Account Balance: "+bal);
            bal = bal-penalty;
            System.out.println("\nLow Balance!\nPenalty Amount: " + penalty + "\nAccount balance: " + bal);
            return true;
    }
        else
        return false;
    }

    public void withdraw()
    {
        System.out.print("\nEnter Amount to withdraw: ");
        withdraw = s.nextFloat();
        if(check_Bal_part_2())
        {
            bal-=withdraw;
            System.out.println("\nAmount Withdrawn: "+withdraw+"\nBalance: "+bal);
        }
    else
        bal-=withdraw;
            System.out.println("\nAmount Withdrawn: "+withdraw+"\nBalance: "+bal);
    }

    public void chequebook()
    {
        System.out.println("\nCheque Book has been Issued!");
    }
}

public class Bank
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String ch;
        int n;
        Current c = new Current();
        Savings sa = new Savings();
        System.out.print("\nEnter the Account Type (S for Savings , C for Current) : ");
        ch = s.nextLine();

        switch(ch.toLowerCase())
        {
            case "s" :  sa.input();
                        do
                        {
                            System.out.print("\n1. Deposit \n2. Withdrawal \n3. Check Balance \n4. Check Interest"
                                    +"\n5. Show Account Details \n6. Exit Transaction\n\nEnter your choice: ");
                            n = s.nextInt();
                            switch(n)
                            {
                                case 1 : sa.deposit();
                                         break;
                                case 2 : sa.withdraw();
                                         break;
                                case 3 : sa.check_Bal();
                                         break;
                                case 4 : sa.interest();
                                         break;
                                case 5 : sa.display();
                                         break;
                                case 6 : System.out.println("\nExiting Transaction!");
                                         System.exit(0);
                                         break;
                                default : System.out.println("\nInvalid Operation");
                            }
                        }while(true);
            case "c" : c.input();
                       do {
                           System.out.print("\n1. Deposit \n2. Withdrawal \n3. Check Balance \n4. Issue Cheque Book"
                                   + "\n5. Show Account Details \n6. Exit Transaction\n\nEnter your choice: ");
                           n = s.nextInt();
                           switch (n) {
                               case 1:
                                   c.deposit();
                                   break;
                               case 2:
                                   c.withdraw();
                                   break;
                               case 3:
                                   c.check_Bal();
                                   break;
                               case 4:
                                   c.chequebook();
                                   break;
                               case 5:
                                   c.display();
                                   break;
                               case 6:
                                   System.out.println("\nExiting Transaction!");
                                   System.exit(0);
                                   break;
                               default:
                                   System.out.println("\nInvalid Operation");
                           }
                       }while(true);
            default : System.out.println("\nInvalid Choice");
                      break;
            }
    }
}
