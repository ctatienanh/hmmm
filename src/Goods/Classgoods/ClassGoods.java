package Goods.Classgoods;

public class ClassGoods {
    private String brand;
    private String name;
    private int price;
    private String ram;
    private String battery;
    private int amount;

    public ClassGoods(String brand, String name, int price, String ram, String battery, int amount) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.ram = ram;
        this.battery = battery;
        this.amount = amount;
    }

    public ClassGoods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                 brand +
                "," + name +
                "," + price +
                "," + ram +
                "," + battery
                +"," +amount;
    }
}
