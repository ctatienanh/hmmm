package Goods.ReaderAndWiterGoods;

import Goods.Classgoods.ClassGoods;
import Goods.Classgoods.ClassShop;

import java.io.*;
import java.util.ArrayList;

public class ReaderandWiterShops {



    public void witer(ArrayList<ClassShop> goods, String name1){
        File file = new File(("C:\\Users\\hp\\OneDrive\\Máy tính\\")+(name1)+("Sản phẩm.txt"));
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (ClassGoods x : goods){
                bufferedWriter.write(x.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.print("");
        }
    }

    public ArrayList<ClassShop> reader(String name1){
        ArrayList<ClassShop> newclassGoods = new ArrayList<>();
        File file = new File(("C:\\Users\\hp\\OneDrive\\Máy tính\\")+(name1)+("Sản phẩm.txt"));
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String list = bufferedReader.readLine();
            while (list != null){
                String arr [] = list.split(",");
                String name = arr[0];
                int price = Integer.parseInt(arr[1]);
                int amouts = Integer.parseInt(arr[2]);
                String time = arr[3];
                newclassGoods.add( new ClassShop(name,price,amouts,time));
                list =  bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (IOException e) {
            System.out.print("");
        }
        return newclassGoods;
    }
}
