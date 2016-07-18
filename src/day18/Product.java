package day18;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class Product implements Serializable{
	Product(){
	}
	Product(int no, String name, int num, double price, String productAdd, Date date){
		setNo(no);
		setName(name);
		setNum(num);
		setPrice(price);
		setProductAdd(productAdd);
		setDate(date);
	}
	private int no;				//商品编号
	private String name;		//商品名称
	private int num;			//商品数量
	private double price;		//商品价格
	private String productAdd;	//商品产地
	private String date;			//添加日期
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductAdd() {
		return productAdd;
	}
	public void setProductAdd(String productAdd) {
		this.productAdd = productAdd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dataStr = sdf.format(date);
		this.date = dataStr;
	}
}
