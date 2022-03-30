public class n27 {
    String myStr = "9009";

    public void doStuff(String str) {
        int myNum = 0;
        try {
            String myStr = str;
            myNum = Integer.parseInt(myStr);
        } catch (NumberFormatException ne){
            System.err.println("Error");
        }
        System.out.println(
                "myStr: " + myStr + ", myNum: " + myNum);
    }

    public static void main(String[] args) {
        n27 obj = new n27();
        obj.doStuff("7007");
    }
}

//try블록 내에서 쓰인 지역변수는 try문 밖에서는 쓰지 못한다.(catch문에서도)
//
