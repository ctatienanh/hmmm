package Account.CreatAccounts;

import Account.Accountsss.AccountUser;
import Account.Accountsss.Accountpersonnel;
import Account.ReaderandWiterUser.ReaderandwiterUser;
import Account.ReaderandWiterUser.ReaderandwriterAccount;
import Account.ValidateAccountt.ValidateaccountUser;
import Login.Loginn;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    ReaderandwriterAccount readerandwriterAccount = new ReaderandwriterAccount();
    ArrayList<Accountpersonnel> accountpersonnels = readerandwriterAccount.reader();
    ReaderandwiterUser readerandwiterUser = new ReaderandwiterUser();
    ArrayList<AccountUser> accountUsers = readerandwiterUser.reander();
    CreatAccount creatAccount = new CreatAccount();


    public void Menu(){
        System.out.println("     =====Menu Admin=====");
        System.out.println("1:Hiển thị tài khoản khách hàng");
        System.out.println("2:Hiển thị tài khoản nhân viên");
        System.out.println("3:Tạo tài khoản nhân viên");
        System.out.println("4:Sửa tài khoản nhân viên theo tên đăng nhập");
        System.out.println("5:Xóa tài khoản nhân viên theo tên đăng nhập");
        System.out.println("6:Sửa tài khoản khách hành theo tên đăng nhập");
        System.out.println("7:Xóa tài khoản khách hành theo tên đăng nhập");
        System.out.println("8:Đăng xuất");
        System.out.println("Nhâp lựa chọn :");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                ShowUserkhachhang();
                break;
            case 2:
                showaccountpersonel();
                break;
            case 3:
                addaccount();
                break;
            case 4:
                EditAccountpersonnel();
                break;
            case 5:
                DeleteaccountPersonnel();
                break;
            case 6:
                EditAccountUser();
                break;
            case 7:
                DeleteaccountUser();
                break;
            case 8:
                Loginn.Menu();
                break;
            default:
                System.out.println("không tìm thấy lựa chọn của bạn");
        }

    }
    public int checkid(String name){
        for (int i = 0; i < accountpersonnels.size(); i++) {
            if (accountpersonnels.get(i).getAccount().equals(name)){
                int index = i;
                return index;
            }
        }
        return -1;
    }

    public int checkidaccountUser(String name){
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getAccount().equals(name)){
                int index = i;
                return index;
            }
        }
        return -1;
    }


    public void EditAccountUser(){
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account khách hàng cần sửa :");
        String name = scanner.nextLine();
        if (checkid(name) != -1) {
            accountUsers.set(checkidaccountUser(name),creatAccount.UserCread() );
            readerandwiterUser.writer(accountUsers);
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menu();
    }

    public void DeleteaccountUser(){
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account khách hàng cần xóa :");
        String name = scanner.nextLine();
        if (checkidaccountUser(name) != -1) {
            System.out.println("Bạn có chắc chắn muốn xóa tài khoản :" + name);
            System.out.println("1:có");
            System.out.println("2:không");
            switch (Integer.parseInt(ValidateaccountUser.Choice())){
                case 1:
                    accountUsers.remove(checkidaccountUser(name));
                    readerandwiterUser.writer(accountUsers);
                    System.out.println("-----------------------------------------");
                    System.out.println("-          Đã xóa account               -");
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    Menu();
                    break;
            }

        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menu();
    }



    public void EditAccountpersonnel() {
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account nhân viên cần sửa :");
        String name = scanner.nextLine();
        if (checkid(name) != -1) {
            accountpersonnels.set(checkid(name), creadpersonnel());
            readerandwriterAccount.writer(accountpersonnels);
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menu();
    }

    public void DeleteaccountPersonnel(){
        System.out.println("-----------------------------------------");
        System.out.println("    Nhập account Nhân viên cần xóa :");
        String name = scanner.nextLine();
        if (checkid(name) != -1) {
            System.out.println("Bạn có chắc chắn muốn xóa tài khoản :" + name);
            System.out.println("1:có");
            System.out.println("2:không");
            switch (Integer.parseInt(ValidateaccountUser.Choice())){
                case 1:
                    accountpersonnels.remove(checkid(name));
                    readerandwriterAccount.writer(accountpersonnels);
                    System.out.println("-----------------------------------------");
                    System.out.println("-          Đã xóa account               -");
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    Menu();
                    break;
            }

        } else {
            System.out.println("-----------------------------------------");
            System.out.println("-          Không tim thấy account       -");
            System.out.println("-----------------------------------------");
        }
        Menu();
    }
    public void ShowUserkhachhang(){
        System.out.println("        -----------------------------------");
        System.out.println("         Thông tin các account hiện tại :");
        System.out.println("");
        for (int i=0; i<ReaderandwiterUser.reander().size(); i++){
            System.out.println("Khach hang thứ  " +(i+1)+ ":" );
            System.out.println("Tên            : " +ReaderandwiterUser.reander().get(i).getName());
            System.out.println("Giới tính      : " +ReaderandwiterUser.reander().get(i).getSex());
            System.out.println("Tuổi           : " +ReaderandwiterUser.reander().get(i).getAge());
            System.out.println("Email          : " +ReaderandwiterUser.reander().get(i).getEmail());
            System.out.println("Số Điện Thoại  : " +ReaderandwiterUser.reander().get(i).getTelephone());
            System.out.println("Địa chỉ        : " +ReaderandwiterUser.reander().get(i).getAddress());
            System.out.println("Tai khoan      : " +ReaderandwiterUser.reander().get(i).getAccount());
            System.out.println("Mật Khẩu       : " +ReaderandwiterUser.reander().get(i).getPass());
            System.out.println("-------------");
            System.out.println("");
        }
        System.out.println(" ");
        Menu();
    }




    public Accountpersonnel creadpersonnel(){
        System.out.println(" ");
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
        System.out.print("+ Tuổi          : ");
        String age = ValidateaccountUser.age();

        System.out.println("Nhập tài khoản");
        System.out.println("** Tài khoản từ 6 tới 10 kí tự và không chứa kí tự đặc biệt **");
        System.out.print("+ Tài Khoản     : ");
        String accout = ValidateaccountUser.accountpersonnel();

        System.out.println("Nhập mật khẩu");
        System.out.println("** Mật không có kí tự đặc biệt **");
        System.out.print("+ Mật Khẩu      : ");
        String passwrod = ValidateaccountUser.password();

        System.out.println("Nhập Email");
        System.out.print("+ Email         : ");
        String email = ValidateaccountUser.emailpersonnel();

        System.out.println("Nhập số điện thoại");
        System.out.println("** số điện thoại gồm đầu 84 và 10 số ở đuôi **");
        System.out.print("+ Điện Thoại    : ");
        String telephone = ValidateaccountUser.telephone();

        System.out.println("Nhập địa chỉ");
        System.out.print("+ Địa chỉ     : ");
        String address = ValidateaccountUser.address();

        System.out.println("Nhập số chứng minh thư nhân dân ");
        System.out.println("** số chứng minh thư nhân dân gồm 12 số **");
        System.out.print("+ số chứng minh thư   : ");
        String id = ValidateaccountUser.id();

        System.out.println("Nhập trình độ học vấn ");
        System.out.print("+ Trình độ học vấn    : ");
        String academiclevel = scanner.nextLine();

        System.out.println("Nhập chức vụ ");
        String position = ValidateaccountUser.position();

        return new Accountpersonnel(name,sex,age,accout,passwrod,email,telephone,address,id,academiclevel,position);
    }
    public void addaccount(){
        accountpersonnels.add(creadpersonnel());
        readerandwriterAccount.writer(accountpersonnels);
        System.out.println("        -------------------------------");
        System.out.println("           Tạo tài khoản thành công");
        System.out.println("        -------------------------------");
        System.out.println("");
        Menu();
    }
    public void showaccountpersonel(){
        System.out.println("        -----------------------------------");
        System.out.println("         Thông tin các account hiện tại :");
        System.out.println(" ");
        for (int i =0; i < accountpersonnels.size(); i++ ) {
            System.out.println("Nhân viên  "+(i+1)+":"  );
            System.out.println("Tên               : " +accountpersonnels.get(i).getName());
            System.out.println("Giới tính         : " +accountpersonnels.get(i).getSex());
            System.out.println("Tuổi              : " +accountpersonnels.get(i).getAge());
            System.out.println("Email             : " +accountpersonnels.get(i).getEmail());
            System.out.println("Số Điện Thoại     : " +accountpersonnels.get(i).getTelephone());
            System.out.println("Địa chỉ           : " +accountpersonnels.get(i).getAddress());
            System.out.println("Tai khoan         : " +accountpersonnels.get(i).getAccount());
            System.out.println("Mật Khẩu          : " +accountpersonnels.get(i).getPass());
            System.out.println("Số chứng minh thư : " +accountpersonnels.get(i).getId());
            System.out.println("Trình độ học vấn  : " +accountpersonnels.get(i).getAcademiclevel());
            System.out.println("Chức vụ           : " +accountpersonnels.get(i).getPosition());
            System.out.println("-------------");
            System.out.println("");
        }
        System.out.println("");
        Menu();
    }

}
