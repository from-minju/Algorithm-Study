

class S1 {
    protected void display(int x) {
        System.out.print("Parent" + x);
    }
}

class S2 extends S1 {
    public void display(int x, int y) {
        this.display(x);
        display(y);
        super.display(y);
    }
    public void display(int x) {
        System.out.println("Child" + x);
    }
}

public class n74 {
    public static void main(String[] args) {
        S2 sobj = new S2();
        sobj.display(10,100);
    }
}