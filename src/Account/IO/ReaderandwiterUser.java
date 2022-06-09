package Account.IO;

import Account.Accountsss.AccountUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderandwiterUser {
    public static void writer(List<AccountUser> accountUsers) {

        File file = new File("C:\\Users\\hp\\OneDrive\\Máy tính\\taikhoankh.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountUsers);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<AccountUser> reander() {

        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\hp\\OneDrive\\Máy tính\\taikhoankh.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return  (ArrayList<AccountUser>) objectInputStream.readObject();
        } catch (IOException e) {
            System.out.print("");
        } catch (ClassNotFoundException e) {
            System.out.print("");
        }
        return new ArrayList<>();
    }

}
