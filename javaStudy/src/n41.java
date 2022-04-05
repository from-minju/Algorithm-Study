public class n41 {
    public static void main(String[] args) {
        int x = 100;
        int a = x++;
        int b = ++x;
        int c = x++;
        int d = (a<b) ? (a<c) ? a: (b<c)? b: c: x;
        System.out.println(d);
    }
}
//    x103
//    a100
//    b102
//    c102
