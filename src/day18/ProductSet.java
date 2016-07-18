package day18;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ProductSet {
	List list;
	
	ProductSet(){							//构造方法创建list
		list = new ArrayList();
	}
	
	void addProduct(Product product){		//增加商品
		list.add(product);
		System.out.println("商品编号："+product.getNo()+"\t商品名称："+product.getName()+"\t商品数量："+product.getNum()+"\t商品价格："+product.getPrice()+"\t商品产地："+product.getProductAdd()+"\t日 期："+product.getDate()+"\n【添加产品】添加成功\n");
	}
	void delProduct(){						//删除商品
		showProductMessage();
		System.out.print("【删除商品】请输入商品编号:");
		Scanner sca = new Scanner(System.in);
		int id = sca.nextInt();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Product product = (Product)it.next();
			if(product.getNo() == id){
				list.remove((Object)product);
				System.out.println("【删除商品】恭喜你，此商品删除成功");
				showProductMessage();
				return;
			}
		}
		System.out.println("【删除商品】对不起，此商品不存在无法删除");
	}
	void showProductMessage(){				//显示所有商品
		Iterator it = list.iterator();
		int count = 0;
		System.out.println("********************************************显示所有商品信息*************************************************\n");
		while(it.hasNext()){
			count++;
			Product product = (Product)it.next();
			System.out.println("商品编号："+product.getNo()+"\t商品名称："+product.getName()+"\t商品数量："+product.getNum()+"\t商品价格："+product.getPrice()+"\t商品产地："+product.getProductAdd()+"\t日 期："+product.getDate());
		}
		System.out.println("\n*********************************************共有"+count+"类商品****************************************************");
	}
	void updataProduct(){					//更新商品信息
		Product product = new Product();
		System.out.println("【更新商品】1.通过商品编号更新\t2.通过商品名称更新");
		Scanner sca = new Scanner(System.in);
		int choice = sca.nextInt();
		int byId = -1;
		String byName = null;
		switch (choice) {
		case 1:
			showProductMessage();
			System.out.println("【更新商品】请输入要需要被修改商品的编号：");
			byId = sca.nextInt();
			break;
		case 2:
			showProductMessage();
			System.out.println("【更新商品】请输入要需要被修改商品的名称：");
			byName = sca.next().trim();
			break;
			
		default:
			System.out.println("【更新商品】非法选择！功能退出！");
			return;
		}

		boolean flag = false;
		if(byId != -1){
			Iterator it = list.iterator();
			while(it.hasNext()){
				product = (Product)it.next();
				if(product.getNo() == byId){
					System.out.println("【更新商品】商品编号："+product.getNo()+"\t商品名称："+product.getName()+"\t商品数量："+product.getNum()+"\t商品价格："+product.getPrice()+"\t商品产地："+product.getProductAdd()+"\t日 期："+product.getDate());
					System.out.println("【更新商品】存在此商品请继续操作");
					flag = true;
					break;
				}
			}
		}
		if(byName != null){
			Iterator it = list.iterator();
			while(it.hasNext()){
				product = (Product)it.next();
				if(product.getName().equals(byName)){
					System.out.println("【更新商品】商品编号："+product.getNo()+"\t商品名称："+product.getName()+"\t商品数量："+product.getNum()+"\t商品价格："+product.getPrice()+"\t商品产地："+product.getProductAdd()+"\t日 期："+product.getDate());
					System.out.println("【更新商品】存在此商品请继续操作");
					flag = true;
					break;
				}
			}
		}
		if(!flag){
			System.out.println("【更新商品】此商品不存在，功能退出");
			return;
		}
		System.out.println("【更新商品】输入值后请按回车确认，不需要修改的值键入数字 '0' ");
		
		System.out.println("【更新商品】请输入商品编号：");
		int no = sca.nextInt();				//商品编号
		if(no != 0){
			product.setNo(no);
		}
		System.out.println("【更新商品】请输入商品名称：");
		String name = sca.next();		//商品名称
		if(!"0".equals(name)){
			product.setName(name);
		}
		System.out.println("【更新商品】请输入商品数量：");
		int num = sca.nextInt();			//商品数量
		if(num != 0){
			product.setNum(num);
		}
		System.out.println("【更新商品】请输入商品价格：");
		double price = sca.nextDouble();		//商品价格
		if(price != 0){
			product.setPrice(price);
		}
		System.out.println("【更新商品】请输入商品产地：");
		String productAdd = sca.next();	//商品产地
		if(!"0".equals(productAdd)){
			product.setProductAdd(productAdd);
		}
		System.out.println("【更新商品】修改完毕");
		System.out.println("【更新商品】商品编号："+product.getNo()+"\t商品名称："+product.getName()+"\t商品数量："+product.getNum()+"\t商品价格："+product.getPrice()+"\t商品产地："+product.getProductAdd()+"\t日 期："+product.getDate());
	}
}
