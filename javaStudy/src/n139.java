public class n139 {
}

class C {
    public C() {
        System.out.print("C ");
    }
}

class B extends C {
    public B() {
        System.out.print("B ");
    }
}

class A extends B{
    public A() {
        System.out.print("A ");
    }

    public static void main(String[] args) {
        A a = new A();
    }
}
