package CaseStudy.service;

import CaseStudy.model.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comparator implements java.util.Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if(o1.getHoTen().equals(o2.getHoTen())){
            SimpleDateFormat f =new SimpleDateFormat("dd/MM/yyyy");
            Date date1=null;
            Date date2=null;
            try {
                date1= f.parse(o1.getNgaySinh());
                date2= f.parse(o2.getNgaySinh());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date1.compareTo(date2)==0){
                return o1.getHoTen().compareTo(o2.getHoTen());
            }else {
                return date1.compareTo(date2);
            }
        }
        return o1.getHoTen().compareTo(o2.getHoTen());
    }
}
