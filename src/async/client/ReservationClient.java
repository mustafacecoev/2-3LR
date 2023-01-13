package async.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

public class ReservationClient {

    private final static QName RESERVATION_QNAME = new QName(
            "http://asu.dgtu.donetsk.ua/ex/students", "Reservation"
    );
    // User choice reserve
    private String Cars_carClasses = "S";
    private int QUANTITY_RESERVE = 2;
    class ReserveAsyncHandler implements AsyncHandler<ReserveCarsResponse> {
        private ReserveCarsResponse response;
        @Override
        public void handleResponse(Response<ReserveCarsResponse> res) {
            try {
                response = res.get(2000, TimeUnit.MILLISECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        public UserReserve getResponse() {
            return response.getReturn();
        }
    }

    private static URL getWSDLURL(String urlStr) {
        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return url;
    }

    public UserReserve processCallback(URL url, String typeRes, int quantityRes) {
        Reservation svc = new Reservation(url, RESERVATION_QNAME);
        ReservationService port = svc.getReservationPort();
        ReserveAsyncHandler asyncHandler = new ReserveAsyncHandler();
        Future<?> futureResponse = port.reserveCarsAsync(typeRes, quantityRes, asyncHandler);

        while (!futureResponse.isDone()) {
            try {
                System.out.println("Please wait...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        UserReserve userCarsReserve = asyncHandler.getResponse();
        return userCarsReserve;
    }

    private static void printUserReserve(UserReserve reserve) {
        if (reserve != null) {
            System.out.println("\n*** Вы зарезервировали товар ***\n --------------------------------");
            Cars cars = reserve.getCars();
            System.out.println(cars.brand + " " +
                    cars.carClasses + " | " +
                    cars.name + " | " +
                    cars.color + " | " +
                    cars.price + "$" +
                    " | Amount: " + reserve.quantity +
                    " | Sum: " + reserve.totalAmount + "$");
        } else {
            System.out.println("\n*** Не удалось зарезервировать товар ***\n --------------------------------");
        }
    }

    public static void main(String[] args) {
        URL url = getWSDLURL("http://localhost:8082/Reservation?wsdl");
        ReservationClient client = new ReservationClient();
        UserReserve userCarsReserve = client.processCallback(url, client.Cars_carClasses, client.QUANTITY_RESERVE);
        printUserReserve(userCarsReserve);
    }


}
