package CaseStudy.Model.Service;

public class Service {
    String service_id;
    String service_name;
    String service_area;
    String service_cost;
    String service_max_people;
    String rent_type_id;
    String service_type_id;
    String standard_room;
    String description_other_convenience;
    String pool_area;
    String number_of_floors;

    public Service() {
    }

    public Service(String service_id, String service_name, String service_area, String service_cost,
                   String service_max_people, String rent_type_id, String service_type_id, String standard_room,
                   String description_other_convenience, String pool_area, String number_of_floors) {
        this.service_id = service_id;
        this.service_name = service_name;
        this.service_area = service_area;
        this.service_cost = service_cost;
        this.service_max_people = service_max_people;
        this.rent_type_id = rent_type_id;
        this.service_type_id = service_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public String getService_cost() {
        return service_cost;
    }

    public void setService_cost(String service_cost) {
        this.service_cost = service_cost;
    }

    public String getService_max_people() {
        return service_max_people;
    }

    public void setService_max_people(String service_max_people) {
        this.service_max_people = service_max_people;
    }

    public String getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(String rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public String getService_type_id() {
        return service_type_id;
    }

    public void setService_type_id(String service_type_id) {
        this.service_type_id = service_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public String getPool_area() {
        return pool_area;
    }

    public void setPool_area(String pool_area) {
        this.pool_area = pool_area;
    }

    public String getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(String number_of_floors) {
        this.number_of_floors = number_of_floors;
    }
}
