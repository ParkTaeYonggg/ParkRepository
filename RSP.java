package day0701;
// 숙 2

// 가위 바위 보 게임
// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 2

//아직 플레이 기록이 없습니다.
// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 1

// 1. 가위 2. 바위 3. 보
// > 819
// 잘못입력했다.

// 1. 가위 2. 바위 3. 보
// > 2
// 사용자 선택 : 바위
// 컴퓨터 선택 : 가위
// 사용자 승!!

// 1. 플레이 2. 현재 기록 보기 3. 종료
// > 1

// 1. 가위 2. 바위 3. 보
// > 1
// 사용자의 선택 : 가위
// 사용자의 선택 : 바위
// 사용자 패!!

// 1. 플레이 2. 현 재 기록 보기 3. 종료
// 현재 전적 : 1승 0무 1패 (승률 : 50%)
//  1. 플레이 2. 현재 기록 보기 3. 종료

// > 3
// 플레이 해주셔서 감사.
import java.util.Scanner;
import java.util.Random;

public class RSP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int myChoice;
        int myWea;
        int score = 0;
        int cScore = 0;
        int equ = 0;
        String wea = null;
        String myW = null;
        boolean inputSwitch = false;
        System.out.println("가위바위보 게임!");

        while (true) {

            System.out.println("선택하시오");
            System.out.println("1. 플레이  2. 전적보기  3. 종료");
            System.out.print("> ");
            myChoice = sc.nextInt();

            if (myChoice == 1) {

                String wea1 = wea;
                String myW1 = myW;
                // 적의 무기 뽑음.
                int rr = r.nextInt(3) + 1;
                if (rr == 1) {
                    wea1 = "가위";
                } else if (rr == 2) {
                    wea1 = "바위";
                } else if (rr == 3) {
                    wea1 = "보";
                }
                System.out.println("무기를 선택하시오.");
                System.out.println("1. 가위 2. 바위 3. 보");
                System.out.print("> ");
                myWea = sc.nextInt();
                if (myWea == 1) {
                    myW1 = "가위";
                } else if (myWea == 2) {
                    myW1 = "바위";
                } else if (myWea == 3) {
                    myW1 = "보";
                }
                // 내 무기 뽑고 싸우기 시작.

                if (!(myWea == rr)) {
                    if ((myWea == 1 && rr == 3) || (myWea == 2 && rr == 1)
                            || (myWea == 3 && rr == 2)) {
                        System.out.println("나의 승리");
                        System.out.printf("나 : [%s] 컴퓨터 : [%s]\n", myW1, wea1);
                        score++;

                    } else if (myWea == 1 && rr == 2 || (myWea == 2 && rr == 3)
                            || (myWea == 3 && rr == 1)) {
                        System.out.println("나의 패배");
                        System.out.printf("나 : [%s] 컴퓨터 : [%s]\n", myW1, wea1);

                        cScore++;
                    } 
                } else if (myWea == rr) {
                    System.out.println("비겼습니다.");
                    System.out.printf("나 : [%s] 컴퓨터 : [%s]\n", myW1, wea1);
                    equ++;
                }

                inputSwitch = true;
            } else if (myChoice == 2) {
                if (inputSwitch) {
                    System.out.printf("현재 전적 : [%d]승 [%d]패 무승부 : [%s]\n", score, cScore, equ);
                    System.out.printf("현재 승률 [%.2f]%%\n ", ((double)score / (score + cScore + equ)) * 100);

                } else {
                    System.out.println("아직 전적이 없습니다.");
                }

            } else if (myChoice == 3) {
                System.out.println("게임 종료");
                break;
            } else if (myChoice <= 0 || myChoice > 3) {
                System.out.println("잘못입력하셨습니다. 아래 3가지 중에 고르시오.");
            }
        }
    }
}
