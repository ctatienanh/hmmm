package Goods.CreateGoods;

import Account.CreatAccounts.CreatAccount;
import Account.ValidateAccountt.ValidateaccountUser;
import Goods.Classgoods.ClassGoods;
import Goods.Classgoods.ClassShop;
import Goods.ReaderAndWiterGoods.ReaderandWiterShops;
import Goods.ReaderAndWiterGoods.Readerandwiter;
import Goods.ValidateGoods.ValidateGoods;
import Login.Loginn;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuGuest {
    static Readerandwiter readerandwiter = new Readerandwiter();
    static ArrayList<ClassGoods> classGoods = readerandwiter.reader();
    static ReaderandWiterShops readerandWiterShops = new ReaderandWiterShops();
    static CreatAccount creatAccount= new CreatAccount();
    static ArrayList<ClassShop> classShops = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void Menu(){
        System.out.println("=====Menu Khách hàng=====");
        System.out.println("1:Hiển thị tất cả các sản phẩm");
        System.out.println("2:Hiển thị sản phẩm theo hãng");
        System.out.println("3:Hiển thị sản phẩm theo giá tăng dần");
        System.out.println("4:Thêm sản phẩm vào giỏ hàng");
        System.out.println("5:Xem giỏ hàng");
        System.out.println("6:Đăng xuất");
        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                showgoods();
                break;
            case 2:
                showBrand();
                break;
            case 3:
                SortPrice();
                break;
            case 4:
                Shop();
                break;
            case 5:
                ShowShop();
                break;
            case 6:
                Loginn.Menu();
                break;
            case 7:
                creatAccount.accountt();
            default:
                System.out.println("Không tìm thấy lựa chọn");
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
        String name = scanner.next();
        for (int i = 0; i < classGoods.size(); i++) {
            if (classGoods.get(i).getName().equals(name)){
                String name1 = classGoods.get(i).getName();
                int price = classGoods.get(i).getPrice();
                System.out.println("Nhập số lượng muốn mua ");
                int amounts = Integer.parseInt( ValidateGoods.amount());
                System.out.println("Nhập thời gian trả hàng ");
                String time = scanner.nextLine();
                classShops.add(new ClassShop(name1,price,amounts,time));

            }
        }
    }

    public static void ShowShop(){
        for (int i = 0; i < classShops.size(); i++) {

            System.out.println(i+1 + " : ");
            System.out.println("Tên sản phẩm             : "  +classShops.get(i).getName());
            System.out.println("Giá sản                  : " +classShops.get(i).getPrice());
            System.out.println("Số lượng sản phẩm        : " +classShops.get(i).getAmounts());
            System.out.println("Thời gian nhận sản phẩm  : " +classShops.get(i).getTime());
            System.out.println("----------------------------------------------------------");
        }
    }

}
