package Goods.ReaderAndWiterGoods;

import Goods.Classgoods.ClassGoods;
import Goods.Classgoods.ClassShop;

import java.io.*;
import java.util.ArrayList;

public class ReaderandWiterShops {

    File file = new File("C:\\Users\\hp\\OneDrive\\Máy tính\\Shop.txt");

    public void witer(ArrayList<ClassShop> goods){

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (ClassShop x : goods){
                bufferedWriter.write(x.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.print("");
        }
    }

    public ArrayList<ClassShop> reader(){
        ArrayList<ClassShop> newclassShops = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String list = bufferedReader.readLine();
            while (list != null){
                String arr [] = list.split(",");
                String name = arr[0];
                int price = Integer.parseInt(arr[1]);
                int amouts = Integer.parseInt(arr[2]);
                int prices = Integer.parseInt(arr[4]);
                newclassShops.add( new ClassShop(name,price,amouts,arr[3],prices));
                list =  bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (IOException e) {
            System.out.print("");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return newclassShops;
    }
}
