class staticrestuse
{
    int x=100;//non-static member variable
    static int n=200;//static member variable
    void disp()
    {
        System.out.println("Non - Static Method Called!");
        System.out.println("Static Member Variable Value:" + n);
        System.out.println("Non Static Member Variable Value:" + x);
        System.out.println("Calling Static Method From Non Static Method");
        fn(100);

    }
    void disp2()
    {
        System.out.println("Non - Static Method Called from Static Method!");
    }
    static void fn(int m)
    {
        System.out.println("Static Method Called from Non - Static Method!");
        System.out.println("Static Member Variable Value:" + n);
        //System.out.println("Non Static Member Variable Value:" + x); Error non static variable x cannot be referenced from a static context!
        //System.out.println("Calling Non - Static Method from Static Method");
        // disp2(); - Error non-static method disp2() cannot be referenced from a static context
        //System.out.println("Using this keyword for assigning value in static method");
        //this.m=m; Error non-static variable this cannot be referenced from a static context
        //System.out.println("Value assigned successfully with the help of this!");
        //System.out.println("Calling constructor with this keyword from static method");
        //this(20); Error Call to this must be first statement in constructor
    }
    staticrestuse()
    {
        System.out.println("Constructor Called!");
    }
    staticrestuse(int x)
    {
        System.out.println("Constructor Called with Value "+  x+"!");
    }
}
class staticrest
{      
    static void testcall()
    {
        System.out.println("Static Method Called from Main");
    }
    public static void main(String[] args)
    {
        staticrestuse obj=new staticrestuse();
        obj.disp();
        System.out.println("Calling static method without object");
        testcall();
        
    }
}   
