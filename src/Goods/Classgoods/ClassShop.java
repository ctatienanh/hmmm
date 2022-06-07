package Goods.Classgoods;

public class ClassShop extends  ClassGoods{
    private int amounts;
    private String time;

    public ClassShop( String name, int price, int amounts, String time) {
        super( name, price);
        this.amounts = amounts;
        this.time = time;
    }

    public int getAmounts() {
        return amounts;
    }

    public void setAmounts(int amounts) {
        this.amounts = amounts;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
