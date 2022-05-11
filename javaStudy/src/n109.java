import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class n109 {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2014, 7, 31, 1, 1);
        dt.plusDays(30);
        dt.plusMonths(1);
        System.out.println(dt.format(DateTimeFormatter.ISO_DATE_TIME));
        //System.out.println(dt);

//        LocalDateTime today = LocalDateTime.now();     //Today
//        LocalDateTime tomorrow = today.plusDays(1);     //Plus 1 day
//        LocalDateTime yesterday = today.minusDays(1);   //Minus 1 day
//        System.out.println("Today:     "+today);
//        System.out.println("Tomorrow:  "+tomorrow);
//        System.out.println("Yesterday: "+yesterday);

        //.plusDays, .plusMonths는 새로운 값을 반환만 하기 때문에
        // 원본값이 변하지 않는다.
        // 변화된 값을 적용시키려면 새로운 변수에 할당해주어야 함.

    }
}
