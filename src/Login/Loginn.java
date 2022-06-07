package Login;

import Account.Accountsss.Accountpersonnel;
import Account.Accountsss.CreatAccountadmin;
import Account.CreatAccounts.Admin;
import Account.CreatAccounts.CreatAccount;
import Account.ReaderandWiterUser.ReaderandwriterAccount;
import Account.ValidateAccountt.ValidateaccountUser;
import Goods.CreateGoods.GoodsCreate;
import Menu.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Loginn {
    public Loginn() {
    }

    static CreatAccount creatAccount = new CreatAccount();
    static CreatAccountadmin creatAccountadmin = new CreatAccountadmin();
    static ReaderandwriterAccount readerandwriterAccount = new ReaderandwriterAccount();
    static ArrayList<CreatAccountadmin> creatAccountadmins = creatAccountadmin.reader();
    static ArrayList<Accountpersonnel> accountpersonnels = readerandwriterAccount.reader();

    static Admin admin = new Admin();
    static Menu menu = new Menu();


    static Scanner scanner = new Scanner(System.in);
    public static void Menu(){
        System.out.println("   =====Login=====");
        System.out.println("1 :Đăng nhập tài khoản Admin ");
        System.out.println("2 :Đăng nhập tài khoản nhân viên");
        System.out.println("3 :Đăng nhập tài khoản khách hàng");
        System.out.println("4 :Quay lại");
        System.out.println("Nhập Lựa chọn");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                loginAccountAdmin();
                break;
            case 2:
                loginAccount();
                break;
            case 3:
                creatAccount.Menu();
                break;
            case 4:
                menu.menu();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn");
        }

    }

    public static void loginAccountAdmin() {
        System.out.println("        --------------------");
        System.out.println("             Đăng nhập");
        System.out.print("Tài Khoản : ");
        String account = scanner.nextLine();
        System.out.print("Mật Khẩu  : ");
        String password = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < creatAccountadmins.size(); i++) {
            if (creatAccountadmins.get(i).getAccount().equals(account) && creatAccountadmins.get(i).getPassword().equals(password)) {
                check=false;
            }
        }
        if (check){
            System.out.println("              -----------------------------------");
            System.out.println("                  Không tìm thấy tài khoản");
            System.out.println("              ------------------------------------");
            Menu();
        }else {
            System.out.println("              ---------------------");
            System.out.println("               Đăng nhập thành công ");
            System.out.println("              ----------------------");
            admin.Menu();

        }
    }

    public static void   loginAccount(){
        System.out.println("        --------------------");
        System.out.println("             Đăng nhập");
        System.out.print("Tài Khoản : ");
        String account = scanner.nextLine();
        System.out.print("Mật Khẩu  : ");
        String password = scanner.nextLine();
        boolean check = true;
        int index =-1;
        for (int i =0; i<accountpersonnels.size(); i++){
            if (accountpersonnels.get(i).getAccount().equals(account) && accountpersonnels.get(i).getPass().equals(password)){
                check = false;
                index = i;
            }
        }

        if (check){
            System.out.println("              -----------------------------------");
            System.out.println("                  Không tìm thấy tài khoản");
            System.out.println("              ------------------------------------");
            Menu();
        }else {
            System.out.println("              ---------------------");
            System.out.println("               Đăng nhập thành công ");
            System.out.println("                  HeLLo " +accountpersonnels.get(index).getName());
            System.out.println("              ----------------------");
            GoodsCreate.Menu();

        }
    }


}
