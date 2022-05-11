//public class n135 {
//}
//
//class App{
//    int foo;
//    static int bar;//当int类型成员变量没有被初始化时，默认初始化值为0
//    static void process() {
//        foo += 10; //编译错误，因为静态资源中不能直接访问非静态资源
//        bar += 10;
//    }
//    public static void main(String[] args) {
//        App firstObj = new App();
//        App.process();//所有类的对象共享同一个静态资源
//        System.out.println(firstObj.bar);
//        App secondObj = new App();
//        App.process();
//        System.out.println(secondObj.bar);
//    }
//}
