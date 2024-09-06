package himedia.java.N_Household_accountBook;

import java.util.*;


public class AccountBookImpl implements AccountBook {

    public static int totalMoney;
    private Map<Scanner, List<String[]>> memory;

    public AccountBookImpl() {
        this.memory = memory;
        this.line = line;
    }

    private List<String> line;

    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ 메뉴 ============");
        System.out.println("[1]가계부 내역추가 [2]내역조회 [3]전체삭제 [4]내역삭제 [5]프로그램종료");
        System.out.println("원하시는 메뉴를 선택하세요.");

        return sc.nextInt();
    }

    @Override
    public void addMemory() {
        System.out.println("날짜");
        Scanner sc=new Scanner(System.in);
        String day=sc.nextLine();
        System.out.println("물품");
        Scanner sc1=new Scanner(System.in);
        String item=sc1.nextLine();
        System.out.println("금액");
        Scanner sc2=new Scanner(System.in);
        int money=sc2.nextInt();

        System.out.println("[날짜] "+day+" [내역] "+item+" [금액] "+money);


    }



    @Override
    public void showMemory() {
        System.out.println("날짜");
        Scanner sc=new Scanner(System.in);
        String day=sc.nextLine();

        boolean flag=false;

        for(String[] s:memory.get(day)){
            if(s[0].equals(day)){
                System.out.println("[날짜] "+day+" [내역] "+s[0]+" [금액] "+s[1]);
            }
        }

        if(!flag){
            System.out.println("없음");
        }
    }

    @Override
    public void removeMemory() {

    }

    @Override
    public void removeAll() {

    }
}
