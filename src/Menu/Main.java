package Menu;


import Goods.CreateGoods.GoodsCreate;
import Goods.CreateGoods.MenuGuest;
import Login.Loginn;

public class Main {
    public static void main(String[] args) {

        Loginn loginn = new Loginn();
        while (true){
            if (Loginn.accountUser == null ){
                loginn.Menu();
            }else {
                if (Loginn.accountUser.getRole().equals("user")){
                    MenuGuest.Menu();
                } else if (Loginn.accountUser.getRole().equals("staff")) {
                    GoodsCreate.Menu();
                }else if (Loginn.accountUser.getRole().equals("admin")){
                    loginn.Menuadmin();
                }else {
                    System.out.println("Không tìm thấy tài khoản");
                }
            }
        }
    }
}
