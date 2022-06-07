package Account.CreatAccounts;

import Account.Accountsss.AccountUser;
import Account.ReaderandWiterUser.ReaderandwiterUser;
import Account.ValidateAccountt.ValidateaccountUser;
import Goods.CreateGoods.MenuGuest;
import Login.Loginn;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatAccount {
    ReaderandwiterUser readerandwiterUser = new ReaderandwiterUser();
    ArrayList<AccountUser> accountUsers = readerandwiterUser.reander();
    Scanner scanner = new Scanner(System.in);




    public CreatAccount() {


    }

    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("  ====Menu User==== ");
        System.out.println("1:Đăng nhập");
        System.out.println("2:Tạo tài khoản");
        System.out.println("3:Quên mật khẩu");
        System.out.println("4:Quay lại");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                loginAccountUser();
            break;
            case 2:
                addAccount(UserCread());
                break;
            case 3:
                forgotpassword();
                break;
            case 4:
                loginAccountUser();
                break;
            default:
                System.out.println("Không tim thấy lựa chọn mời bạn nhập lại");
                Menu();


        }
    }

    public AccountUser UserCread(){

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

        System.out.print("+ Email         :");
        String email = ValidateaccountUser.email();

        System.out.println("Nhập số điện thoại");
        System.out.println("** số điện thoại gồm đầu 84 và 10 số ở đuôi **");
        System.out.println("+ Điện Thoại  : ");
        String telephone = ValidateaccountUser.telephone();

        System.out.println("Nhập địa chỉ");
        System.out.print("+ Địa chỉ     :");
        String address = ValidateaccountUser.address();

        return new AccountUser(name,sex,age,accout,passwrod,email,telephone,address);
    }

    int index =0;
    public void loginAccountUser() {
        System.out.println("        --------------------");
        System.out.println("             Đăng nhập");
        System.out.print("Tài Khoản : ");
        String account = scanner.nextLine();
        System.out.print("Mật Khẩu  : ");
        String password = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getAccount().equals(account) && accountUsers.get(i).getPass().equals(password)) {
                index = i;
                check=false;
            }
        }
        if (check){
            System.out.println("              -----------------------------------");
            System.out.println("                  Không tìm thấy tài khoản");
            System.out.println("              ------------------------------------");
            Menu();
        }else {
            System.out.println("              -----------------------");
            System.out.println("               Đăng nhập thành công ");
            System.out.println("                  HeLLo " +accountUsers.get(index).getName()  );
            System.out.println("              -----------------------");
          MenuGuest.Menu();

        }

    }
    public void accountt(){
        System.out.println(index);
    }


    public void addAccount(AccountUser accountUser){
    accountUsers.add( accountUser);
    readerandwiterUser.writer(accountUsers);
        System.out.println("        -------------------------------");
        System.out.println("           Tạo tài khoản thành công");
        System.out.println("        -------------------------------");
        System.out.println("");
        Menu();
    }

    public void forgotpassword() {
           System.out.println("---------------------------------");
            System.out.print(   "Nhập email :" );
            String email = scanner.nextLine();
            for (int i = 0; i < accountUsers.size(); i++) {
                if (accountUsers.get(i).getEmail().equals(email)) {
                    System.out.println("----------------------------------");
                    System.out.println("   Tài khoản bạn cần tìm là : ");
                    System.out.println("Account  : "+ accountUsers.get(i).getAccount());
                    System.out.println("Password : "+ accountUsers.get(i).getPass());
                    Menu();
                }
            }
        System.err.println("-----------------------------------------");
        System.err.println("     Không tìm thấy tài khoản bạn cần tìm ");
            Menu();
        }
//        public void show(){
//        for (AccountUser x : accountUsers){
//            System.out.println(x);
//        }
//        }
    }






