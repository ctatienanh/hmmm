package Goods.CreateGoods;

import Account.ValidateAccountt.ValidateaccountUser;
import Goods.Classgoods.ClassGoods;
import Goods.ReaderAndWiterGoods.Readerandwiter;
import Goods.ValidateGoods.ValidateGoods;
import Login.Loginn;

import java.util.ArrayList;
import java.util.Scanner;

public class GoodsCreate {

    static Readerandwiter readerandwiter = new Readerandwiter();
    static ArrayList<ClassGoods> classGoods = readerandwiter.reader();
    static Scanner scanner = new Scanner(System.in);


    public static void Menu(){
        System.out.println("");
        System.out.println("                         Nhân viên : "+Loginn.accountUser.getName() );
        System.out.println("     ====Menu nhân viên====");
        System.out.println("1:Thêm sản phẩm ");
        System.out.println("2:Hiện thị tất cả cá sản phẩm");
        System.out.println("3:Sửa sản phẩm ");
        System.out.println("4:Xóa sản phẩm ");
        System.out.println("5:Thêm số lượng sản phẩm");
        System.out.println("6:Đăng xuất");
        System.out.println("Nhập lựa chọn");

        switch (Integer.parseInt(ValidateaccountUser.Choice())){
            case 1:
                System.out.println("================ Add sản phẩm ================");
                addGoods();
                break;
            case 2:
                System.out.println("================ Các Mặt Hàng ================");
                showgoods();
                break;
            case 3:
                System.out.println("================ Edit sản phẩm ================");
                Edit();
                break;
            case 4:
                System.out.println("================ Xóa sản phẩm ================");
                Delete();
                break;
            case 5:
                System.out.println("================ Add số lượng sản phẩm ================");
                EditAmount();
                break;
            case 6:
                System.out.println("================ hẹn gặp lại ================");
                Loginn.Menu();
                break;
            default:
                System.out.println("Không tìm thấy lựa chọn mời bạn nhập lại");
        }
    }



    public static ClassGoods creat(){
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("  Thêm thông tin các mặt hàng ");

        System.out.println("Nhập hãng");
        String brand = ValidateGoods.brand();

        System.out.println("Nhập tên sản phẩm");
        String name = ValidateGoods.name();

        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(ValidateGoods.price()) ;

        System.out.println("Nhập ram");
        String ram = ValidateGoods.ram();

        System.out.println("Nhập battery ");
        String battery = ValidateGoods.battery();


        int amount = Integer.parseInt(ValidateGoods.amount1());

        return new ClassGoods(brand,name,price,ram,battery,amount);
    }

    public static void addGoods(){
        System.out.println("");
        classGoods.add(creat());
        readerandwiter.witer(classGoods);
        Menu();
    }
    public static void showgoods() {
        System.out.println("");
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

    public static int checkid(){
        System.out.println("Nhập tên sản phẩm ");
        String name = scanner.nextLine();
        for (int i=0; i< classGoods.size(); i++){
            if (classGoods.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    public static void Edit(){
        System.out.println("");
     classGoods.set(checkid(),creat());
     readerandwiter.witer(classGoods);
     Menu();
    }
    public static void Delete(){
        System.out.println("");
        classGoods.remove(checkid());
        readerandwiter.witer(classGoods);
        Menu();
    }
    public static void EditAmount(){
        System.out.println("");
        classGoods.get(checkid()).setAmount(Integer.parseInt(ValidateGoods.amount1()));
        readerandwiter.witer(classGoods);
        System.out.println("");
        System.out.println("Thêm sản phẩm thành công");
        System.out.println("------------------------");
        Menu();
    }

}
