//
////부모는 자식 타입에 들어갈 수 없기 때문에 예외 뜸
//
//class A {
//    public void test() {
//        System.out.println("A");
//    }
//}
//
//class B extends A{
//    public void test() {
//        System.out.println("B");
//    }
//}
//
//public class n62 extends A{
//    public void test() {
//        System.out.println("C");
//    }
//
//    public static void main(String[] args) {
//        A b1 = new A();
//        A b2 = new n62();
//
//        b1 = (A) b2;
//        A b3 = (B) b2;
//        b1.test();
//        b3.test();
//    }
//}