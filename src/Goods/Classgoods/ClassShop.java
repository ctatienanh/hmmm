package Goods.Classgoods;

public class ClassShop extends  ClassGoods{
    private int amounts;
    private String time;

    private String account;
    private int prices;

    public ClassShop( String name, int price, int amounts, String time, String account,int prices) {
        super( name, price);
        this.amounts = amounts;
        this.time = time;
        this.account = account;
        this.prices = prices;
    }

    public int getPrices() {
        return prices;
    }

    public void setPrices(int prices) {
        this.prices = prices;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    @Override
    public String toString() {
        return super.getName()+ ","+ super.getPrice()+"," +  amounts + "," + time + "," + account +","+prices ;
    }
}
