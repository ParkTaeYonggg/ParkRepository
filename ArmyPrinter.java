package day0630;
// 사용자로부터 성별, 나이, 신체등급 순으로 입력받아서

// 현역, 공익, 면제를 판별해주는 코드 만들기.
// 단, 성별이 여성일 경우 "여성에게는 국방의 의무가 주어지지 않습니다." 출력하기.
// 단, 미성년자일때, "미성년자는 아직 신체 등급이 부여되지 않습니다." 출력하기.

// 현역 : 1~3등급
// 공익 : 4급
// 면제 : 그외

// 성별을 받을 때에는 1,2로 남, 녀임.
import java.util.Scanner;

public class ArmyPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int ST1 = 1;
        final int ST2 = 3;
        final int ST3 = 4;
        String res;
        System.out.println("국방의무 프로그램");
        System.out.println("성별을 입력하시오. ex 남자면 1, 여자면 2");
        System.out.print("> ");
        int sex = sc.nextInt();
        if (sex <= 2) {
            // if문을 하나 줄일 수 있음.
            // 지금 이 페이지에 나온건 너무 조잡함.
            if (sex == 2) {
                System.out.println("여성에게는 국방의 의무가 주어지지 않습니다.");
            } else {
                System.out.println("나이를 입력하십시오.");
                System.out.print("> ");
                int num = sc.nextInt();
                if (num > 0) {
                    if (num < 19) {
                        System.out.println("미성년자에게는 아직 신체등급이 부여되지 않습니다.");
                    } else {
                        System.out.println("신체등급을 입력하시오.");
                        System.out.print("> ");
                        int gra = sc.nextInt();
                        if (ST1 <= gra && gra <= ST2) {
                            res = "축하드립니다. 현역입니다.";
                        } else if (gra == ST3) {
                            res = "공익입니다.";
                        } else {
                            res = "면제";
                        }
                        System.out.println(res);
                    }

                }
            }

        }

    }
}
