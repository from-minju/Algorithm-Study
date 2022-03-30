//StringBuilder타입의 변수 sb의 값을 지우는 구문은 누구?
public class n08 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("승횽이");
        sb.append("민주");
        System.out.println(sb);
        //System.out.println(sb.size());
        System.out.println(sb.length());
    }
}

//sb.delete(x, y) : 인덱스x부터 인덱스y-1까지의 내용을 삭제한다.

// length, length(), size() 차이
// length : 배열의 길이를 알고자 할 때  array1.length
// length() : 문자열의 길이를 알고자 할 때  string1.length()
//sb.length() : 컬렉션프레임워크(ArrayList, Set 등)타입의 길이를 알고자 할 때 사용한다.
//  ArrayList<Object> test = new ArrayList<Object>();
//  System.out.println(test.size());
//참고  https://doctorson0309.tistory.com/670

//removeAll() : ArrayList()에서 쓰임
//deleteAll() : 자바에서 안쓰임