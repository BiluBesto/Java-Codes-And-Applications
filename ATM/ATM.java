import java.util.*;
class ATMuse
{
    int balance,amount;
    void getBalance(Scanner s)
    {
        System.out.println("Enter initial balance:");
        while((balance=s.nextInt())<0)
        {
            System.out.println("Enter valid balance!");
        }
        System.out.println("Enter a number for operation:");
    }
    void dispCurBal()
    {
        System.out.println("Your current balance is "+balance);
    }
    void deposit(Scanner s)
    {
        System.out.println("Enter the amount of money to deposit:");
        if((amount=s.nextInt())<=0)
        {
            System.out.println("Enter valid amount!");    
        }
        else      
        {
            balance+=amount;
            System.out.println(amount + " has been succesfully deposited to your account!");
            System.out.println("Your new balance:"+balance);
        }
    }
    void withdraw(Scanner s)
    {
        System.out.println("Enter the amount of money to withdraw:");
        amount=s.nextInt();
        if(amount>balance||amount<=0)
        {
            System.out.println("Enter valid amount to withdraw!");
        }
        else
        {
            balance-=amount;
            System.out.println(amount+" has been successfully withdrawed!");
            System.out.println("Your new balance:"+balance);
        }   
    }
}
class ATM
{
    public static void main(String[] args)
    {
        //check balance, deposit money , withdraw money, exit
        ATMuse obj= new ATMuse();
        Scanner s = new Scanner(System.in);
        obj.getBalance(s);
        while(true)
        {
            System.out.println("-----Menu-----");
            System.out.println("1 : Check Balance");
            System.out.println("2 : Deposit Money");
            System.out.println("3 : Withdraw Money");  
            System.out.println("4 : Exit");
            int ch=s.nextInt();
            switch(ch)
            {
                case 1:
                obj.dispCurBal();
                break;
                case 2:
                obj.deposit(s);
                break;
                case 3:
                obj.withdraw(s);
                break;
                case 4:
                System.out.println("Thanks for using the ATM!");
                System.exit(0);
                default:
                System.out.println("Enter valid number for operation!");
            }  
        }

    }
}
