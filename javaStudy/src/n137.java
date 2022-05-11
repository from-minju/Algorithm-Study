public class n137 {
    public static String maskCC(String creditCard) {
        String x = "XXXX-XXXX-XXXX-";

        StringBuilder sb = new StringBuilder(creditCard);
        StringBuilder s = sb.insert(0, x);
        return s.toString();
    }
    public static void main(String[] args) {
        //sb.substring의 경우 새로운 값을 리턴해주므로
        //원본값은 바뀌지 않는다.
        //ㄸㅏ라서 A의 경우 XXXX-XXXX-XXXX-1234-5678-9101-1121이 출력됨
        //a.append는 원본도 바뀜

        System.out.println(maskCC("1234-5678-9101-1121"));
    }
}
