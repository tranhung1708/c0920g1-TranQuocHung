package Common;

public class ValiDate {
    private static String regex = "";
    public static boolean checkMaBenhAN(String customer_id) {
        regex = "(BA-)[0-9]{3}";
        return customer_id.matches(regex);
    }
    public static boolean checkMaBenhBN(String customer_id) {
        regex = "(BN-)[0-9]{3}";
        return customer_id.matches(regex);
    }
    public static boolean checkBirthday(String customer_birthday){
        regex = "\\d{4}((\\/)|(\\-))(0?[1-9]|1[012])((\\/)|(\\-))(0?[1-9]|[12][0-9]|3[01])";
        return customer_birthday.matches(regex);
    }
    public static boolean checkNumberPhone(String customer_phone){
        regex ="(84)\\d{10}";
        return customer_phone.matches(regex);
    }
    public static boolean checkIdCard(String customer_id_card){
        regex ="\\d{9}";
        return customer_id_card.matches(regex);
    }
    public static boolean checkEmail(String customer_email){
        regex ="[a-zA-Z]+[@][a-zA-Z]+[.][a-zA-Z]+";
        return  customer_email.matches(regex);
    }
    public static boolean checkDate(String date){
        regex = "\\d{4}((\\/)|(\\-))(0?[1-9]|1[012])((\\/)|(\\-))(0?[1-9]|[12][0-9]|3[01])";
        return date.matches(regex);
    }
    public static boolean checkIdService(String service_id){
        regex = "(DV-)[0-9]{4}";
        return service_id.matches(regex);
    }
    public static boolean checkPeople(String service_max_people){
        regex = "[1-9]+";
        return  service_max_people.matches(regex);
    }
    public static boolean checkNumberOfFloors(String number_of_floors){
        regex = "[1-9]+";
        return  number_of_floors.matches(regex);
    }
    public static boolean checkServiceCost(String service_cost){
        regex = "[1-9]+";
        return  service_cost.matches(regex);
    }
}
