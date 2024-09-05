package himedia.java.D_Household_accountBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AccountBookImpl implements AccountBook {

    private int amount;
    private int sum;
    private String itemName;
    private Path myFolder;
//    private String today;
    private String day;
    private Path dayFile;

    private List<String> transactions;
    private List<Integer> totalamounts;
    private String saveTransactions=null;

    public AccountBookImpl() {
        transactions = new ArrayList<>();
        totalamounts = new ArrayList<>();
    }

    @Override
    public int printHouseHoldMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("============ 메뉴 ============");
        System.out.println("[1]가계부 내역추가 [2]내역조회 [3]전체삭제 [4]내역삭제 [5]프로그램종료");
        System.out.println("원하시는 메뉴를 선택하세요.");

        return sc.nextInt();
    }

    @Override
    public void createTransaction() {
        System.out.println("날짜를 입력하세요");// 현재는 today를 쓸 수 없으므로
        Scanner sc=new Scanner(System.in);
        day=sc.nextLine();
        System.out.println("물품이름");
        Scanner sc1 = new Scanner(System.in);
        itemName = sc1.nextLine();
        System.out.println("<금액입력>");
        Scanner sc2=new Scanner(System.in);
        amount=sc2.nextInt();

        //System.out.println("거래내역 생성 [이름]"+itemName+"[금액]"+amount);

        String transactionMessage="[물품명]"+itemName+"[금액]"+amount+"원";
        String amountMessage= String.valueOf(amount);
        manageTransaction(transactionMessage);
        manageTotalAmounts(amountMessage);

    }

    @Override
    public void totalMoney() {
        List<Integer> nums = totalamounts;
        int sum = nums.stream().mapToInt(Integer::valueOf).sum();
    }

    // 리스트의 금액을 더하는 방법
    // List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
    //
    //        int sum = nums.stream().mapToInt(Integer::valueOf).sum();
    //        System.out.println(sum);        // 15


    @Override
    public void oneDay_totalTransaction() {// 일일 거래내역 파일 생성
        dayFile = myFolder.resolve(day + ".txt");

        if ( Files.notExists(dayFile) ) {
            try ( FileOutputStream fos = new FileOutputStream(dayFile.toFile()) ) {
                fos.write(saveTransactions.getBytes());
                System.out.println(day + ".txt 파일을 생성하고 내용을 썼습니다.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(day + ".txt 파일이 이미 존재합니다.");
        }
    }



    @Override
    public void saveTransaction() {
        System.out.println("======== 내역조회 ========");
        transactions.sort(Comparator.reverseOrder());
        for (String chart : transactions) {
            System.out.println(chart);
        }
        // 맨마지막에 합계 출력되게 만들기
        System.out.println("총 합계 금액은"+sum+"입니다.");
    }

    @Override
    public void manageTransaction(String message) {
            transactions.add(message);
    }

    @Override
    public void manageTotalAmounts(String message) {
        totalamounts.add(Integer.parseInt(message));
    }


    @Override
    public void deleteTransaction() {// item으로 해야하나
        //itemName
        Scanner sc=new Scanner(System.in);
        System.out.println("[삭제] 물품을 입력하세요.");
        String item=sc.nextLine();
        if (transactions.contains(item)) {
            transactions.remove(item);
        }else{
            System.out.println("찾으시는 내역이 없습니다.");
        }

    }

    @Override
    public void printDateList() {
        System.out.println("조회하실 날짜를 입력하세요. 예)yyyy-MM-dd");
        dayFile = myFolder.resolve(day + ".txt");

        if ( Files.exists(dayFile) ) {
            try (FileInputStream fis = new FileInputStream(dayFile.toFile())) {
                int byteData;
                System.out.println("읽어오기 : " + day + ".txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(day + ".txt 파일이 존재하지 않습니다.");
        }
    }

    @Override
    public void deleteAllTransactions() {
        transactions.clear();
        totalamounts.clear();
        System.out.println("삭제되었습니다.");
    }
}
