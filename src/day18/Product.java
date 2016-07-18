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
	private int no;				//��Ʒ���
	private String name;		//��Ʒ����
	private int num;			//��Ʒ����
	private double price;		//��Ʒ�۸�
	private String productAdd;	//��Ʒ����
	private String date;			//�������
	
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
