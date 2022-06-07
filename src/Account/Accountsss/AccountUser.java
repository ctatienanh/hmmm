package Account.Accountsss;

import java.io.Serializable;

public class AccountUser implements Serializable {
    private String name;
    private String sex;
    private String age;
    private String account;
    private String pass;
    private String email;
    private String Telephone;
    private String address;

    public AccountUser() {
    }

    public AccountUser(String name, String sex, String age, String account, String pass, String email, String telephone, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.account = account;
        this.pass = pass;
        this.email = email;
        Telephone = telephone;
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return  " , Tên : "+ name
                +" , Gioi tinh : "+ sex
                +" , Tuổi  : " + age
                +" , Tên tài khoản :" + account
                +" , Mật khẩu :" + pass
                +" , Email : "+ email
                +" , Điện thoại :"+ Telephone
                +" , Địa chỉ : " +address ;
    }
}
