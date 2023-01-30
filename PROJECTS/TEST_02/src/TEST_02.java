class Point {
    //------------------------------------------
    // Constructor
    //------------------------------------------
    int x;
    int y;
    Point () {
        System.out.println ("Constructor - default");
    }
    //------------------------------------------
    // Constructor
    //------------------------------------------
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    //---------------------------------------------------------------
    // Constructor Ёкземпл€р Point €вно создаетс€ во врем€ инициализации класса:
    //---------------------------------------------------------------
    static Point origin = new Point (0,0);
    //---------------------------------------------------------------
    // Constructor —трока может быть не€вно создана оператором +:
    //---------------------------------------------------------------
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    void displayInfo () {
        System.out.printf("x: %d \ty: %d\n", x, y);
    }
}

class C {
    public    void mCPublic()    {}
    protected void mCProtected() {}
    void mCPackage()   {}
    private   void mCPrivate()   {}
}

interface I {
    void mI();
}

class CT extends C implements I {
    public void mI() {}
}

class Test {
    <T extends C & I> void test(T t) {
        t.mI();           // OK
        t.mCPublic();     // OK
        t.mCProtected();  // OK
        t.mCPackage();    // OK
        //t.mCPrivate();    // Compile-time error
    }
}

public class TEST_02 {
    public static void main(String[] args) {
        //-------------------------------------------------
        // 1.Point €вно создаетс€ с помощью newInstance
        //-------------------------------------------------
        System.out.println("1.Point €вно создаетс€ с помощью newInstance");
        Point p = null;
        try {
            p = (Point) Class.forName("Point").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
        // —троки не€вно создаютс€ операторами +:
        System.out.println ("p: " + p);
        p.x = 4;
        p.y = 4;
        System.out.println ("p: " + p);
        p.displayInfo();

        //-------------------------------------------------
        // 2.ћассив не€вно создаетс€ инициализатором массива
        //-------------------------------------------------
        System.out.println("2.ћассив не€вно создаетс€ инициализатором массива");
        Point[] a = {new Point (0,0), new Point (1,1) };
        System.out.println ("a: { " + a[0] + ", " + a[1] + " }");

        //------------------------------------------------------------
        // 3.ћассив €вно создаетс€ выражением создани€ массива
        //------------------------------------------------------------
        System.out.println("3.ћассив €вно создаетс€ выражением создани€ массива");
        String[] sa = new String[2];
        sa[0] = "he"; sa[1] = "llo";
        System.out.println(sa[0] + sa[1]);

    }
}
