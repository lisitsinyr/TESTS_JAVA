//=======================================================================================
// Template_LanguageReference_JAVA.java
//=======================================================================================

//------------------------------------------
// БИБЛИОТЕКИ java
//------------------------------------------
//------------------------------------------

//------------------------------------------
// БИБЛИОТЕКИ сторонние
//------------------------------------------
//------------------------------------------

//------------------------------------------
//БИБЛИОТЕКА LU
//------------------------------------------
//------------------------------------------

//------------------------------------------------------------
// Chapter 3. Lexical Structure
//------------------------------------------------------------
// 3.7. Comments
//------------------------------------------------------------
/*
A traditional comment: all the text from the ASCII characters / * to the ASCII characters * /
*/

// An end-of-line comment: all the text from the ASCII characters // to the end of the line is ignored

/* this comment /* // /** ends here: */

//------------------------------------------------------------
// 3.9. Keywords
//------------------------------------------------------------
// ReservedKeyword:
//------------------------------------------------------------
abstract   continue   for          new         switch
assert     default    if           package     synchronized
boolean    do         goto         private     this
break      double     implements   protected   throw
byte       else       import       public      throws
case       enum       instanceof   return      transient
catch      extends    int          short       try
char       final      interface    static      void
class      finally    long         strictfp    volatile
const      float      native       super       while
_ (underscore)
//------------------------------------------------------------
// ContextualKeyword:
//------------------------------------------------------------
exports      opens      requires     uses
module       permits    sealed       var
non-sealed   provides   to           with
open         record     transitive   yield
//------------------------------------------------------------

//------------------------------------------------------------
// 3.10. Literals
//------------------------------------------------------------
// 3.10.1. Integer Literals
//------------------------------------------------------------
// Examples of int literals:
    0    2    0372    0xDada_Cafe    1996    0x00_FF__00_FF
// Examples of long literals:
    0l    0777L    0x100000000L    2_147_483_648L    0xC0B0L
//------------------------------------------------------------
// 3.10.2. Floating-Point Literals
//------------------------------------------------------------
// Examples of float literals:
    1e1f    2.f    .3f    0f    3.14f    6.022137e+23f
// Examples of double literals:
    1e1    2.    .3    0.0    3.14    1e-9d    1e137
//------------------------------------------------------------
// 3.10.3. Boolean Literals
//------------------------------------------------------------
// BooleanLiteral:
    true false
//------------------------------------------------------------
// 3.10.4. Character Literals
//------------------------------------------------------------
// The following are examples of char literals:
    'a'
    '%'
    '\t'
    '\\'
    '\''
    '\u03a9'
    '\uFFFF'
    '\177'
    '™'
//------------------------------------------------------------
// 3.10.5. String Literals
//------------------------------------------------------------
// The following are examples of string literals:
    ""                    // the empty string
    "\""                  // a string containing " alone
    "This is a string"    // a string containing 16 characters
    "This is a " +        // actually a string-valued constant expression,
    "two-line string"     // formed from two string literals
//------------------------------------------------------------
// 3.10.6. Text Blocks
//------------------------------------------------------------
String story = """
            "When I use a word," Humpty Dumpty said,
            in rather a scornful tone, "it means just what I
            choose it to mean - neither more nor less."
            "The question is," said Alice, "whether you
            can make words mean so many different things."
            "The question is," said Humpty Dumpty,
            "which is to be master - that's all."
        """;
//------------------------------------------------------------
// 3.10.7. Escape Sequences
//------------------------------------------------------------
// 3.10.8. The Null Literal
//------------------------------------------------------------
// NullLiteral:
    null
//------------------------------------------------------------
// 3.11. Separators
//------------------------------------------------------------
// Separator:
    (   )   {   }   [   ]   ;   ,   .   ...   @   ::
//------------------------------------------------------------
// 3.12. Operators
//------------------------------------------------------------
// Operator:
    =   >   <   !   ~   ?   :   ->
    ==  >=  <=  !=  &&  ||  ++  --
    +   -   *   /   &   |   ^   %   <<   >>   >>>
    +=  -=  *=  /=  &=  |=  ^=  %=  <<=  >>=  >>>=
//------------------------------------------------------------
// Chapter 4. Types, Values, and Variables
//------------------------------------------------------------

//------------------------------------------------------------
// 4.2.2. Integer Operations
//------------------------------------------------------------
// The comparison operators, which result in a value of type boolean:
//The numerical comparison operators
    <, <=, >, >=
//The numerical equality operators
    ==, !=
// The numerical operators, which result in a value of type int or long:
// The unary plus and minus operators
    +, -
