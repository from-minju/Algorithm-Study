
public class n81 {
}

class Book { int pages; }

class App {
    int count;
    public void method(Book x, int k) {
        x.pages = 100;
        k = 200;
    }

    public static void main(String[] args) {
        App obj = new App();
        Book objBook = new Book();
        System.out.println(objBook.pages + ":" + obj.count);
        obj.method(objBook, obj.count);
        System.out.println(objBook.pages + ":" +obj.count);
    }
}

//line18 : obj.count에 그냥 값 0을 전달한거임. 그래서 원본인 obj.count가 바뀌지 않음