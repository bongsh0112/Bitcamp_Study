package bitcamp.myapp.handler;

/*핸들러 사용 규칙
=> 즉 메소드 호출 규칙을 정의
=> 메소드 시그니처와 리턴 타입을 정의
시그니처? 메소드명, 파라미터 목록
메소드 몸체는 작성하지 않는다. 호출 규칙만 정의하기 때문에.*/

public interface Handler {
  public abstract void execute();
}
