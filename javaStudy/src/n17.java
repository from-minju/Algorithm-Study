// 답 틀림, 답 A번임
public class n17 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int i = 0;
        do {
            System.out.print(arr[i] + " ");
            i++;
        } while(i < arr.length + i);
    }
}

//arr의 인덱스는 3까지만 있는데 while에서는 4까지 돌리니까 인덱스예외?오류?뜸
