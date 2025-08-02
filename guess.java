import java.util.*;
class guessuse
{   int x,y;
    boolean check()
    {
        if(y==x)    
            {
                System.out.println("Congratulations! You have guessed the number correctly : "+ x);
                return true;
            }
            else if(y<x)
            {
                System.out.println("Guess Higher!");
                return false;
            }
            else
            {
                System.out.println("Guess Lower!");
                return false;
            }
    }
    void xAssign(Random r)
    {
        x=r.nextInt(1001);
    }
    void yGet(Scanner s)
    {
        y=s.nextInt();
    }
}
class guess
{
    public static void main(String[] args)
    {
        guessuse obj= new guessuse();
        Random r=new Random();
        obj.xAssign(r);
        Scanner s=new Scanner(System.in);
        while(true)
        {   
            System.out.println("Guess a number(0-1000):");
            obj.yGet(s);
            if(obj.check())
                break;
        }
    }
}
