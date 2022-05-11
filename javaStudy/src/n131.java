public class n131 {
    Character c;
    boolean b;
    float f;

    void printAll() {
        System.out.println(c);
        System.out.println(b);
        System.out.println(f);
    }

    public static void main(String[] args) {
        n131 f = new n131();
        f.printAll();
    }
}

//초기화되지 않은 객체에 대해서 출력하면
//Character -> null, boolean -> false, float -> 0.0