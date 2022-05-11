
class Cart {
    Product p;
    double totalAmount;
}

class Product {
    String name;
    Double price;
}

public class n112 {
    public static void main(String[] args){
        Cart c = new Cart();
        System.out.println(c.p + ":" +c.totalAmount);
    }
}

//Product p는 따로 객체 생성하지 않았으므로 주소가 있지 않음. 그러므로 null
//객체가 생성되었다면 해시코드값이 나왔을듯?
