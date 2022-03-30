class Test {
    static int count = 0;
    int i = 0;

    public void changeCount(){
        while(i<5){
            i++;
            count++;
        }
    }
}

public class n23 {
    public static void main(String[] args) {
        Test check1 = new Test();
        Test check2 = new Test();
        check1.changeCount();
        check2.changeCount();
        System.out.print(check1.count + ":" +check2.count);
    }
}

//Static 변수와 static 메소드는 Static 메모리 영역에 존재하므로 객체가 생성되기 이전에 이미 할당이 되어 있습니다. 그렇기 때문에 객체의 생성없이 바로 접근(사용)할 수 있습니다.

//static 변수
//메모리에 고정적으로 할당되어, 프로그램이 종료될 때 해제되는 변수
//Java에서 Static 변수는 메모리에 한번 할당되어 프로그램이 종료될 때 해제되는 변수로, 메모리에 한번 할당되므로 여러 객체가 해당 메모리를 공유하게 됩니다. 이해를 높이기 위해 코드를 추가하도록 하겠습니다.
//https://mangkyu.tistory.com/47
