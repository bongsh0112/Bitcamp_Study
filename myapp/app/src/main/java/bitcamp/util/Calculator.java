package bitcamp.util;

public class Calculator {
  public static int result; // static 변수는 자동적으로 0으로 초기화

  public static void set(int a) {
    result = a;
  }

  public static void plus(int a) {
    result += a;
  }

  public static void minus(int a) {
    result -= a;
  }

  public static void multiple(int a) {
    result *= a;
  }

  public static void divide(int a) {
    result /= a;
  }
}