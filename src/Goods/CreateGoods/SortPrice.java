package Goods.CreateGoods;

import Goods.Classgoods.ClassGoods;

import java.util.Comparator;

public class SortPrice implements Comparator<ClassGoods> {
    @Override
    public int compare(ClassGoods o1, ClassGoods o2) {
        if (o1.getPrice()>o2.getPrice()){
            return 1;
        }else return -1;
    }
}
