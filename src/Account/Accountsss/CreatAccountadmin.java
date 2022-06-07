package Account.Accountsss;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatAccountadmin  {


    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public CreatAccountadmin() {
    }

    public CreatAccountadmin(String account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return account+ "," +password ;
    }
//
//    public void witer (ArrayList<CreatAccount> creatAccounts){
//        File file = new File("C:\\Users\\hp\\OneDrive\\Máy tính\\taikhoanadmin.txt");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(creatAccounts);
//            objectOutputStream.close();
//            fileOutputStream.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public ArrayList<CreatAccount> reader(){
//        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hp\\OneDrive\\Máy tính\\taikhoanadmin.txt");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            return (ArrayList<CreatAccount>) objectInputStream.readObject();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            System.out.println("");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    return new ArrayList<>();
//    }
    public ArrayList<CreatAccountadmin> reader(){
        ArrayList<CreatAccountadmin> newsinhvien = new ArrayList<>();
        File file = new File("C:\\Users\\hp\\OneDrive\\Máy tính\\taikhoanadmin.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String list = "";
            while ((list = bufferedReader.readLine())!=null){
                String arr [] = list.split(",");
                String account = arr[0];
                String password = arr[1];
                newsinhvien.add(new CreatAccountadmin(account,password));
                bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newsinhvien;
    }


}
