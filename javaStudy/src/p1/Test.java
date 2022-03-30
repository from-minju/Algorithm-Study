package p1;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello " + new StringBuilder("Java SE 8"));
        System.out.println("Hello " + new MyString("Java SE 8"));


    }
}

// https://vceguide.com/what-is-the-result-427/
// Applying the println() method on StringBuilder or String objects will print its contents.
// Unlike other objects in which println() method prints the hascode of the object.
