import java.util.ArrayList;
import java.util.List;

public class n07 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Tech");
        arrayList.add("Expert");
        arrayList.set(0, "Java");
        arrayList.forEach(a -> a.concat("Forum"));
        arrayList.replaceAll(s -> s.concat("Group"));
        System.out.println(arrayList);

    }
}
//https://java.tutorialink.com/difference-between-arraylist-foreach-and-arraylist-replaceall/
// concat자체는 원본을 바꾸는 함수가 아니라 새로운 스트링 값을 던져주는 함수임.
// 그런데 foreach문에서는 concat이 리턴한 새로운 객체를 원본에 적용시켜주는 능력이 없음.
// 하지만 replaceAll은 concat에서 받아온 리턴값을 원본에 적용시켜줌. replaceAll은 원본을 바꾸는 함수이기 때문.
// 따라서 replaceAll만 원본에 영향을 미쳐 값이 변하게 되는것임.
