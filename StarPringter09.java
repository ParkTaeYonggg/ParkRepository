package day0702;

import java.util.Scanner;

public class StarPringter09 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        System.out.println("10번 별찍기.");
        System.out.println("출력할 줄 수를 입력하시오.");
        System.out.print("> ");

        int userNumber = sc.nextInt();
        int iStart = 1;
        int iEnd = userNumber;

        for (int i = iStart; i <= iEnd - 1; i++) {

            String star = "";
            int jEnd = iEnd;
            if (i == 1) {
                jEnd -= 1;
            }
            for (int j = i; j <= jEnd; j++) {
                star += "*";
            }
            for (int j = 3; j <= i * 2 - 1; j++) {
                star += " ";
            }
            for (int j = i; j <= userNumber; j++) {
                star += "*";
            }
            System.out.println(star);
            if (i == userNumber - 1) {

                for (int j = 1; j <= userNumber; j++) {
                    String stars = "";
                    int kStart = j;
                    if (j == userNumber) {
                        kStart -= 1;
                    }
                    for (int k = 1; k <= j; k++) {
                        stars += "*";
                    }
                    for (int k = j * 2 - 1; k <= userNumber * 2 - 3; k++) {
                        stars += " ";
                    }
                    for (int k = 1; k <= kStart; k++) {
                        stars += "*";
                    }
                    System.out.println(stars);
                }
            }
        }
    }
}
