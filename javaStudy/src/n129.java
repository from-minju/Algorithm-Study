import java.io.IOException;

public class n129 {
}

class MyException extends RuntimeException {}

class Tests {
    public static void main(String[] args) {
        try{
            method1();
        }
        catch(MyException ne) {
            System.out.print("A");
        }
    }

    public static void method1() {
        try {
            throw 3 > 10 ? new MyException() : new IOException();
        } catch (IOException ie) {
            System.out.println("I");
        } catch (Exception re) {
            System.out.print("B");
        }
    }
}



