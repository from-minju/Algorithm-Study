//문제오류 : 답 D임
public class n12 {
    public static void main(String[] args) {
        int ans;
        try{
            int num = 10;
            int div = 0;
            ans = num / div;
        } catch (ArithmeticException ae){ //line n1
            ans = 0;
        } catch (Exception e) {
            System.out.println("Invalid calculation");
        }
        //System.out.println("Answer = " + ans); //line n2
    }
}

//line2에서 컴파일 오류
// ans를 임의의 수로 초기화시켜놓으면 에러는 없어지고 결과는 Answer = 0

