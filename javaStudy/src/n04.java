public class n04 {
    public static void main(String[] args){
        String opt = "true";
        switch (opt){
            case "true" :
                System.out.print("True");
                break;
            default:
                System.out.print("***");
        }
        System.out.println("Done");
    }
}

//switch문에서 사용할 수 있는 값 : char, byte, short, int, String 만 가능하다.

