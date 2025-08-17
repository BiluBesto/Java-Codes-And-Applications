import java.util.*;
class Book
{
    String btitle;
    String author;
    int price;
    int yearofpub;
    int daysLate;
    int finePerDay=1;
    Book(String b,String a,int y,int p)
    {
        btitle=b;
        author=a;
        yearofpub=y;
        price=p;
    }
    void setlate(Scanner s)
    {   while(true)
        {   
            System.out.print("Enter the no of days the book is returned late:");
            if((daysLate=s.nextInt())<0)
            {
                System.out.println("Enter valid number!");
                continue;
            }
            break;
        }
    }
    void calcfine()
    {
        System.out.println("Total Fine : $"+(daysLate*finePerDay));

    }
    void disp()
    {  
        System.out.println("\nBook Name : "+btitle);
        System.out.println("Author of Book : "+author);
        System.out.println("Price : $"+price);
        System.out.println("Year of Publication : "+yearofpub);
        System.out.println("No of days late : "+daysLate);
        calcfine();
    }
}
public class Library
{
    public static void main(String[] args)
    {   Scanner s=new Scanner(System.in);
        Scanner v=new Scanner(System.in);
        Scanner d=new Scanner(System.in);
        System.out.println("Enter no of books to return:");
        int n;
        n=d.nextInt();
        Book b[]=new Book[n];
        String t,a;
        int yp,p;
        for(int i=0;i<n;i++)
        {   System.out.println("--- Book "+(i+1)+" ---");
            System.out.print("Enter book name:");
            t=s.nextLine();
            System.out.print("Enter book author's name:");
            a=s.nextLine();
            while(true)
            {
                System.out.print("Enter price($) of book:");
                if((p=v.nextInt())<=0)
                {
                    System.out.println("Enter valid price");
                    continue;
                }
                break;
            }
            while(true)
            {
                System.out.print("Enter year of publication of book:");
                
                if((yp=v.nextInt())<=0)
                {
                    System.out.println("Enter valid year");
                    continue;
                }
                break;
            }
                b[i]=new Book(t,a,yp,p);
                b[i].setlate(v);
        }
        System.out.println("---------Book Details---------");
        for(int i=0;i<2;i++)
        {   
            b[i].disp();
        }  
    }
}
