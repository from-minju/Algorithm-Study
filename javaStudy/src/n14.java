//덤프 정답 잘못 나옴, 정답 B번(A B C D E)
public class n14 {
    public static void main(String[] args) {
        String[][] arr = {{"A", "B", "C"}, {"D", "E"}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if(arr[i][j].equals("B")){
                    continue;
                }
            }
            continue;
        }
    }
}
