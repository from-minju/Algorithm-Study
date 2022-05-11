class Bird {
    public void fly() {
        System.out.print("Fly.");
    }
}

class Peacock extends Bird {
    public void dance() {
        System.out.print("Dance.");
    }
}

public class n117 {
    public static void main(String[] args) {
        //Bird p = new Peacock(); //Bird타입 변수에 넣었으므로 bird클래스에는 dance()가 없어서 실행 안됨

//        Bird b = new Bird();
//        Peacock p = (Peacock)b;

//        Peacock b = new Peacock();
//        Bird p = (Bird)b;

//        Bird b = new Peacock();
//        Peacock p = (Peacock)b;

//        p.fly();
//        p.dance();
    }
}
