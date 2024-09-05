package himedia.java;

public interface A_account_I {
    void printCreateAccountMenu();
    String createAccount();
    boolean accountExists(int[] accountNums, int imp, int idx);
    void addMoney();
    void printHistory();
    void manageHistory(String message);
    void subMoney();
    int printMenu();
    String getNowDateTime();
}