// The multiplicative operators
    *, /, %
// The additive operators
    +, -
// The increment operator [both prefix and postfix]
    ++
// The decrement operator [both prefix and postfix]
    --
// The signed and unsigned shift operators 
    <<, >>, >>>
// The bitwise complement operator 
    ~ 
// The integer bitwise operators 
    &, ^, |
//The conditional operator
    ?
//------------------------------------------------------------
// 4.2.4. Floating-Point Operations
//------------------------------------------------------------
//The comparison operators, which result in a value of type boolean:
//The numerical comparison operators
    <, <=, >, >=
//The numerical equality operators
    ==, !=
//The numerical operators, which result in a value of type float or double:
//The unary plus and minus operators
    +, -
//The multiplicative operators
    *, /, %
//The additive operators
    + and - (§15.18.2)
//The increment operator [both prefix and postfix]
    ++
//The decrement operator [both prefix and postfix]
    --
//The conditional operator
    ?
//------------------------------------------------------------
// 4.2.5. The boolean Type and boolean Values
//------------------------------------------------------------
//The boolean operators are:
//The relational operators
    ==, !=
//The logical complement operator
    !
//The logical operators
    &, ^, |
//The conditional-and and conditional-or operators 
    &&, ||
//The conditional operator
    ?
//------------------------------------------------------------
// 4.3. Reference Types and Values
//------------------------------------------------------------
// 4.3.1. Objects
//------------------------------------------------------------
[public] class Point {
    [public] int x;
    [public] int y;
    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    Point () {
        System.out.println("default");
    }
    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    //----------------------------------------------------------
    // Constructor Экземпляр Point явно создается во время инициализации класса:
    //----------------------------------------------------------
    static Point origin = new Point (0,0);
    //----------------------------------------------------------
    // Constructor Строка может быть неявно создана оператором +
    //----------------------------------------------------------
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    //----------------------------------------------------------
    // Метод
    //----------------------------------------------------------
    void displayInfo () {
        System.out.printf("x: %d \ty: %d\n", x, y);
    }
}
//Класс Object является суперклассом всех других классов.
//Все типы классов и массивов наследуютметоды класса Object, которые резюмируются следующим образом:
//  Метод clone используется для создания копии объекта.
//  Метод equals определяет понятие равенства объектов, основанное на сравнении значения, а не ссылки.
//  Метод finalize запускается непосредственно перед уничтожением объекта.
//  Метод getClass возвращает объект класса, представляющий класс объекта.


//-------------------------------------------------------------------------------
// class Template (A1, A2, ...):
//-------------------------------------------------------------------------------
[public] class Template (A1, A2, ...) {
    [public] int x;
    [public] int y;
    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    Template () {
    }
    //----------------------------------------------------------
    // Constructor
    //----------------------------------------------------------
    Template (int x, int y) {
    }
    //----------------------------------------------------------
    // Метод
    //----------------------------------------------------------
    [void] displayInfo () {
        ;
    }
}

public class TVersionInfo {
    //--------------------------------------------------
    // Переменные
    //--------------------------------------------------
    public String LUClassName = "TVersionInfo";
    private String FFileName;

    //--------------------------------------------------
    // constructor
    //--------------------------------------------------
    TVersionInfo () {
        this.FFileName = ""
    }

    //--------------------------------------------------
    // destructor
    //--------------------------------------------------
    void Finalize () {
        ;
    }

    //--------------------------------------------------
    // @property FileName
    //--------------------------------------------------
    // getter
    //@property
    public String GetFileName() {
        return this.FFileName;
    }
    // setter
    //@FileName.setter
    void FileName(String Value) {
        this.FFileName = Value
    }
    public void setFileName(String Value) {
        this.FFileName = Value;
    }

    //--------------------------------------------------
    // @property Major1
    //--------------------------------------------------
    // getter
    //@property
    int Major1 () {
        int LResult = 0
        return LResult
    }

//------------------------------------------------------------
// 4.3.3. The Class String
//------------------------------------------------------------
//Экземпляры класса String представляют последовательности кодовых точек Unicode.
//Объект String имеет постоянное (неизменное) значение.
//Строковые литералы и текстовые блоки являются ссылками на экземпляры класса String.
//Оператор конкатенации строк + неявно создает новый объект String, когда результат не является постоянным выражением.

//------------------------------------------------------------
// 4.4. Type Variables
//------------------------------------------------------------
//Example 4.4-1. Members of a Type Variable
package TypeVarMembers;

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
        t.mCPrivate();    // Compile-time error
    } 
}

