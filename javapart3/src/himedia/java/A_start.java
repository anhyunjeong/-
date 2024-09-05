package himedia.java;

public class A_start {
    public static void main(String[] args) {
        A_accountImpl a = new A_accountImpl();
        a.getNowDateTime();
        a.printCreateAccountMenu();
        while(true) {
            int menuNum=a.printMenu();
            switch(menuNum) {
                case 1:
                    a.addMoney();
                    break;
                case 2:
                    a.subMoney();
                    break;
                case 3:
                    a.printHistory();
                    break;
                case 4:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;

            }
        }
    }
}


