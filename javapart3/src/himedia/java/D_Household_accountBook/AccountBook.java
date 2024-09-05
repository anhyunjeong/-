package himedia.java.D_Household_accountBook;
// 계좌 기준 말고 날짜 기준!

public interface AccountBook {
    int printHouseHoldMenu();
    void createTransaction();
    void totalMoney();
    void oneDay_totalTransaction();
    void saveTransaction();
    void manageTransaction(String message);
    void manageTotalAmounts(String message);
    void deleteTransaction();
    void deleteAllTransactions();
    void printDateList();

}
