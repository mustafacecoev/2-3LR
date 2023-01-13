package sample;

public class Cars {
    private String id;
    private String brand;
    private String car_Classes;
    private String name;
    private String color;
    private Double price;

    public Cars() {
        this.id = "0000";
        this.brand = "";
        this.car_Classes = "";
        this.name = "";
        this.color = "";
        this.price = 0.0;
    }

    @Override
    public String toString() {
        return brand + " " + car_Classes + " " + name
                + " " + color+ " "  + price + "P";
    }

    public Cars(String id, String brand, String car_Classes, String name, String color, double price) {
        this.id = id;
        this.brand = brand;
        this.car_Classes = car_Classes;
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCar_Classes() {
        return car_Classes;
    }

    public void setCar_Classes(String car_Classes) {
        this.car_Classes =car_Classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}


