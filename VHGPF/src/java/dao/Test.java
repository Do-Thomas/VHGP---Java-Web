/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Asus
 */
public class Test {

    public static String tachChuoiNho(String str) {
        // Tìm vị trí của ký tự đầu tiên không phải là chữ số trong chuỗi
        int index = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            index++;
        }

        // Trả về chuỗi từ đầu đến vị trí index (không bao gồm index)
        return str.substring(0, index);
    }

    public static void main(String[] args) {
        String chuoiGoc = "S802";
//        String chuoiNho = tachChuoiNho(chuoiGoc);
        System.out.println("SubString: " + chuoiGoc.substring(0,2)); // Output: S8
    }

}
