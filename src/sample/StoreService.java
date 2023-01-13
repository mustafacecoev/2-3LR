package sample;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService(serviceName = "DisplayAssortment", portName = "DisplayAssortmentPort", targetNamespace = "http://asu.dgtu.donetsk.ua/ex/passexam")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class StoreService {

    private static Cars[] carsData = {
            new Cars("1", "BMW", "E", "BMW E60", "White",20000),
            new Cars("2", "BMW", "E", "BMW E90", "Blue",15000),
            new Cars("3", "Mercedes", "F", "Mercedes-Benz F200", "Red",12000),
            new Cars("4", "Mercedes", "F", "Mercedes-Benz F400", "Black",15000),
            new Cars("5", "Porsche", "S", "Porsche 911 Turbo S", "Red",20000)
    };
    // the number of products in the store
    private static int[] quantityData = {12, 31, 4, 19, 20};
    private static StoreAssortment storeAssortment = new StoreAssortment(carsData, quantityData);

    @WebMethod(operationName = "GetStoreAssortment")
    public StoreAssortment getStoreAssortment() {
        return storeAssortment;
    }

}