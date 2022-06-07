package Menu;

import Account.ValidateAccountt.ValidateaccountUser;
import Login.Loginn;

import java.util.Scanner;

public class Menu {
    Loginn loginn = new Loginn();
    Scanner scanner = new Scanner(System.in);
    public  void menu(){
        System.out.println("        ====Menu====   ");
        System.out.println("1:Đăng Nhập");
        System.out.println("Nhập lựa chọn ");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                loginn.Menu();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn");
        }

    }
}
