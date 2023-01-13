package sample;

public class StoreAssortment {
    private Cars[] cars;
    private int[] quantity;

    public StoreAssortment(Cars[] cars, int[] quantity) {
        this.cars = cars;
        this.quantity = quantity;
    }

    public StoreAssortment() {
    }

    public void setQuantityFromIndex(int index, int value) {
        try {
            quantity[index] = value;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cars[] getCars() {
        return cars;
    }

    public void setCars(Cars[] cars) { this.cars = cars;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }
}
