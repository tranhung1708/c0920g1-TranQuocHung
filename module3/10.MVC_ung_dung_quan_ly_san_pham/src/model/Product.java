package model;

public class Product {
    int id;
    String name;
    int price;
    String description;
    String producer;

    public Product() {
    }

    public Product(int id, String name, int price, String description, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name_product='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", producer='" + producer + '\'' +
                '}';
    }
}
