import java.util.*;
class Imple
{
    String oq[],pp[];
    int oqn,ppn;
    void enterData(Scanner s)
    {
        System.out.print("Enter the no of participants in online quiz:");
        oqn=s.nextInt();
        s.nextLine();
        oq=new String[oqn];
        System.out.println("Enter name:");
        for(int i=0;i<oqn;i++)
        {
            System.out.print("Participant "+(i+1)+":");
            oq[i]=s.nextLine();
        }
        System.out.print("Enter the no of participants in paper presentation:");
        ppn=s.nextInt();
        s.nextLine();
        pp=new String[ppn];
        System.out.println("Enter name:");
        for(int i=0;i<ppn;i++)
        {
            System.out.print("Participant "+(i+1)+":");
            pp[i]=s.nextLine();
        }
    }
    void dispBoth()
    {   int d=oqn>ppn?oqn:ppn;
        int e=oqn<ppn?oqn:ppn;
        System.out.println("Names of participants reigstered for both:");
        if(ppn>oqn)
        {
            for(int i=0;i<e;i++)
            {   
                for(int j=0;j<d;j++)
                {
                    if(oq[i].equals(pp[j]))
                    {
                        System.out.println(oq[i]);
                        break;
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<e;i++)
            {   
                for(int j=0;j<d;j++)
                {
                    if(pp[i].equals(oq[j]))
                    {
                        System.out.println(oq[j]);
                        break;
                    }
                }
            }
        }
    }
}
class Organizer
{
    public static void main(String[] args)
    {
        Imple obj=new Imple();
        Scanner s = new Scanner(System.in);
        obj.enterData(s);
        obj.dispBoth();
    }
}