package async;

public class UserReserve {
    private Cars cars;
    private int quantity;
    private double totalAmount;

    public UserReserve() {
        this.cars = new Cars();
        this.quantity = 0;
        this.totalAmount = 0;
    }

    public UserReserve(Cars cars, int quantity) {
        this.cars = cars;
        this.quantity = quantity;
        this.totalAmount = cars.getPrice() * quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
