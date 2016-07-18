package day18;

import java.io.*;
import java.util.Date;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductSet pst = new ProductSet();
		
		Product p1 = new Product(1000, "»Æ×ê", 200, 10, "ÉîÛÚ", new Date());
		Product p2 = new Product(1001, "ºì×ê", 200, 10, "ÉîÛÚ", new Date());
		Product p3 = new Product(1002, "ÂÌ×ê", 200, 10, "ÉîÛÚ", new Date());
		Product p4 = new Product(1003, "ºÚ×ê", 200, 10, "ÉîÛÚ", new Date());
		Product p5 = new Product(1004, "°××ê", 200, 10, "ÉîÛÚ", new Date());
		Product p6 = new Product(1005, "½ğ×ê", 200, 10, "ÉîÛÚ", new Date());
		pst.addProduct(p1);
		pst.addProduct(p2);
		pst.addProduct(p3);
		pst.addProduct(p4);
		pst.addProduct(p5);
		pst.addProduct(p6);
		pst.showProductMessage();
		pst.delProduct();
		pst.updataProduct();
	
	}
	

}
