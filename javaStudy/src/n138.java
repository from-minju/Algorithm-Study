import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class n138 {
    //109번과 유사
    //반환만 하고 원본은 바꾸지 않는 값이므로

    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2014, 7, 31, 1, 1);
        dt.plusDays(30);
        dt.plusMonths(1);
        System.out.print(dt.format (DateTimeFormatter.ISO_DATE));
    }
}