//------------------------------------------------------------
// Chapter 6. Names
//------------------------------------------------------------
// 6.1. Declarations
//------------------------------------------------------------
//Следует избегать односимвольных имен локальных переменных или параметров, за исключением временных и циклических переменных или случаев, когда переменная содержит неотличимое значение типа. Обычные односимвольные имена:
    b for a byte
    c for a char
    d for a double
    e for an Exception
    f for a float
    i, j, and k for ints
    l for a long
    o for an Object
    s for a String
    v for an arbitrary value of some type

//------------------------------------------------------------
//Chapter 8. Classes
//------------------------------------------------------------
//Объявление класса определяет новый класс и описывает, как он реализован (§8.1).
//В теле класса объявляются члены (поля, методы, классы и интерфейсы),
//экземпляры и статические инициализаторы, а также конструкторы (§8.1.7).

//------------------------------------------------------------
// Chapter 10. Arrays
//------------------------------------------------------------
//Example 10.2-1. Declarations of Array Variables
int[]     ai;        // array of int
short[][] as;        // array of array of short
short     s,         // scalar short
          aas[][];   // array of array of short
Object[]  ao,        // array of Object
          otherAo;   // array of Object
Collection<?>[] ca;  // array of Collection of unknown type
//----------------------------------------------------
Exception ae[]  = new Exception[3];
Object aao[][]  = new Exception[2][3];
int[] factorial = { 1, 1, 2, 6, 24, 120, 720, 5040 };
char ac[]       = { 'n', 'o', 't', ' ', 'a', ' ',
                    'S', 't', 'r', 'i', 'n', 'g' };
String[] aas    = { "array", "of", "String", };
//----------------------------------------------------
byte[] rowvector, colvector, matrix[];
is equivalent to:
byte rowvector[], colvector[], matrix[][];
//----------------------------------------------------
int a, b[], c[][];
is equivalent to the series of declaration statements:
int a;
int[] b;
int[][] c;
//----------------------------------------------------
float[][] f[][], g[][][], h[];  // Yechh!
is equivalent to the series of declarations:
float[][][][] f;
float[][][][][] g;
float[][][] h;
//----------------------------------------------
// 10.4. Array Access
//----------------------------------------------
//Все массивы имеют 0-начало. Массив длины n может быть проиндексирован целыми числами от 0 до n-1.
//Example 10.4-1. Array Access
class Gauss {
    public static void main(String[] args) {
        int[] ia = new int[101];
        for (int i = 0; i < ia.length; i++) ia[i] = i;
        int sum = 0;
        for (int e : ia) sum += e;
        System.out.println(sum);
    }
}
//----------------------------------------------------
// 10.6. Array Initializers
//----------------------------------------------------
//Example 10.6-1. Array Initializers
class Test {
    public static void main(String[] args) {
        int[][] ia = { { 1, 2 }, null };
        for (int[] ea : ia) {
            for (int e: ea) {
                System.out.println(e);
            }
        }
    }
}
//----------------------------------------------------
// Chapter 11. Exceptions
//----------------------------------------------------
// Chapter 12. Execution
//----------------------------------------------------
// 12.4.1. When Initialization Occurs
//----------------------------------------------------
Example 12.4.1-1. Superclasses Are Initialized Before Subclasses
class Super {
    static { System.out.print("Super "); }
}
class One {
    static { System.out.print("One "); }
}
class Two extends Super {
    static { System.out.print("Two "); }
}
class Test {
    public static void main(String[] args) {
        One o = null;
        Two t = new Two();
        System.out.println((Object)o == (Object)t);
    }
}
//This program produces the output:
//  Super Two false

//Example 12.4.1-2. Only The Class That Declares static Field Is Initialized
class Super {
    static int taxi = 1729;
}
class Sub extends Super {
    static { System.out.print("Sub "); }
}
class Test {
    public static void main(String[] args) {
        System.out.println(Sub.taxi);
    }
}
//This program prints only:
//1729
//----------------------------------------------------
// Chapter 13. Binary Compatibility
//----------------------------------------------------
//----------------------------------------------------
// Chapter 14. Blocks, Statements, and Patterns
//----------------------------------------------------
//----------------------------------------------------
// 14.3. Local Class and Interface Declarations
//----------------------------------------------------
//Example 14.3-1. Local Class Declarations
class Global {
    class Cyclic {}

    void foo() {
        new Cyclic(); // create a Global.Cyclic
        class Cyclic extends Cyclic {} { // circular definition

            class Local {} {
                class Local {} // compile-time error
            }

            class Local {} // compile-time error

            class AnotherLocal {
                void bar() {
                    class Local {} // ok
                }
            }
        }
        class Local {} // ok, not in scope of prior Local
    }
}

