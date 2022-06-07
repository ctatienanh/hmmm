package Account.ReaderandWiterUser;

import Account.Accountsss.Accountpersonnel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderandwriterAccount {

    public void writer(List<Accountpersonnel> accountpersonnels){
        File file = new File("taikhoannv.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(accountpersonnels);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Accountpersonnel> reader(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("taikhoannv.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Accountpersonnel>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.print("");
        } catch (IOException e) {
            System.out.print("");
        } catch (ClassNotFoundException e) {
            System.out.print("");;
        }
        return new ArrayList<>();
    }


}
