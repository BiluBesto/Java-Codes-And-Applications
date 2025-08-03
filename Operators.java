/*Develop a Java program to handle the inventory of ‘n’ grocery items. For each item, input the name,
 quantity, and unit price. Calculate the total value using arithmetic operators, apply a 5% discount if 
 the total exceeds ₹2000 using relational and assignment operators, and reduce the quantity by one using 
 unary operators to simulate a sale. Use a ternary operator to label items as "High Value" or 
"Low Value", and apply a bitwise operator to check if the remaining quantity is even or odd. */

import java.util.*;

class Imp
{
    String[] name;
    int[] quantity;
    double[] unitPrice;
    double priceTotal=0;// Total for all n items do new priceTotal calculn;ation
    int n;
    bool quality;
    void computeTotal()
    {
        if(priceTotal>2000)
            priceTotal=0.95*priceTotal;
    }
    void buy(int x,Scanner s)
    {
        System.out.print("Enter the quantity to buy:");
        int re= s.nextInt();
        if(re>quantity[x-1])
        {
            int temp=re;
            if(re>0)
            {
                while(re!=0)
                {
                    quantity[x-1]--;
                    re--;   
                }
                priceTotal+=temp*unitPrice[x-1];
            }
        }
        else
        {
            System.out.println("Enter a valid quantity!");
        }

    }
    void putInStock(Scanner s)
    {
        System.out.print("Enter the no of items to stock:");
        n=s.nextInt();
        name = new String[n];
        quantity = new int[n];
        unitPrice = new double[n];
        for(int i=1;i<=n;i++)
        {
            System.out.println("Item "+ i + ":");
            s.nextLine();
            System.out.print("Enter name:");
            name[i-1]=s.nextLine();
            while(true)
            {
                System.out.print("Enter quantity:");
                if(quantity[i-1]=s.nextInt()<=0)
                {
                    System.out.println("Enter valid quantity!");
                    s.nextLine();
                    continue;
                }
                break;   
            }
            while(true)
            {
                System.out.print("Enter unit price:");
                if(unitPrice[i-1]=s.nextDouble()<=0)
                {
                    System.out.println("Enter proper price!");
                    continue;
                }
                break;
            }
            char y;
            while(true)
            {
                System.out.print("Enter quality( 'g' for good 'b' for bad):");
                if(y=s.next().charAt(0)!='g'||y!='s')
                {
                    System.out.println("Enter quality correctly!");
                    continue;
                }
                if(y=='g')
                //TK
                break;
            }
        }
    }
    void buyItem(Scanner s)
    {   
        System.out.println("Enter the first number to buy the item(or enter anything to stop):");
        while(true)
        {
            char x;
            for(int i=1;i<=n;i++)
            {
                System.out.println( i + ". "+name[i-1]+ ", Price: "+unitPrice[i-1]+", Quantity:"+quantity[i-1]+", Quality:"+ quality?" High Value":"Low Value");

            }
            x=s.next().charAt(0);
            if((int)x>=48&&(int)x<=57)
                buy(x-'0',s);
        }
    }
    void disp()
    {
        computeTotal();
        System.out.println("The total price of the things you bought:"+priceTotal);
    }

}
class Operators
{
    public static void main(String[] args)
    {
        Imp a = new Imp();
        Scanner s=new Scanner(System.in);
        a.putInStock(s);
        a.buyItem(s);
        a.disp();
    }
}