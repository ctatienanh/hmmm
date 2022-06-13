package Account.ValidateAccountt;

import Account.Accountsss.AccountUser;
import Account.IO.ReaderandwiterUser;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateaccountUser {
    public static final String regexname = "[A-Z][A-Za-z]+";
    public static final String regexAccount = "[A-Za-z0-9]{6,10}";
    public static final String regexpassword = "[A-Za-z0-9]+";
    public static final String regexemail = "[A-Za-z0-9]+@[a-z]+.[a-z]+";
    public static final String regexTelephone = "[0-9]{10}";
    public static final  String regexaddress = "[A-Za-z0-9]+";
    public static final String regexage = "[0-9][0-9]";
    public static final String regexchoice = "[0-9]+";
    static Scanner scanner = new Scanner(System.in);


     static   ArrayList<AccountUser> accountUsers =  ReaderandwiterUser.reander();


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
                for (int i = 0; i < ReaderandwiterUser.reander().size(); i++) {
                    if (ReaderandwiterUser.reander().get(i).getAccount().equals(Account)) {
                        System.out.println("đã có tài khoản đăng nhập này :");
                        account();
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
            System.out.print("+ Email         :");
            String email = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexemail);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()){
                for(int i=1;i<accountUsers.size() ;i++){
                    if (accountUsers.get(i).getEmail().equals(email)){
                        System.out.println("email này đã tồn tại nhập lại");
                        email();
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


    public static String Choice() {
        while (true) {
            String choice = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexchoice);
            Matcher matcher = pattern.matcher(choice);
            if (matcher.matches()) {
                return choice;
            } else System.out.println("Chỉ nhập kí tự là số nhập lại ");
        }
    }

}
