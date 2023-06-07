package bitcamp.myapp.handler;

import bitcamp.util.Prompt;

public class MemberHandler {

  static final int MAX_SIZE = 100;

  static int[] no = new int[MAX_SIZE]; // 번호. userId를 집어넣음
  static String[] name = new String[MAX_SIZE];
  static String[] email = new String[MAX_SIZE];
  static String[] password = new String[MAX_SIZE];
  static char[] gender = new char[MAX_SIZE];

  static int userId = 1;
  static int length = 0;

  static final char MALE = 'M';
  static final char FEMALE = 'W';

  public static void inputMember() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다!");
      return;
    }

    name[length] = Prompt.inputString("이름? ");
    email[length] = Prompt.inputString("이메일? ");
    password[length] = Prompt.inputString("암호? ");

    inputGender(gender, userId);

    no[length] = userId++;
    length++;
  }

  public static void printMembers() {
    System.out.println("---------------------------------------");
    System.out.println("번호, 이름, 이메일, 성별");
    System.out.println("---------------------------------------");

    for (int i = 0; i < length; i++) {
      System.out.printf("%d, %s, %s, %s\n", 
        no[i], name[i], email[i], 
        toGenderString(gender[i]));
    }
  }

  public static void viewMember() {
    String memberNo = Prompt.inputString("번호? ");
    for (int i = 0; i < length; i++) {
      if (no[i] == Integer.parseInt(memberNo)) {
        System.out.printf("이름: %s\n", name[i]);
        System.out.printf("이메일: %s\n", email[i]);
        System.out.printf("성별: %s\n", toGenderString(gender[i]));
        return;
      }
    }
    System.out.println("해당 번호의 회원이 없습니다!");
  }

  public static void updateMember() {
    int n = Integer.parseInt(Prompt.inputString("번호? "));
    name[n - 1] = Prompt.inputString("이름(홍길동)?");
    email[n - 1] = Prompt.inputString("이메일(hong@test.com)?");
    password[n - 1] = Prompt.inputString("새암호?");
    inputGender(gender, n);
  }

  public static void inputGender(char[] gender, int n) {
    loop: while (true) {
      String label = "";
      if (gender[n - 1] == 0) {
        label = "성별: \n";
      } else {
        label = "성별(" + toGenderString(gender[n - 1]) + ")\n";
      }
      String menuNo = Prompt.inputString(label +
      "  1. 남자\n" + 
      "  2. 여자\n" + 
      "> ");

      switch (menuNo) {
        case "1":
          gender[n - 1] = MALE;
          break loop;
        case "2":
          gender[n - 1] = FEMALE;
          break loop;
        default:
          System.out.println("무효한 번호입니다.");
      }
    }
  }

  public static void deleteMember() {
    int n = Integer.parseInt(Prompt.inputString("삭제 할 번호? "));
    int deletedIndex = indexOf(n);
    if(deletedIndex == 1) {
      for (int i = 0; i < no.length; i++) {
        if (n == no[i]) {
          for(int j = i; j < no.length; j++) {
            if (j + 1 >= MAX_SIZE) {
              no[j] = 0;
              name[j] = null;
              email[j] = null;
              password[j] = null;
              gender[j] = 0;
              break;
            }
            no[j] = no[j+1];
            name[j] = name[j+1];
            email[j] = email[j+1];
            password[j] = password[j+1];
            gender[j] = gender[j+1];
          }
          length--;
          printMembers();
        } 
      }
    } else {
      System.out.println("존재하지 않는 번호입니다!");
    }
  }

  private static int indexOf(int memberNo) {
    for (int i = 0; i < length; i++) {
      if (memberNo == no[i]) {
        return 1;
      }
    }
    return -1;
  }

  public static String toGenderString(char gender) {
    return gender == 'M' ? "남성" : "여성";
  }

  private static boolean available() {
    return length < MAX_SIZE;
  }
}
