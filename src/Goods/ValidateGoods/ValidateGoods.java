package Goods.ValidateGoods;

import Account.ValidateAccountt.ValidateaccountUser;
import Goods.Classgoods.ClassGoods;
import Goods.ReaderAndWiterGoods.Readerandwiter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateGoods {
    static Readerandwiter readerandwiter = new Readerandwiter();
    static ArrayList<ClassGoods> classGoods = readerandwiter.reader();
    static Scanner scanner = new Scanner(System.in);
    private static final String regexprice = "[0-9]+";



    public static String name(){
        while (true){
            String name = scanner.nextLine();
            for (int i=0; i <readerandwiter.reader().size(); i++){
                if (readerandwiter.reader().get(i).getName().equals(name)){
                    System.out.println("Đã tồn tại tên sản phẩm này ");
                    name();
                }
            }
            return name;
        }
    }




    public static String brand() {
        while (true) {
            System.out.println("1:HP");
            System.out.println("2:Dell");
            System.out.println("3:LG");
            System.out.println("4:Asus");
            System.out.println("5:Lennovo");
            System.out.println("Nhập lựa chọn");
            switch (Integer.parseInt(ValidateaccountUser.Choice())) {
                case 1:
                    return "HP";
                case 2:
                    return "Dell";
                case 3:
                    return "Lg";
                case 4:
                    return "Asus";
                case 5:
                    return "Lennovo";
                default:
                    System.out.println("Không tìm thấy lựa chọn");
            }
        }
    }
    public static String price(){
        while (true) {
            String price = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexprice);
            Matcher matcher = pattern.matcher(price);
            if (matcher.matches()) {
                return price;
            }
            System.out.println("Nhập sai kiểu dữ liệu");
        }
    }

    public static String ram(){
        while (true){
            System.out.println("1:4gb");
            System.out.println("2:8gb");
            System.out.println("3:16gb");
            System.out.println("4:32gb");
            System.out.println("Nhập lựa chọn");
            switch (Integer.parseInt(ValidateaccountUser.Choice())){
                case 1:
                  return "4gb";
                case 2:
                    return "8gb";
                case 3:
                    return "16gb";
                case 4:
                    return "32gb";
                default:
                    System.out.println("Không tìm thấy lựa chọn nhập lại");
            }
        }
    }

    public static String battery(){
        while (true){
            System.out.println("1: 9000 mAh");
            System.out.println("2: 10000 mAh");
            System.out.println("3: 15000 mAh");
            System.out.println("4: 20000 mAh");
            switch (Integer.parseInt(ValidateaccountUser.Choice())){
                case 1:
                    return "9000 mAh";
                case 2:
                    return "10000 mAh";
                case 3:
                    return "15000 mAh";
                case 4:
                    return "20000 mAh";
                default:
                    System.out.println("Không tìm thấy lựa chọn nhập lại");
            }
        }
    }

    public static String amount (){
        while (true){
            System.out.println("Nhập Số lượng sản phẩm ");
            String amount = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexprice);
            Matcher matcher = pattern.matcher(amount);
            if (matcher.matches()){
                return amount;
            }
            System.out.println("Chỉ nhập số lượng sản phẩm là kiểu dữ liệu số nguyên");
        }
    }


}
