public class n74 {

}

class S1 {
    protected void display(int x) {
        System.out.print("Parent" + x);
    }
}

class S2 extends S1 {
    public void display(int x, int y) {
        this.display(x); //S2의 display()
        display(y); //S2의 display()
        super.display(y); //S1의 display()
    }
    public void display(int x) {
        System.out.println("Child" + x);
    }

    public static void main(String[] args) {
        S2 sobj = new S2();
        sobj.display(10,100);
    }

//public static void main()이 없으므로 에러남
//    S2 sobj = new S2();
//        sobj.display(10,100);

}
