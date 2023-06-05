package bitcamp.myapp;

import bitcamp.util.Calculator; // bitcamp.util.Calculator.result 형식으로 바꿔주고 import 문은 삭제됨.

public class Test {

  public static void main(String[] args) {

    Calculator.set(90);

    Calculator.plus(3);
    Calculator.minus(7);
    Calculator.multiple(2);
    Calculator.divide(2);

    System.out.println(Calculator.result);

  }

} 
