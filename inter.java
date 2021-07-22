package com.inter;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


class Unit implements commend {
 public void building(String building) {
       System.out.println(building);
       System.out.println("생산할 유닛을 선택해 주세요.");
       System.out.println("1. 용병  2. 방화범  3. 저격수  4. 종료  5. 인구정보  6. 일하러가기");
    }
    public String marine(String marine, int population) {
        System.out.println(marine);
        System.out.println("현재 용병의 수 : " + population);
        return marine+population;
    }
    public String firebat(String firebat, int population) {
        System.out.println(firebat);
        System.out.println("현재 방화범의 수 : " + population);
        return firebat+population;
        
    }
    public String sniper(String sniper, int population) {
        System.out.println(sniper);
        System.out.println("현재 저격수의 수 : " + population);
        return sniper+population;
    }
    public void info(int n) {
        if(n == 1) {
            System.out.println("공격력 : 16");
            System.out.println("방어력 : 30");
            System.out.println("돌격소총을 들고 싸우는 용병");
            System.out.println("생산시 코인 3개 소모");
            
        } else if (n == 2) {
            System.out.println("공격력 : 30");
            System.out.println("방어력 : 25");
            System.out.println("화염방사기로 광역 공격을 하는 방화범");
            System.out.println("생산시 코인 5개 소모");
        } else if (n == 3) {
            System.out.println("공격력 : 60");
            System.out.println("방어력 : 5");
            System.out.println("저격총을 들고 멀리서 사격지원을 해주는 저격수");
            System.out.println("생산시 코인 6개 소모");
        }
    }
    
}


public class inter {
    static int up = 0;
    static Random r = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
        
        String[] unit = new String[12];        
        Unit u = new Unit();
        String coin = " , , , , , , , , , , , ";
        StringTokenizer stk = new StringTokenizer(coin, ",");
        int idx = 0;
        int pop1 = 1;
        int pop2 = 1;
        int pop3 = 1;
        
        while (true) {
            u.building("배럭");
            System.out.println("현재 코인 수 : " + stk.countTokens());
            
            if (stk.countTokens() == 0) {
                System.out.println("코인이 다 떨어졌습니다. 병력을 더 뽑고 싶다면 일을 하세요.");
                work();
                if (up == 19) {
                    stk = new StringTokenizer(coin, ",");
                    up = 0;
                }
            }
            
            
            
            
            
            
            int userChoice = sc.nextInt();
            if (userChoice == 1) {
                if (idx == unit.length || stk.countTokens() < 3) {
                 System.out.println("더이상 뽑기 불가능함.");   
                } else {
                   unit[idx++] = u.marine("용병", pop1++);
                   String[] m = new String[3];
                   for(int i = 0; i < 3; i++) {
                       m[i] = stk.nextToken();
                   }
                }
            } else if (userChoice == 2) {
                if (idx == unit.length || stk.countTokens() < 5) {
                    System.out.println("더이상 뽑기 불가능함.");   
                   } else {
                      unit[idx++] = u.firebat("방화범", pop2++);
                      String[] m = new String[5];
                      for(int i = 0; i < 5; i++) {
                          m[i] = stk.nextToken();
                      }
                   }
            } else if (userChoice == 4) {
                break;
            } else if (userChoice == 3) {
                if (idx == unit.length || stk.countTokens() < 6) {
                    System.out.println("더이상 뽑기 불가능함.");   
                   } else {
                      unit[idx++] = u.sniper("저격수", pop3++);
                      String[] m = new String[6];
                      for(int i = 0; i < 6; i++) {
                          m[i] = stk.nextToken();
                      }
                      
                   }
            } else if (userChoice == 5) {
                System.out.println("1. 현재 및 잔여 인구수  2. 유닛신상정보");
                userChoice = sc.nextInt(); 
                if(userChoice == 1) {
                System.out.println("현재인구 수 : " + idx);
                System.out.println("잔여인구 수 : " + (unit.length - (pop1-1) - (pop2-1) - (pop3-1)));
                } else if (userChoice == 2) {
                    System.out.println("확인하실 유닛을 선택해 주세요.");
                    System.out.println("1. 용병  2. 방화범  3. 저격수");
                    userChoice = sc.nextInt();
                    if (userChoice > 3 || userChoice < 1) {
                        while (userChoice > 3 || userChoice < 1) {
                            System.out.println("잘못입력하셨습니다.");
                            System.out.println("1. 용병  2. 방화범  3. 저격수 4. 취소");
                            userChoice = sc.nextInt();
                            if (userChoice == 4) {
                                break;
                            }
                        }
                    } else {
                    u.info(userChoice);
                    }
                }
            } else if (userChoice == 6) {
                work();
            }
        
        }
        
        
        
        
    }
    
   
    private static void work() {
       
        System.out.println("1. 일하기  2. 쉬기");
        int userChoice = sc.nextInt();
        
        if (userChoice == 1) {
            System.out.println("==== 일하기 ====");
            System.out.println("화면에 나오는 숫자를 선택해주세요.");
            System.out.println("20번 선택시 코인이 충전됩니다. 계속진행 아무키 뒤로가기 x 입력하세요.");
            System.out.println("현재 노동력 : " + up + "  노동완료 : " + (20-up));
            sc.nextLine();
            String choice = sc.nextLine();
            while (!choice.equalsIgnoreCase("x")) {
               int com = r.nextInt(100)+1;
               System.out.println(com + "   (그만하기는 x)");
                userChoice = sc.nextInt();
                if (userChoice == com) {
                    up++;
                    System.out.println("현재 노동력 : " + up);
                    if(up == 20) {
                        System.out.println("코인이 충전되었습니다.");
                        break;
                    }
                } else {
                    System.out.println("땡");
                }
            }
        } else {
            
        }
    }

    
    
   
    
    

    
}
