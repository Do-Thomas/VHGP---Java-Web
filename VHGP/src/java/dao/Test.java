/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
public class Test {

    public static void main(String[] args) throws ParseException {
//        Map<String, String> map = new HashMap<>();
//        
//        // Add some elements to the map
//        map.put("key1", "value1");
//        map.put("key2", "value2");
//        map.put("key3", "value3");
//        map.put("key4", "value4");
//        
//        // Keys to be removed
//        String[] keysToRemove = { "key1", "key3" };
//        
//        // Remove elements using individual remove() calls
//        for (String key : keysToRemove) {
//            map.remove(key);
//        }
//        
//        // Print the remaining elements in the map
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + ": " + value);
//        }

        // TODO Auto-generated method stub
        List al = new ArrayList();
        al.add("Sachin");
        al.add("Rahul");
        al.add("saurav");
        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            itr.remove();
            System.out.println("Trống" + al);
        }
    }

}
