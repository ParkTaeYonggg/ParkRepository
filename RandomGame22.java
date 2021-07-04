package day0701;
// 숙1

// 랜덤숫자 맞추기 게임
// 사용자가 1. 플레이 2. 최고기록 보기 3. 종료
// 중 하나를 입력하면, 각각의 기능이 실행된다.

// 1. 플레이
//    사용자가 플레이를 실행시키면, 컴퓨터는 1~100 까지의 랜덤한 숫자를 생성한다.
//    그리고 사용자는 그 숫자가 얼마인지 입력해서 맞춰야 한다.
//    단, 사용자가 맞출때까지 입력은 계속 된다.
//    만약, 사용자가 입력한 숫자가 컴퓨터의 숫자보다 크면 "down" 이라고 출력.
//    만약, 사용자가 입력한 숫자가 컴퓨터의 숫자보다 작으면 "up" 이라고 출력.
//      또한, 사용자가 틀릴 때마다 현재 점수가 1점씩 올라가는데
//      최종적으로 최고기록과 비교해서 현재 점수가 더 작으면 
//      현재 점수가 새로운 최고기록이 된다.

//     그리고 사용자가 정답을 맞추면 : 현재점수, 최고기록 출력.
//    만약 사용자가 최고기록을 갱신했으면 축하메시지를 출력.

// 2. 최고기록 보기.
//  현재 최고기록을 보여준다.
// 단, 만약 사용자가 한번도 플레이 한적이 없으면 "아직 플레이 기록이 없습니다!" 출력.

// 3. 종료
// "프로그램을 종료시킵니다." 출력.

import java.util.Scanner;
import java.util.Random;

public class RandomGame22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("업앤다운 게임");
        int num;
        int num2;
        int score = 0;
        int nScore = 0;
        int random;
        boolean boo = false;
        while (true) {
            System.out.println("1. 플레이  2. 최고기록보기 3. 종료");
            num = sc.nextInt();

            if (num == 1) {
                random = r.nextInt(100) + 1;
                while (true) {

                    System.out.println("1~100 사이의 수를 입력하시오.");
                    System.out.print("> ");
                    num = sc.nextInt();

                    if (num < random) {
                        System.out.println("up!");
                        score++;
                    } else if (num > random) {
                        System.out.println("down!");
                        score++;
                    } else if (num == random) {
                        System.out.println("정답입니다.");
                        score++;
                        break;
                    }
                }
                boo = true;

                while (boo) {
                    System.out.println("1. 플레이 2. 최고기록 3 종료");
                    System.out.print("> ");
                    num2 = sc.nextInt();
                    if (num2 == 1) {
                        random = r.nextInt(100) + 1;
                        while (true) {
                            System.out.println("1~100 사이의 수를 입력하시오.");
                            System.out.print("> ");
                            num2 = sc.nextInt();
                            if (num2 < random) {
                                System.out.println("up!");
                                nScore++;
                            } else if (num2 > random) {
                                System.out.println("down!");
                                nScore++;
                            } else if (num2 == random) {
                                System.out.println("정답입니다.");
                                nScore++;
                                break;
                            }
                            boo = false;
                        }
                    } else if (num2 == 2) {
                        if ((nScore == 0) && (score == 0)) {
                            System.out.println("기록이 없습니다.");
                        } else {
                            if ((nScore < score) && !(score == 0 || nScore == 0)) {
                                System.out.println("축하드립니다. 최고기록입니다.");
                                System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", score, nScore);
                                if (!(score == 0 || nScore == 0) && (nScore < score)) {
                                    score = 0;
                                }
                            } else if ((score < nScore) && !(score == 0 || nScore == 0)) {
                                System.out.println("축하드립니다. 최고기록입니다.");
                                System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", nScore, score);
                                if (!(score == 0 || nScore == 0) && (score < nScore)) {
                                    nScore = 0;
                                }
                            } else if ((0 < nScore && nScore != 0) == (0 < score && score != 0)) {
                                System.out.println("기록이 같습니다.");
                                System.out.printf("기존기록 : [%d]점\n", nScore);

                            } else {
                                System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", score, nScore);
                                if (!(score == 0 || nScore == 0) && (nScore < score)) {
                                    score = 0;
                                }
                            }
                        }
                    } else if (num2 == 3) {
                        System.out.println("게임을 종료합니다.");
                        break;
                    } else if (num2 <= 0 || num2 > 3) {
                        System.out.println("잘못입력하셨습다. 아래 보기를 선택해주세요.");
                    }
                }

            } else if (num == 2) {
                if ((nScore == 0) && (score == 0)) {
                    System.out.println("기록이 없습니다.");
                } else {
                    if ((nScore < score) && !(score == 0 || nScore == 0)) {
                        System.out.println("축하드립니다. 최고기록입니다.");
                        System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", score, nScore);
                        if (!(score == 0 || nScore == 0) && (nScore < score)) {
                            score = 0;
                        }
                    } else if ((score < nScore) && !(score == 0 || nScore == 0)) {
                        System.out.println("축하드립니다. 최고기록입니다.");
                        System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", nScore, score);
                        if (!(score == 0 || nScore == 0) && (score < nScore)) {
                            nScore = 0;
                        }
                    } else if ((0 < nScore && nScore != 0) == (0 < score && score != 0)) {
                        System.out.println("기록이 같습니다.");
                        System.out.printf("기존기록 : [%d]점\n", nScore);

                    } else {
                        System.out.printf("현재기록 : [%d]점 최고기록 : [%d]점\n", nScore, score);
                        if (!(score == 0 || nScore == 0) && (score < nScore)) {
                            nScore = 0;
                        }
                    }
                }
            } else if (num == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (num <= 0 || num > 3) {
                System.out.println("잘못입력하셨습다. 아래 보기를 선택해주세요.");
            }

        }
    }

}
