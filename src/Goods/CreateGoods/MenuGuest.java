package Goods.CreateGoods;

import Account.Accountsss.AccountUser;
import Account.IO.ReaderandwiterUser;
import Account.ValidateAccountt.ValidateaccountUser;
import Goods.Classgoods.ClassGoods;
import Goods.Classgoods.ClassShop;
import Goods.ReaderAndWiterGoods.ReaderandWiterShops;
import Goods.ReaderAndWiterGoods.Readerandwiter;
import Goods.ValidateGoods.ValidateGoods;
import Login.Loginn;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuGuest {
    static Readerandwiter readerandwiter = new Readerandwiter();
    static ArrayList<ClassGoods> classGoods = readerandwiter.reader();
    static ReaderandWiterShops readerandWiterShops = new ReaderandWiterShops();
    static ArrayList<ClassShop> classShops = readerandWiterShops.reader();
    static ReaderandwiterUser readerandwiterUser = new ReaderandwiterUser();
    static ArrayList<AccountUser> accountUsers = ReaderandwiterUser.reander();
    static Scanner scanner = new Scanner(System.in);
    public static void Menu(){
        System.out.println("");
        System.out.println("=====Menu Khách hàng=====   khách hàng :"+Loginn.accountUser.getName());
        System.out.println("1:Hiển thị tất cả các sản phẩm");
        System.out.println("2:Hiển thị sản phẩm theo hãng");
        System.out.println("3:Hiển thị sản phẩm theo giá tăng dần");
        System.out.println("4:Thêm sản phẩm vào giỏ hàng");
        System.out.println("5:Xem giỏ hàng");
        System.out.println("6:Thay đổi Mật khẩu");
        System.out.println("7:Đăng xuất");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                System.out.println("================ các sản phẩm hiện tại ================");
                GoodsCreate.showgoods();
                Menu();
                break;
            case 2:
                showBrand();
                break;
            case 3:
                System.out.println("================ các sản phẩm theo giá tăng ================");
                SortPrice();
                break;
            case 4:
                System.out.println("================ add giỏ hàng ================");
                Shop();
                break;
            case 5:
                System.out.println("================ giỏ hàng ================");
                ShowShop();
                break;
            case 6:
                EditPassword();
                break;
            case 7:
                System.out.println("");
                System.out.println("================ hẹn gặp lại ================");
                Loginn.Menu();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn mời bạn nhập lại");
                Menu();
        }
    }
    public static void EditPassword(){
        String pass = null;
        System.out.println("Nhập password hiện tại ");
        String passwrod = ValidateaccountUser.password();
        if (passwrod.equals((Loginn.accountUser.getPass()))) {
            while (true) {
                System.out.println("Nhập password mới");
                String passwrod1 = ValidateaccountUser.password();
                System.out.println("Nhập lại password mới");
                String passwrod2 = ValidateaccountUser.password();
                if (passwrod1.equals(passwrod2)){
                    pass = passwrod2;
                    break;
                }
            }
            for (int i=0; i<accountUsers.size();i++){
                if (accountUsers.get(i).getAccount().equals((Loginn.accountUser.getAccount()))){
                    accountUsers.get(i).setPass(pass);
                }
            }
            ReaderandwiterUser.writer(accountUsers);
            System.out.println("Đổi tài khoản thành công");
            }else System.out.println("Password sai cút");
        Menu();
    }
    public static void showgoods() {
        for (int i = 0; i < readerandwiter.reader().size(); i++) {
            System.out.println("San pham  " + (i + 1) + ":");
            System.out.println("Hãng Laptop      : " + classGoods.get(i).getBrand());
            System.out.println("Tên Laptop       : " + classGoods.get(i).getName());
            System.out.println("Giá tiền         : " + classGoods.get(i).getPrice()+" VNĐ");
            System.out.println("Ram Laptop       : " + classGoods.get(i).getRam());
            System.out.println("Dung lượng pin   : " + classGoods.get(i).getPrice());
            System.out.println("Số lượng tồn kho : " + classGoods.get(i).getAmount());
            System.out.println("-----------------------------------------------");
            System.out.println("");
        }
        Menu();
    }

    public static void showBrand(){
        System.out.println("1:HP");
        System.out.println("2:Dell");
        System.out.println("3:LG");
        System.out.println("4:Asus");
        System.out.println("5:Lennovo");
        System.out.println("Nhập lựa chọn");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                 Brand("HP");
                break;
            case 2:
                Brand("Dell");
                break;
            case 3:
                Brand("Lg");
                break;
            case 4:
                Brand("Asus");
                break;
            case 5:
                Brand("Lennovo");
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn");
        }
    }
    public static void Brand(String brand){
        classGoods = readerandwiter.reader();
        System.out.println("================ các sản phẩm hãng "+brand+" ================");
        for (int i = 0; i < classGoods.size(); i++) {
            if (classGoods.get(i).getBrand().equals(brand)){
                System.out.println("San pham  " + (i + 1) + ":");
                System.out.println("Hãng Laptop      : " + classGoods.get(i).getBrand());
                System.out.println("Tên Laptop       : " + classGoods.get(i).getName());
                System.out.println("Giá tiền         : " + classGoods.get(i).getPrice()+" VNĐ");
                System.out.println("Ram Laptop       : " + classGoods.get(i).getRam());
                System.out.println("Dung lượng pin   : " + classGoods.get(i).getPrice());
                System.out.println("Số lượng tồn kho : " + classGoods.get(i).getAmount());
                System.out.println("-----------------------------------------------");
                System.out.println("");
            }
        }
        Menu();
    }

    public static void SortPrice(){
        classGoods.sort(new SortPrice());
        showgoods();
    }

    public static void Shop(){
        System.out.println("Nhập tên sản phẩm bạn muốn mua");
        String name = ValidateGoods.NameShop();
        for (int i = 0; i < classGoods.size(); i++) {
            if (classGoods.get(i).getName().equals(name)){
                String account = Loginn.accountUser.getAccount();
                String name1 = classGoods.get(i).getName();
                int price = classGoods.get(i).getPrice();
                int amounts = Integer.parseInt( ValidateGoods.amount1());
                if ( readerandwiter.reader().get(i).getAmount() < amounts){
                    System.out.println("");
                    System.out.println("===== Không đủ số lượng hàng xin lỗi quý khách ====");
                    System.out.println("");
                    break;
                }


                int prices = (classGoods.get(i).getPrice() * amounts);
                classShops.add(new ClassShop(name1,price,amounts,account,prices));
                readerandWiterShops.witer(classShops);
                System.out.println("===== Thêm vào giỏ hàng thành công ====");
            }
        }

        System.out.println("");
        Menu();
    }

    public static void ShowShop() {
            classGoods = readerandwiter.reader();
            System.out.println("===========================================================");
            System.out.println("        Giỏ hàng của  :" + Loginn.accountUser.getName());
            System.out.println("");
            int sum = 0;
            boolean check = true;
            for (int i = 0; i <readerandWiterShops.reader().size(); i++) {
                if (readerandWiterShops.reader().get(i).getAccount().equals(Loginn.accountUser.getAccount())) {
                    System.out.println("Tên sản phẩm             : " + readerandWiterShops.reader().get(i).getName());
                    System.out.println("Giá sản                  : " + readerandWiterShops.reader().get(i).getPrice()+" VNĐ");
                    System.out.println("Số lượng sản phẩm        : " + readerandWiterShops.reader().get(i).getAmounts());
                    System.out.println("Thành tiền               : " + readerandWiterShops.reader().get(i).getPrices() +" VNĐ");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("");
                    System.out.println("");
                    sum +=readerandWiterShops.reader().get(i).getPrices();
                    check = false;
                }
            }
            if (check) {
                System.out.println("---------------------------");
                System.out.println("-* Không có sản phẩm nào *-");
                System.out.println("---------------------------");
                System.out.println("");
                Menu();
            } else {
                System.out.println("Tổng số tiền của giỏ hàng là :" + sum +" VNĐ");
                System.out.println("==========================");
                System.out.println("1: Xóa sản phẩm");
                System.out.println("2: Xác nhận thanh toán ");
                System.out.println("3: Quay lại menu ");
                System.out.print("Nhập lựa chọn :");
                switch (Integer.parseInt(ValidateaccountUser.Choice())) {
                    case 1:
                        System.out.println("Nhập tên sản phẩm muốn xóa ");
                        String name = ValidateGoods.NameShop();
                        int index=-1;
                        for (int i=0;i<classShops.size();i++){
                            if (classShops.get(i).getName().equals(name)){
                                index = i;
                            }
                        }
                        classShops.remove(index);
                        readerandWiterShops.witer(classShops);
                        System.out.println(" Đã xóa thành công ");
                        ShowShop();
                        break;
                    case 2:
                        System.out.println("================ Xác nhận thanh toán ================");
                        System.out.println("1:Có");
                        System.out.println("2:Không");
                        System.out.print("Nhập lựa chọn :");
                        switch (Integer.parseInt(ValidateaccountUser.Choice())) {
                            case 1:
                                ArrayList<ClassShop>classShops1=new ArrayList<>();
                                ArrayList<ClassShop>classShops2=new ArrayList<>();
                                ArrayList<ClassShop>classShops3=new ArrayList<>();
//                                classShops3=classShops;
                                ArrayList<ClassShop>classShops4=new ArrayList<>();
                                boolean checkk = true;
                                for (int i = 0; i < classShops.size(); i++) {
                                    if (!classShops.get(i).getAccount().equals(Loginn.accountUser.getAccount())) {
                                        classShops1.add(classShops.get(i));
                                    }else {
                                        classShops2.add(classShops.get(i));
                                    }
                                }
                                for (int i=0; i<classShops.size();i++){
                                   for (int j=0; j<classGoods.size();j++) {
                                       if (classShops.get(i).getAccount().equals(Loginn.accountUser.getAccount())){
                                          if ( (classShops.get(i).getName()).equals((classGoods.get(j).getName()))  ) {
                                              if((classGoods.get(j).getAmount() < classShops.get(i).getAmounts())) {
                                                  System.out.println("");
                                                  System.out.println("================================");
                                                  System.out.println("=*  chậm tay rồi :))) *= ");
                                                  System.out.println("=*  Sản phẩm " + classShops.get(i).getName() + " đã bị người khác mua mất xin cảm ơn");
                                                  System.out.println("--------------------------------------------------------");
                                                  System.out.println("");
                                                  checkk=false;
                                              }else {
                                                  classShops3.add(classShops.get(i));
                                              }
                                          }
                                      }
                                    }
                                }
                                for (int i=0; i< classShops3.size();i++){
                                    classShops4.add(classShops3.get(i));
                                }
                                for (int i=0; i<classShops1.size();i++){
                                    classShops4.add(classShops1.get(i));
                                }

                                if (checkk == false){
                                    classShops = classShops4;
                                    readerandWiterShops.witer(classShops);
                                    ShowShop();
                                    break;
                                }

                                System.out.println("");
                                System.out.println("======================================================================");
                                System.out.println("Thanh toán thành công vui long chuẩn bị sẵn số tiền : " + sum + "VND");
                                System.out.println("-----------------------------------------------------------------------");



                                for (int i=0; i<classShops2.size();i++){
                                    for (int j=0; j<classGoods.size();j++){
                                        if (classGoods.get(j).getName().equals((classShops2.get(i).getName()))){
                                            int amount1 = ((classGoods.get(j).getAmount()) - (classShops2.get(i).getAmounts()));
                                            classGoods.get(j).setAmount(amount1);
                                            readerandwiter.witer(classGoods);
                                        }
                                    }
                                }
                                classShops = classShops1;
                                readerandWiterShops.witer(classShops);
                                Menu();
                                break;
                            case 2:
                                ShowShop();
                                break;
                            default:
                                System.out.println("Không tìm thấy lựa chọn");
                                ShowShop();
                                break;
                        }
                        break;
                    case 3:
                        Menu();
                        break;
                    default:
                        System.out.println("Không tìm thấy lựa chọn");
                        break;
                }
            }
    }
    public static String indexdelete(){
        while (true) {
            String index = scanner.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(index);
            if (matcher.matches()) {
                if (Integer.parseInt(index) <= classShops.size()) {
                    return index;
                }
            }
            System.out.println("Không tìm thấy STT nhập lại :");
        }
    }

}
