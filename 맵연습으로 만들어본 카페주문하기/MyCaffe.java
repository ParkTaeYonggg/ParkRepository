package com.Scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 카페만들기
 <음료의 종류>
 1. 아메리카노 (3,000)
 2. 카페라떼    (3,500)
 3. 카페모카    (4,000)
 4. 과일주스    (5,000)
 
 <입력값>
 메뉴번호, 주문수량, 입금액(고객이 낸 돈)
 
 맵 키 : 메뉴번호, 벨류 : 마이카페타입(스트링 메뉴이름, 인트 금액)
 주문수량 : 유저인트(변수로 +)
 입금액 : (입금액 - 벨류인트금액)
  
 <출력값>
 입금액, 판매액(단가*수량),잔액(입금액 - 판매액)
 유저인트 : 입금액
 유저인트 : 수량
 잔액 : 입금액 - 판매액
 
 
 
 <메뉴>
 
 
 
 */
class Menu{
    int cost = 0;
    String name = "";
    
    public Menu(String name, int cost) {
        this.cost = cost;
        this.name = name;
    }
    public void print(int i) {
       
        System.out.printf("%d)%s : [%d]\n",i,name,cost);
    }
}



public class MyCaffe {
    Scanner sc;
    
    int i = 1;
    Map<Integer,Menu> map;
    Map<Integer,Integer> map2;
    
    
    public MyCaffe() {
        map2 = new TreeMap<>();
        sc = new Scanner(System.in);
        map = new HashMap<>();
        map.put(1, new Menu("아메리카노",3000));
        map.put(2, new Menu("카페라떼",3500));
        map.put(3, new Menu("카페모카",4000));
        map.put(4, new Menu("과일주스",5000));
    }
    
    public void caffeOpen() {
       System.out.println(">>>카페를 오픈합니다.");
    }


   
    public void info() {
        System.out.println("=== ::: 메뉴판 ::: ===");
        for (Menu m : map.values()) {
            
            m.print(i++);
            
        }
        System.out.println("====================");
        i = 1;
    }
    
    
    public void menu() {
        int userChoice = 0;
        int choice = 0;
        
     while (true) {
         System.out.println("주문하시겠습니까? Y/N"); 
         
         String dd = sc.nextLine();
     if (dd.equalsIgnoreCase("Y")) {
         info();
     System.out.println("주문할 메뉴를 선택해주세요.");
     userChoice = sc.nextInt();
     System.out.println("주문수량을 말씀해주세요.");
     choice = sc.nextInt();
     
         if(map2.containsKey(userChoice)) {
             choice += map2.get(userChoice);
             map2.put(userChoice, choice);
         }
             map2.put(userChoice, choice);
             
     
     
         
     
     userChoice = 0;
     choice = 0;
     } else if (dd.equalsIgnoreCase("n")) {
         break;
     }
     }
     for (Integer i : map2.keySet()) {
         if (map2.get(i) != null) {
         userChoice += map2.get(i) * map.get(i).cost;
         }
     }
     System.out.println("돈내기 : 액수를 적어주세요." + userChoice + "이상");
     int price = sc.nextInt();
     
     while (userChoice > price) {
         System.out.println("돈이 부족합니다. 다시 내주세요." + userChoice + "이상");
         price = sc.nextInt();
         }
     
     System.out.println("==== ::: 영수증 출력 ::: ====");
     System.out.println("--주문목록--");
     for (Integer i : map2.keySet()) {
         if (map.get(i) != null)
         System.out.printf("%d) %s[수량:%d개]\n", i, map.get(i).name,map2.get(i));
     }
     System.out.println("받은 금액 : " + price + "원");
     
    System.out.println("총 구매액 : " + userChoice); 
    System.out.println("잔돈 : " + (price - userChoice) + "원");
    
    
     System.out.println("===============================================================");
     
     
     
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
