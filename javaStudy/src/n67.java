public class n67 {
    public static void main(String[] args) {
        String[] strs = new String[2]; //String[]에 값을 초기화하지 않았기 때문에 Null값이 들어간다.
        //int배열의 경우에는 Null값이 아니라 0이 들어감.
//        System.out.println(strs.length);

        int idx = 0;
        for(String s: strs){
            strs[idx].concat(" element " +idx); //strs[idx]는 Null이므로 concat안돼서 에러
            idx++;
        }

        for(idx=0; idx<strs.length; idx++){
            System.out.println(strs[idx]);
        }
    }
}
