
public class n114{
    int r;
    n114(int r){
        this.r=r;
    }
}
class DVD extends n114{
    int c;
    DVD(int r, int c){
        super(r);  //super.r = r; 이 구문은 아예 맞지 않는 구문이다.
        this.c=c;
    }

    public static void main(String[] args) {
        DVD dvd = new DVD(10,20);
        System.out.println(dvd.r + dvd.c);
    }

}