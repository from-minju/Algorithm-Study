public class n28 {
    private char var;

    public static void main(String[] args) {
        char var1 = 'a';
        char var2 = var1;
        var2 = 'e';
    }
}

//char var2 = var1에서 var1의 주소값을 넘겨줬으니 var2도 역시 a가 됨.
//하지만 e로 바꿈. var2가 97에서ㅓ 101로 주소값이 바뀐거니까 var1은 건드린게 아니므로 var1에는 값 변동없음
//반면 클래스의 경우 다름. var1, var2가 클래스라 하면 var2.x = "hi"라 한다치면

//class A{
//    int num;
//}
//
//x = A
//y = x
//
//x.num = 20


