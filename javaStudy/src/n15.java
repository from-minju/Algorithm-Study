import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class n15 {
    public static void main(String[] args) {
        String date = LocalDate
                .parse("2014-05-04")
                .format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(date);
    }
}
//parse()기능 : Java LocalDate parse() method is used to get a localdate from the text date.

//해설
//UnsupportedTemporalTypeException 예외가 실행 중에 발생하게 된다.
//DateTimeFormatter인 ISO_DATE_TIME이 LocalDate 객체에 사용될 수 없기 때문
//LocalDate 객체는 시간(Time) 정보를 갖고 있지 않다.
//만약 DateTimeFormatter로 ISO_DATE 를 사용할 경우, 다음의 결과를 얻을 수 있다.
//2014-05-04

