import java.util.*;//This to do 1.Compute pay(done) 2.A function to accept inputs for employee hoursworked until no or exit is typed by user 3. A display function that uses 
class weekly//continue when encountering negative workhours and display total employees and total workhours ( individual as well )
{
    int hoursWorked;
    static int hourlyWage;
    double computePay() // or double???
    {
        if(hoursWorked<=40)
            return hourlyWage*hoursWorked;
        else
            return 40*hourlyWage + 1.5*hourlyWage*(hoursWorked-40);
    }
    weekly()
    {
        hoursWorked=0;
    }
    void getInfo(int i,Scanner s)
    {
        System.out.println("Employee " + (i+1) + ":");
        System.out.print("Enter hours worked:");
        hoursWorked=s.nextInt();
        
    }
    void WageAssign(Scanner s)
    {
        System.out.print("Enter the hourly wage for the employees:");
        hourlyWage=s.nextInt();
    }
    void dispDetails(int i)
    {
        System.out.println("Employee " + (i+1) + ":");
        System.out.println("Hours Worked:"+hoursWorked);
        System.out.println("Weekly Wage:"+computePay());
    }
}
class weekPay
{   
    
    public static void main(String[] args)
    {   
        weekly obj=new weekly();
        int n; int ct=0;
        System.out.print("Enter the no of employees:");
        Scanner s = new Scanner(System.in);
        Scanner str=new Scanner(System.in);
        n=s.nextInt();
        weekly []emp= new weekly[n];
        obj.WageAssign(s);
        for(int i=0;i<n;i++)
        {
            emp[i] = new weekly();
            emp[i].getInfo(i,s);
            ct++;
            System.out.print("Enter 'no'/'exit' to stop:");
            String aa=str.nextLine();
            if(aa.equals("no")||aa.equals("exit"))
                break;
        }
        for(int i=0;i<ct;i++)
        {
            if(emp[i].hoursWorked>=0)
                emp[i].dispDetails(i);
            else
                continue;
        }
    }
}
