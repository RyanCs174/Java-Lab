import java.util.Scanner;
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
        System.out.print("\nEnter the Starting Amount (Minimum Amount = 5000): ");
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
    Scanner s = new Scanner(System.in);
    float deposit,withdraw,interest;
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
        if(bal<5000)
        {
            System.out.println("\nInsufficient Balance");
        }
        else
        {
            bal-=withdraw;
            System.out.println("\nAmount Withdrawn: "+withdraw+"\nBalance: "+bal);
        }
    }
    public void check_Bal()
    {
        if(bal<5000)
        {
            System.out.println("\nInsufficient Balance!!\nBalance: "+bal);
        }
        else
        {
            System.out.println("\nBalance: "+bal);
        }
    }
    public void interest()
    {
        interest=(bal*6)/100;
        bal+=interest;
        System.out.println("\nInterest Credited: "+interest+"\nBalance :"+bal) ;
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
            return false;
        }
        return true;
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
        ch = s.next();

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