//----------------------------------------------------
// 14.4. Local Variable Declarations
//----------------------------------------------------
//Example 14.4-1. Local Variables Declared With var
var a = 1;            // Legal
var b = 2, c = 3.0;   // Illegal: multiple declarators
var d[] = new int[4]; // Illegal: extra bracket pairs
var e;                // Illegal: no initializer
var f = { 6 };        // Illegal: array initializer
var g = (g = 7);      // Illegal: self reference in initiali
//----------------------------------------------------
// 14.4.1. Local Variable Declarators and Types
//----------------------------------------------------
//Example 14.4.1-1. Type of Local Variables Declared With var
var a = 1;                // a has type 'int'
var b = java.util.List.of(1, 2);  // b has type 'List<Integer>'
var c = "x".getClass();   // c has type 'Class<? extends String>' 
                          // (see JLS 15.12.2.6)
var d = new Object() {};  // d has the type of the anonymous class
var e = (CharSequence & Comparable<String>) "x";
                          // e has type CharSequence & Comparable<String>
var f = () -> "hello";    // Illegal: lambda not in an assignment context
var g = null;             // Illegal: null type

//----------------------------------------------------
// 14.5. Statements
//----------------------------------------------------
14.6. The Empty Statement
//----------------------------------------------------
;
//----------------------------------------------------
14.7. Labeled Statements
//----------------------------------------------------
Identifier : Statement

Identifier : StatementNoShortIf
//----------------------------------------------------
// 14.8. Expression Statements
//----------------------------------------------------
StatementExpression ;

Assignment
PreIncrementExpression
PreDecrementExpression
PostIncrementExpression
PostDecrementExpression
MethodInvocation
ClassInstanceCreationExpression
//----------------------------------------------------
// 14.9. The if Statement
//----------------------------------------------------
if ( Expression ) Statement
if ( Expression ) StatementNoShortIf else Statement
if ( Expression ) StatementNoShortIf else StatementNoShortIf

if (bool_condition) {
    statement1
} else {
    statement2
}

If (bool_condition1) {
    statement1
} else if (bool_condition2) {
    statement2
} else if (bool_conditionN) {
    statementN
} else {
    statementN+1
}

//----------------------------------------------------
// 14.10. The assert Statement
//----------------------------------------------------

//----------------------------------------------------
// 14.11. The switch Statement
//----------------------------------------------------
switch (argument) {
    case value1:
        statement1;
        break;
    case value2:
        statement2;
        break;
    case valueN:
        statementN;
        break;
    default:
        default_statement;
        break;
}

//----------------------------------------------------
// 14.12. The while Statement
//----------------------------------------------------
while (expression) {
    // одно или несколько утверждений
}
// бесконечная петля
while ( ; ; ) {
    // какой-то код
}
//----------------------------------------------------
// 14.13. The do Statement
//----------------------------------------------------
do {
    // одно или несколько утверждений
} while (expression);
//----------------------------------------------------
// 14.14. The for Statement
//----------------------------------------------------
for(<начальная точка>; <условие выхода>; <операторы счетчика>) {
    // Тело цикла
}
//----------------------------------------------------
// 14.15. The break Statement
//----------------------------------------------------
break [Identifier];
//----------------------------------------------------
// 14.16. The continue Statement
//----------------------------------------------------
continue [Identifier];
//----------------------------------------------------
// 14.17. The return Statement
//----------------------------------------------------
return [Expression] ;
//----------------------------------------------------
// 14.18. The throw Statement
//----------------------------------------------------
throw Expression ;
//----------------------------------------------------
// 14.19. The synchronized Statement
//----------------------------------------------------
synchronized ( Expression ) Block
//----------------------------------------------------
// 14.20. The try statement
//----------------------------------------------------

//----------------------------------------------------
// 14.21. The yield Statement
//----------------------------------------------------
yield Expression ;
//----------------------------------------------------
// Chapter 15. Expressions
//----------------------------------------------------
//----------------------------------------------------
// Chapter 16. Definite Assignment
//----------------------------------------------------
//----------------------------------------------------
// Chapter 17. Threads and Locks
//----------------------------------------------------
//----------------------------------------------------
// Chapter 18. Type Inference
//----------------------------------------------------
//----------------------------------------------------
Chapter 19. Syntax
//----------------------------------------------------

//------------------------------------------
//
//------------------------------------------
//beginmodule
if __name__ == "__main__":
    ...
//endif

//endmodule
//------------------------------------------
