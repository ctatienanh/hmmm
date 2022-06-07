package Goods.ReaderAndWiterGoods;


import Goods.Classgoods.ClassGoods;

import java.io.*;
import java.util.ArrayList;

public class Readerandwiter {

    File file = new File("C:\\Users\\hp\\OneDrive\\Máy tính\\Sản phẩm.txt");

    public void witer(ArrayList<ClassGoods> goods){
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

    public ArrayList<ClassGoods> reader(){
        ArrayList<ClassGoods> newclassGoods = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String list = bufferedReader.readLine();
            while (list != null){
                String arr [] = list.split(",");
                String brand = arr[0];
                String name = arr[1];
                int price = Integer.parseInt(arr[2]);
                String ram = arr[3];
                String batter = arr[4];
                int amount = Integer.parseInt(arr[5]);
                newclassGoods.add( new ClassGoods(brand,name,price,ram,batter,amount ));
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
