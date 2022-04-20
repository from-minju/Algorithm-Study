
public class n68 {
    public static void main(String[] args) {
        int[] intArr = {8, 16, 32, 64, 128};

        for(int i : intArr) {
            System.out.print(i + " ");
        }
    }
}

/*
* A: 에러가 남. 처음에 i에 8이 들어오고 intArr[8]을 출력하게 되므로.. ArrayIndexOutOfBoundsException
* B : 맞음
* C : A와 같은 이유로...
* D : 1,2,3,4,5 rk cnffurehl
*
*
* */

