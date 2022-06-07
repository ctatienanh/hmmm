package Account.ValidateAccountt;

import Account.ReaderandWiterUser.ReaderandwiterUser;
import Account.ReaderandWiterUser.ReaderandwriterAccount;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateaccountUser {
    public static final String regexname = "[A-Z][A-Za-z]+";
    public static final String regexAccount = "[A-Za-z0-9]{6,10}";
    public static final String regexpassword = "[A-Za-z0-9]+";
    public static final String regexemail = "[A-Za-z0-9]+@[a-z]+.[a-z]+";
    public static final String regexTelephone = "^84[0-9]{10}";
    public static final  String regexaddress = "[A-Za-z0-9]+";
    public static final String regexage = "[0-9][0-9]";
    public static final String regexid = "[0-9]{12}";
    public static final String regexchoice = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);
    static ReaderandwiterUser readerandwiterUser = new ReaderandwiterUser();
    static ReaderandwriterAccount readerandwriterAccount = new ReaderandwriterAccount();

    public static String name() {
        while (true) {
            String name = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexname);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return name;
            }
            System.out.println("Nhập sai định dạng nhâp lại :");
        }
    }

    public static String sex() {
        System.out.println("-------------");
        System.out.println("1: Nam");
        System.out.println("2: Nữ ");
        System.out.println("-------------");
        System.out.println("Nhập lựa chọn của bạn: ");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                return "nam";
            case 2:
                return "nữ";
            default:
                return "bd";
        }
    }


    public static String account() {
        while (true) {
            String Account = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexAccount);
            Matcher matcher = pattern.matcher(Account);
            if (matcher.matches()) {
                for (int i = 0; i < readerandwiterUser.reander().size(); i++) {
                    if (readerandwiterUser.reander().get(i).getAccount().equals(Account)) {
                        System.out.println("đã có tài khoản đăng nhập này :");
                        account();
                    }
                }
                return Account;
            }
            System.err.println("Nhập sai kiểu dữ liệu nhập lại ");
        }
    }


    public static String accountpersonnel() {
        while (true) {
            String Account = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexAccount);
            Matcher matcher = pattern.matcher(Account);
            if (matcher.matches()) {
                for (int i = 0; i < readerandwriterAccount.reader().size(); i++) {
                    if (readerandwriterAccount.reader().get(i).getAccount().equals(Account)) {
                        System.out.println("đã có tài khoản đăng nhập này :");
                        accountpersonnel();
                    }
                }
                return Account;
            }
            System.err.println("Nhập sai kiểu dữ liệu nhập lại ");
        }
    }

    public static String password() {
        while (true) {
            String Pass = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexpassword);
            Matcher matcher = pattern.matcher(Pass);
            if (matcher.matches()) {
                return Pass;
            }
            System.err.println("Nhập sai kiểu dữ liệu nhập lại");
        }
    }

    public static String telephone() {
        while (true) {

            String telephone = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexTelephone);
            Matcher matcher = pattern.matcher(telephone);
            if (matcher.matches()) {
                return telephone;
            }
            System.out.println("Nhập lại");
        }
    }

    public static String email() {
        while (true){
            String email = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexemail);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                for(int i=0;i<readerandwiterUser.reander().size() ;i++){
                    if (readerandwiterUser.reander().get(i).getEmail().equals(email)){
                        System.out.println("email này đã tồn tại");
                        email();
                    }
                }
                return email;
            }
            System.out.println("Nhập sai kiểu dữ liệu nhập lại");
        }
    }
    public static String emailpersonnel() {
        while (true){
            String email = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexemail);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                for(int i=0;i<readerandwriterAccount.reader().size() ;i++){
                    if (readerandwriterAccount.reader().get(i).getEmail().equals(email)){
                        System.out.println("email này đã tồn tại");
                        emailpersonnel();
                    }
                }
                return email;
            }
            System.out.println("Nhập sai kiểu dữ liệu nhập lại");
        }
    }

    public static String address(){
        while (true){
            String address = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexaddress);
            Matcher matcher = pattern.matcher(address);
            if (matcher.matches()){
                return address;
            }
            System.out.println("Địa chỉ không được thêm kí tự đặc biệt");
        }
    }
    public static String age(){
        while (true) {
            String age = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexage);
            Matcher matcher = pattern.matcher(age);
            if (matcher.matches()) {
                return age;
            }
            System.out.println("Nhập sai kiểu dữ liệu");
        }
    }

    public static String id(){
    while (true){
        String id = scanner.nextLine();
        Pattern pattern = Pattern.compile(regexid);
        Matcher matcher = pattern.matcher(id);
        if (matcher.matches()){
       for (int i =0; i< readerandwriterAccount.reader().size();i++){
        if (readerandwriterAccount.reader().get(i).getId().equals(id)){
            System.out.println("Số chứng minh thư này đã tồn tại ");
            id();
        }
       }
            return id;
        }
        System.out.println("Nhập sai kiểu dữ liệu nhập lại");
      }
    }

    public static String position(){
        while (true) {
            System.out.println("-------------");
            System.out.println("1: Nhân viên bán hàng");
            System.out.println("2: Nhân viên thu ngân ");
            System.out.println("-------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            switch (Integer.parseInt(Choice())) {
                case 1:
                    return "Nhân viên bán hàng";
                case 2:
                    return "Nhân viên thu ngân";
                default:
                    System.out.println("không tim thấy lựa chọn nhập lại");
            }
        }
    }

    public static String Choice() {
        while (true) {
            String choice = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexchoice);
            Matcher matcher = pattern.matcher(choice);
            if (matcher.matches()) {
                return choice;
            } else System.out.println("Chỉ nhập kí tự là số ");
        }
    }

}
