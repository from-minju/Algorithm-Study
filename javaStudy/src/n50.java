public class n50 {
    /*
    * https://sas-study.tistory.com/106
    *
    * 함수형 인터페이스 Predicate
    * Predicate<T>
    * T타입의 매개값을 사용해 조사 후 논리값(true, false)를 반환한다.
    * p.test() 이런식으로 사용
    *
    * 틀린이유
    * a. apply()는 Function<>에 쓰이는거, 애초에 101은 홀수이므로 false임
    * b. p.test()올바르고 100이 짝수이므로 true
    * c. boolean으로 리턴값이 나오는데 Integer로 결과를 받고있으므로 틀림
    * d. p.apply()가 아니라 p.test()임
    * */
}
