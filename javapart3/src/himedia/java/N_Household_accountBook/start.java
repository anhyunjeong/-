package himedia.java.N_Household_accountBook;

//가계부 1
//기능
//AccountBook.java[i], AccountBookImpl.java, Start.java
//1. 가계부 내역 추가 -> 공책 1000원, 연필 300원 합계 1300원
//2. 내역조회 -> 과거 날짜 제목들 리스트가 나온다. 아래 2024-09-01->위 2024-09-04-> 제목을 입력하면(2024-09-04)의 해당 날짜의 내역들이 나온다.
//3. 전체 삭제 - 제목을 입력한 날짜와 내역을 삭제시킨다.
//4. 내역삭제 - 내역들 중 특정 항목을 삭제시킬 수 있다.
// 5. 프로그램 종료


public class start {
    public static void main(String[] args) {
        AccountBookImpl a = new AccountBookImpl();
        while (true) {
            int num=a.printMenu();
            switch (num){
                case 1:
                    a.addMemory();
                    break;
                case 2:
                    a.showMemory();
                    return;
            }
        }
    }
}
