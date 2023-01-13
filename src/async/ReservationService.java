package async;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "Reservation", portName = "ReservationPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/students")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class ReservationService {

	// store Cars assortment
	//TODO поменять
	private static Cars[] carsData = {
			new Cars("1", "BMW", "E", "BMW E60", "White",20000),
			new Cars("2", "BMW", "E", "BMW E90", "Blue",15000),
			new Cars("3", "Mercedes", "F", "Mercedes-Benz F200", "Red",12000),
			new Cars("4", "Mercedes", "F", "Mercedes-Benz F400", "Black",15000),
			new Cars("5", "Porsche", "S", "Porsche 911 Turbo S", "Red",20000)
	};
	// the number of products in the store
	private static int[] quantityData = {12, 32, 12, 42, 42};
	private static StoreAssortment storeAssortment = new StoreAssortment(carsData, quantityData);
	private UserReserve goReserveCars(String type, int quantity) {
		int size = storeAssortment.getCarss().length;
		for (int i = 0; i < size; i++) {
			Cars currentCars = storeAssortment.getCarss()[i];
			int currentQuantity = storeAssortment.getQuantity()[i];
			if (type.equals(currentCars.getCarClasses()) && quantity <= currentQuantity) {
				storeAssortment.setQuantityFromIndex(i, currentQuantity - quantity);
				return new UserReserve(currentCars, quantity);
			}
		}
		return null;
	}

	@WebMethod(operationName = "ReserveCars")
	public UserReserve reserveCars(String type, int quantity) {
		try {
			Thread.sleep(1000*10); // Sleep for 10 seconds
			return goReserveCars(type, quantity);
		} catch(InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	 public static void main(String args[]) {
	        Endpoint.publish("http://localhost:8082/Reservation", new ReservationService());
	  }
}
