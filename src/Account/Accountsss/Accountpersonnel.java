package Account.Accountsss;

import java.io.Serializable;

public class Accountpersonnel extends AccountUser implements Serializable {
    private String id;
    private String academiclevel;
    private String position;

    public Accountpersonnel() {

    }

    public Accountpersonnel(String name, String sex, String age, String account, String pass, String email, String telephone, String address, String id, String academiclevel, String position) {
        super(name, sex, age, account, pass, email, telephone, address);
        this.id = id;
        this.academiclevel = academiclevel;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademiclevel() {
        return academiclevel;
    }

    public void setAcademiclevel(String academiclevel) {
        this.academiclevel = academiclevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString()+
                " , id :" + id
                + " , academiclevel :" + academiclevel +
                " , position :" + position
                ;
    }
}
