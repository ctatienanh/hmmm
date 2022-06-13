package Login;

import Account.Accountsss.AccountUser;
import Account.IO.ReaderandwiterUser;
import Account.ValidateAccountt.ValidateaccountUser;

import java.util.ArrayList;
import java.util.Scanner;



public class Loginn {
    static ArrayList<AccountUser> accountUsers = ReaderandwiterUser.reander();
    public static AccountUser accountUser= null;

    static Scanner scanner = new Scanner(System.in);
    static String User = "user";
    static String role = "staff";


    {
        if (accountUsers.size()==0){
            accountUsers.add(new AccountUser("admin","admin","admin"));
        }
    }
    public static void Menu(){
        System.out.println("");
        System.out.println("    ======Login=========");
        System.out.println("     1 :Đăng nhập     ");
        System.out.println("     2 :Đăng kí       ");
        System.out.println("     3 :Quên mật khẩu  ");
        System.out.println("    ---------------------");
        System.out.print("     Nhập Lựa chọn :");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                System.out.println("");
                System.out.println("================ Đăng nhập ================");
                login();
                break;
            case 2:
                System.out.println("");
                System.out.println("================ Đăng kí ================");
                addAccount(User);
                Menu();
                break;
            case 3:
                System.out.println("");
                System.out.println("================ Quên mật khẩu ================");
                forgotpassword();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn");
                Menu();
        }
    }
    public static void Menuadmin(){
        System.out.println("     =====Menu Admin=====");
        System.out.println("1:Hiển thị tài khoản khách hàng");
        System.out.println("2:Hiển thị tài khoản nhân viên");
        System.out.println("3:Tạo tài khoản nhân viên");
        System.out.println("4:Sửa tài khoản nhân viên ");
        System.out.println("5:Xóa tài khoản nhân viên ");
        System.out.println("6:Đăng xuất");
        System.out.println("---------------------------");
        System.out.print("Nhâp lựa chọn :");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                System.out.println("       --------------------------------------------------");
                System.out.println("         Thông tin các account khách hàng hiện tại :");
                ShowUserkhachhang(User);
                break;
            case 2:
                System.out.println("       --------------------------------------------------");
                System.out.println("         Thông tin các account nhân viên hiện tại :");
                ShowUserkhachhang(role);
                break;
            case 3:
                Loginn.addAccount(role);
                Menuadmin();
                break;
            case 4:
                EditAccountUser(role);
                break;
            case 5:
                DeleteaccountUser();
                break;
            case 6:
                Loginn.Menu();
                break;
            default:
                System.out.println("không tìm thấy lựa chọn của bạn");
        }
    }
    public static boolean login(){
        accountUsers = ReaderandwiterUser.reander();
        Loginn.accountUser=null;
        System.out.print("Tài Khoản :");
        String account = scanner.nextLine();
        System.out.print("Mật Khẩu  :");
        String password = scanner.nextLine();

        for (AccountUser accountUser1 : accountUsers) {
            if (accountUser1.getAccount().equals(account) && accountUser1.getPass().equals(password)){
                Loginn.accountUser = accountUser1;
                System.out.println("           --------------------------");
                System.out.println("               Đăng nhập thành công ");
                System.out.println("               Xin chào " +accountUser1.getAccount());
                System.out.println("           --------------------------");
                return true;
            }
        }
        System.out.println("              -----------------------------------");
        System.out.println("                  Không tìm thấy tài khoản");
        System.out.println("              ------------------------------------");
        Loginn.accountUser=null;
       return false;
    }





    public static AccountUser UserCread(String role){

        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("      Tạo tài khoản");

        System.out.println("Nhập họ và tên");
        System.out.println("** Họ và tên viết hoa chữ cái đầu **");
        System.out.print("+ Họ và tên     : ");
        String name = ValidateaccountUser.name();

        System.out.println("Nhập giới tính");
        System.out.println("+ Giới tính   : ");
        String sex = ValidateaccountUser.sex();

        System.out.println("Nhập tuổi");
        System.out.print("+ Tuổi          :");
        String age = ValidateaccountUser.age();

        System.out.println("Nhập tài khoản");
        System.out.println("** Tài khoản từ 6 tới 10 kí tự và không chứa kí tự đặc biệt **");
        System.out.print("+ Tài Khoản     : ");
        String accout = ValidateaccountUser.account();

        System.out.println("Nhập mật khẩu");
        System.out.println("** Mật không có kí tự đặc biệt **");
        System.out.print("+ Mật Khẩu      : ");
        String passwrod = ValidateaccountUser.password();


        String email = ValidateaccountUser.email();

        System.out.println("Nhập số điện thoại");
        System.out.println("** số điện thoại gồm 10 so **");
        System.out.println("+ Điện Thoại  : ");
        String telephone = ValidateaccountUser.telephone();

        System.out.println("Nhập địa chỉ");
        System.out.print("+ Địa chỉ     :");
        String address = ValidateaccountUser.address();

        return new AccountUser(name,sex,age,accout,passwrod,email,telephone,address,role);
    }




    public static void addAccount(String role){
        accountUsers.add( UserCread(role));
        ReaderandwiterUser.writer(accountUsers);
        System.out.println("        -------------------------------");
        System.out.println("           Tạo tài khoản thành công");
        System.out.println("        -------------------------------");
        System.out.println("");
    }

    public static void forgotpassword() {
        System.out.println("---------------------------------");
        System.out.print(   "Nhập email :" );
        String email = scanner.nextLine();
        boolean checkk = true;
        for (int i = 1; i < ReaderandwiterUser.reander().size(); i++) {
            if (ReaderandwiterUser.reander().get(i).getEmail().equals(email)) {
                System.out.println("");
                System.out.println("   Tài khoản bạn cần tìm là : ");
                System.out.println("----------------------------------");
                System.out.println("Account  : "+ ReaderandwiterUser.reander().get(i).getAccount());
                System.out.println("Password : "+ ReaderandwiterUser.reander().get(i).getPass());
                System.out.println("----------------------------------");
                checkk=false;
            }
        }
        if (checkk==true) {
            System.out.println("-----------------------------------------");
            System.out.println("     Không tìm thấy tài khoản bạn cần tìm ");
        }
        Menu();
    }

    public static int checkidaccountUser(String name){
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getAccount().equals(name)){
                int index = i;
                return index;
            }
        }
        return -1;
    }


    public static void EditAccountUser(String role){
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account nhân viên cần sửa :");
        String name = scanner.nextLine();
        if (checkidaccountUser(name) != -1) {
            accountUsers.set(checkidaccountUser(name),Loginn.UserCread(role));
            ReaderandwiterUser.writer(accountUsers);
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menuadmin();
    }

    public static void DeleteaccountUser(){
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account nhân viên cần xóa :");
        String name = scanner.nextLine();
        if (checkidaccountUser(name) != -1) {
            System.out.println("Bạn có chắc chắn muốn xóa tài khoản :" + name);
            System.out.println("1:có");
            System.out.println("2:không");
            switch (Integer.parseInt(ValidateaccountUser.Choice())){
                case 1:
                    accountUsers.remove(checkidaccountUser(name));
                    ReaderandwiterUser.writer(accountUsers);
                    System.out.println("-----------------------------------------");
                    System.out.println("-          Đã xóa account               -");
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    Menuadmin();
                    break;
            }

        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menuadmin();
    }

    public static void ShowUserkhachhang(String role){

        System.out.println("");
        for (int i=0; i<ReaderandwiterUser.reander().size(); i++) {
            if (ReaderandwiterUser.reander().get(i).getRole().equals(role)) {
                System.out.println("Tên            : " + ReaderandwiterUser.reander().get(i).getName());
                System.out.println("Giới tính      : " + ReaderandwiterUser.reander().get(i).getSex());
                System.out.println("Tuổi           : " + ReaderandwiterUser.reander().get(i).getAge());
                System.out.println("Email          : " + ReaderandwiterUser.reander().get(i).getEmail());
                System.out.println("Số Điện Thoại  : " + ReaderandwiterUser.reander().get(i).getTelephone());
                System.out.println("Địa chỉ        : " + ReaderandwiterUser.reander().get(i).getAddress());
                System.out.println("Tai khoan      : " + ReaderandwiterUser.reander().get(i).getAccount());
                System.out.println("Mật Khẩu       : " + ReaderandwiterUser.reander().get(i).getPass());
                System.out.println("-------------");
                System.out.println("");
            }
        }
        System.out.println(" ");
        Menuadmin();
    }

}
