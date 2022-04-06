public class n67 {
    public static void main(String[] args) {
        String[] strs = new String[2];
//        System.out.println(strs.length);

        int idx = 0;
        for(String s: strs){
            strs[idx].concat(" element " +idx);
            idx++;
        }
    }
}
