import java.util.Locale;

public class n110 {
    public static void main(String[] args) {
        //문자열을 비교할 때는 ==연산자를 이용하지 않는다.
        //문자열 비교는 .equals를 이용한다.

        String str1 = "Java";
        String str2 = new String("java");

        str1 = str1.toLowerCase();
        System.out.println(str1);

        if(str1 == str2)
        {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
