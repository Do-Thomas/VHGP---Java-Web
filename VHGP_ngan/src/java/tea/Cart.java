/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tea;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ngân
 */
public class Cart {

    private Map<String, Tea> cart;

    public Cart() {
    }

    public Cart(Map<String, Tea> cart) {
        this.cart = cart;
    }

    public Map<String, Tea> getCart() {
        return cart;
    }

    public void setCart(Map<String, Tea> cart) {
        this.cart = cart;
    }

    // add san pham vao gio hang
    public boolean add(Tea tea) {
        boolean result = false;
        Date date = tea.getDeliveryDate();
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // Định dạng chuỗi mong muốn
        String dateString = dateFormat.format(date); // Chuyển đổi thành chuỗi

// || this.cart.containsKey(madv)
        this.cart.put(dateString, tea);
        result = true;
        return result;
    }

    public boolean remove(String id, Date ids, Tea tea) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsValue(tea)) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // Định dạng chuỗi mong muốn
                String dateString = dateFormat.format(ids);
                this.cart.remove(id, tea);
                result = true;

            }
        }
        return result;
    }

    public boolean removedate(Date id) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.remove(id);
                result = true;

            }
        }
        return result;
    }

    public boolean removeall(Tea tea) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsValue(tea)) {
                this.cart.remove(tea);
                result = true;

            }
        }
        return result;
    }

    public boolean update(String id, Tea tea) {
        boolean result = false;
        if (this.cart != null) {
            if (this.cart.containsKey(id)) {
                this.cart.replace(id, tea);
                result = true;

            }

        }

        return result;

    }

    public Map<String, Tea> getCartWithoutDeliveryTime() throws ParseException {
        Map<String, Tea> cartWithoutDeliveryTime = new HashMap<>();

        for (Map.Entry<String, Tea> entry : cart.entrySet()) {
            String key = entry.getKey();
            Tea tea = entry.getValue();

            // Tạo một phiên bản mới của Tea chỉ với các thuộc tính không bao gồm DeliveryTime
            Tea teaWithoutDeliveryTime = new Tea(
                    tea.getMadv(),
                    tea.getTendv(),
                    tea.getDongia(),
                    tea.getDetails(),
                    tea.getThoigian(),
                    tea.getHinhanh(),
                    tea.getDeliveryDate()
            );
            String dateStr = "03/10/2002";
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(dateStr);
            teaWithoutDeliveryTime.setDeliveryTime(date);
            // Thêm Tea mới vào giỏ hàng mới
            cartWithoutDeliveryTime.put(key, teaWithoutDeliveryTime);
        }

        return cartWithoutDeliveryTime;
    }

    public boolean updatedate(Date id, Tea newtea, Tea tea) {
        boolean result = false;
        if (this.cart != null) {
            String a = tea.getMadv();

            Date date = tea.getDeliveryDate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // Định dạng chuỗi mong muốn
            String dateString = dateFormat.format(id);
            String dateStrings = dateFormat.format(id);
            String dates = dateFormat.format(newtea.getDeliveryDate());
            String da = dateFormat.format(newtea.getDeliveryTime());
//            Tea teas = this.cart.get(dateString);
            if (this.cart.containsKey(dates)) {

                Map<String, Tea> carts = cart;

                carts.remove(da);
                boolean containsMadv = false;
                for (Tea CartItem : carts.values()) {
                    if (CartItem.getMadv().equals(tea.getMadv()) && CartItem.getDeliveryDate().equals(tea.getDeliveryDate())) {
                        containsMadv = true;
                        break;
                    }
                }

                if (containsMadv == true) {
                    this.cart.remove(da);
                    result = true;
                } else {
                    if (newtea.getMadv().equals(tea.getMadv())) {
                        this.cart.put(dates, tea);

//                    this.cart.remove(dates,tea);
                        result = true;
                    }
                }

            }

        }
        return result;

    }
}

//
// public boolean updatedate(Date id, Tea tea, Tea newtea) {
//        boolean result = false;
//        if (this.cart != null) {
//            String a=tea.getMadv();
//            
//            Date date = tea.getDeliveryDate();
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S"); // Định dạng chuỗi mong muốn
//            String dateString = dateFormat.format(id);
//            String dateStrings = dateFormat.format(date);
//            String dates=dateFormat.format(newtea.getDeliveryDate());
////            Tea teas = this.cart.get(dateString);
//            if (this.cart.containsKey(dates)) {
//                if(this.cart.containsKey(dateStrings))
//                {
//                     
////                     Calendar calendar = Calendar.getInstance();
////    calendar.setTime(date);
////
////    // Cộng thêm 1 giây
////    calendar.add(Calendar.SECOND, 1);
////
////    // Lấy thời gian sau khi cộng thêm 1 giây
////    Date newDate = calendar.getTime();
////
////    // Chuyển đổi thành chuỗi theo định dạng
////    String newDateString = dateFormat.format(newDate);
//
////     this.cart.put(newDateString, tea);
////         this.cart.remove(dates,tea);
//     result=true;
//                }
//                else{
////                this.cart.replace(dateString, tea);
//                if (newtea.getMadv().equals(tea.getMadv())) {
//                    this.cart.put(dateStrings, tea);
//                    
//                    this.cart.remove(dates,tea);
//                    result = true;
//                    
//                }
//                }
//            }
//
//        }
//        return result;
//
//
//    
//    }
