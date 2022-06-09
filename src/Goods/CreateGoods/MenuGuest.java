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
    static ArrayList<AccountUser> accountUsers = readerandwiterUser.reander();
    static Scanner scanner = new Scanner(System.in);
    public static void Menu(){
        System.out.println("");
        System.out.println("                 khách hàng  :"+Loginn.accountUser.getName());
        System.out.println("=====Menu Khách hàng=====");
        System.out.println("1:Hiển thị tất cả các sản phẩm");
        System.out.println("2:Hiển thị sản phẩm theo hãng");
        System.out.println("3:Hiển thị sản phẩm theo giá tăng dần");
        System.out.println("4:Thêm sản phẩm vào giỏ hàng");
        System.out.println("5:Xem giỏ hàng");
        System.out.println("6:Đăng xuất");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                System.out.println("================ các sản phẩm hiện tại ================");
                showgoods();
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
                System.out.println("================ hẹn gặp lại ================");
                Loginn.Menu();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn mời bạn nhập lại");
        }
    }
    public static void showgoods() {
        for (int i = 0; i < classGoods.size(); i++) {
            System.out.println("San pham  " + (i + 1) + ":");
            System.out.println("Hãng Laptop      : " + classGoods.get(i).getBrand());
            System.out.println("Tên Laptop       : " + classGoods.get(i).getName());
            System.out.println("Giá tiền         : " + classGoods.get(i).getPrice());
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
        System.out.println("================ các sản hãng "+brand+" ================");
        for (int i = 0; i < classGoods.size(); i++) {
            if (classGoods.get(i).getBrand().equals(brand)){
                System.out.println("San pham  " + (i + 1) + ":");
                System.out.println("Hãng Laptop      : " + classGoods.get(i).getBrand());
                System.out.println("Tên Laptop       : " + classGoods.get(i).getName());
                System.out.println("Giá tiền         : " + classGoods.get(i).getPrice());
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
        String name = scanner.nextLine();
        for (int i = 0; i < classGoods.size(); i++) {
            if (classGoods.get(i).getName().equals(name)){
                String account = Loginn.accountUser.getAccount();
                String name1 = classGoods.get(i).getName();
                int price = classGoods.get(i).getPrice();
                System.out.println("Nhập số lượng muốn mua ");
                int amounts = Integer.parseInt( ValidateGoods.amount());
                System.out.println("Nhập thời gian trả hàng ");
                String time = scanner.nextLine();
                int prices = (classGoods.get(i).getPrice() * amounts);
                int amount1 = classGoods.get(i).getAmount() - amounts;
                classGoods.get(i).setAmount(amount1);
                readerandwiter.witer(classGoods);
                classShops.add(new ClassShop(name1,price,amounts,time,account,prices));
                readerandWiterShops.witer(classShops);
            }
        }
        System.out.println("===== Mua hàng thành công ====");
        System.out.println("");
        Menu();
    }

    public static void ShowShop() {
        while (true) {
            System.out.println("===========================================================");
            System.out.println("        Giỏ hàng của  :" + Loginn.accountUser.getName());
            System.out.println("");
            int sum = 0;
            boolean check = true;
            for (int i = 0; i < classShops.size(); i++) {
                if (classShops.get(i).getAccount().equals(Loginn.accountUser.getAccount())) {
                    System.out.println("STT " + (i + 1) + " : ");
                    System.out.println("Tên sản phẩm             : " + classShops.get(i).getName());
                    System.out.println("Giá sản                  : " + classShops.get(i).getPrice());
                    System.out.println("Số lượng sản phẩm        : " + classShops.get(i).getAmounts());
                    System.out.println("Thời gian nhận sản phẩm  : " + classShops.get(i).getTime());
                    System.out.println("Thành tiền               : " + classShops.get(i).getPrices());
                    System.out.println("----------------------------------------------------------");
                    System.out.println("");
                    System.out.println("");
                    sum += classShops.get(i).getPrices();
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
                System.out.println("Tổng số tiền của giỏ hàng là :" + sum);
                System.out.println("1: Xóa sản phẩm");
                System.out.println("2: Xác nhận thanh toán ");
                System.out.println("3: Quay lại menu ");
                System.out.println("Nhập lựa chọn ");
                switch (Integer.parseInt(ValidateaccountUser.Choice())) {
                    case 1:
                        System.out.println("Nhập STT sản phẩm muốn xóa ");
                        int index = Integer.parseInt(indexdelete());
                        classShops.remove((index - 1));
                        readerandWiterShops.witer(classShops);
                        System.out.println(" Đã xóa thành công ");
                        ShowShop();
                        break;
                    case 2:
                        System.out.println("1:Có");
                        System.out.println("2:Không");
                        System.out.println("Nhập lựa chọn ");
                        switch (Integer.parseInt(ValidateaccountUser.Choice())) {
                            case 1:
                                System.out.println("Thanh toán thành công vui long chuẩn bị sẵn số tiền : " + sum + " VND");
                                ArrayList<Integer> integers = new ArrayList<>();
                                for (int i = 0; i < classShops.size(); i++) {
                                    if (classShops.get(i).getAccount().equals(Loginn.accountUser.getAccount())) {
                                        integers.add(i);
                                    }
                                }
                                System.out.println(integers);
//                                for (int i=0; i<integers.size(); i++){
//                                    System.out.println();
//                                }
                                for (Integer x: integers) {
                                    classShops.remove(x);
                                    readerandWiterShops.witer(classShops);
                                }

                                System.out.println(integers.size());
                                Menu();
                                break;
                            case 2:
                                ShowShop();
                                break;
                            default:
                                System.out.println("Không tìm thấy lựa chọn");
                                ShowShop();
                        }
                        break;
                    case 3:
                        Menu();
                        break;
                    default:
                        System.out.println("Không tìm thấy lựa chọn");
                }
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
