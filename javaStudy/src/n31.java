public class n31 {
    public static void main(String[] args) {
        String str = " ";
        str.trim();
        //System.out.print(str);
        System.out.println(str.equals("") + " " + str.isEmpty());
    }
}

//trim() : 문자열 좌우에 있는 공백을 없애준다.
//trim은 문자열 좌우에 대한 공백인데 str은 문자열도 없고 그냥 공백이므로 변화없음.
