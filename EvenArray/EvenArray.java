import java.util.Scanner;

class Impl
{
    int a[],b[],c[],ct=0,n1,n2;
    void disp()
    {
        c = new int[n1+n2];
        for(int i=0;i<n1;i++)
        {
            if(a[i]%2==0)
                c[ct++]=a[i];
        }
        for(int i=0;i<n2;i++)
        {
            if(b[i]%2==0)
                c[ct++]=b[i];
        }
        System.out.print("The New Array Elements:\n");
        for(int i=0;i<ct;i++)
        {
            System.out.print(c[i]+ " ");
            
        }
        System.out.println();
    }
    void input(Scanner s)
    {
        System.out.print("Enter the size of first array:");
        n1=s.nextInt();
        a=new int[n1];
        for(int i=0;i<n1;i++)
        {
            System.out.print("a["+i+"]:");
            a[i]=s.nextInt();
        }
        System.out.print("Enter the size of second array:");
        n2=s.nextInt();
        b=new int[n2];
        for(int i=0;i<n2;i++)
        {
            System.out.print("b["+i+"]:");
            b[i]=s.nextInt();
        }
    }
}
class EvenArray
{
    public static void main(String[] args)
    {
        Impl obj=new Impl();
        Scanner s = new Scanner(System.in);
        obj.input(s);
        obj.disp();
    }
}