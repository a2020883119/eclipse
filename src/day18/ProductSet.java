package day18;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ProductSet {
	List list;
	
	ProductSet(){							//���췽������list
		list = new ArrayList();
	}
	
	void addProduct(Product product){		//������Ʒ
		list.add(product);
		System.out.println("��Ʒ��ţ�"+product.getNo()+"\t��Ʒ���ƣ�"+product.getName()+"\t��Ʒ������"+product.getNum()+"\t��Ʒ�۸�"+product.getPrice()+"\t��Ʒ���أ�"+product.getProductAdd()+"\t�� �ڣ�"+product.getDate()+"\n����Ӳ�Ʒ����ӳɹ�\n");
	}
	void delProduct(){						//ɾ����Ʒ
		showProductMessage();
		System.out.print("��ɾ����Ʒ����������Ʒ���:");
		Scanner sca = new Scanner(System.in);
		int id = sca.nextInt();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Product product = (Product)it.next();
			if(product.getNo() == id){
				list.remove((Object)product);
				System.out.println("��ɾ����Ʒ����ϲ�㣬����Ʒɾ���ɹ�");
				showProductMessage();
				return;
			}
		}
		System.out.println("��ɾ����Ʒ���Բ��𣬴���Ʒ�������޷�ɾ��");
	}
	void showProductMessage(){				//��ʾ������Ʒ
		Iterator it = list.iterator();
		int count = 0;
		System.out.println("********************************************��ʾ������Ʒ��Ϣ*************************************************\n");
		while(it.hasNext()){
			count++;
			Product product = (Product)it.next();
			System.out.println("��Ʒ��ţ�"+product.getNo()+"\t��Ʒ���ƣ�"+product.getName()+"\t��Ʒ������"+product.getNum()+"\t��Ʒ�۸�"+product.getPrice()+"\t��Ʒ���أ�"+product.getProductAdd()+"\t�� �ڣ�"+product.getDate());
		}
		System.out.println("\n*********************************************����"+count+"����Ʒ****************************************************");
	}
	void updataProduct(){					//������Ʒ��Ϣ
		Product product = new Product();
		System.out.println("��������Ʒ��1.ͨ����Ʒ��Ÿ���\t2.ͨ����Ʒ���Ƹ���");
		Scanner sca = new Scanner(System.in);
		int choice = sca.nextInt();
		int byId = -1;
		String byName = null;
		switch (choice) {
		case 1:
			showProductMessage();
			System.out.println("��������Ʒ��������Ҫ��Ҫ���޸���Ʒ�ı�ţ�");
			byId = sca.nextInt();
			break;
		case 2:
			showProductMessage();
			System.out.println("��������Ʒ��������Ҫ��Ҫ���޸���Ʒ�����ƣ�");
			byName = sca.next().trim();
			break;
			
		default:
			System.out.println("��������Ʒ���Ƿ�ѡ�񣡹����˳���");
			return;
		}

		boolean flag = false;
		if(byId != -1){
			Iterator it = list.iterator();
			while(it.hasNext()){
				product = (Product)it.next();
				if(product.getNo() == byId){
					System.out.println("��������Ʒ����Ʒ��ţ�"+product.getNo()+"\t��Ʒ���ƣ�"+product.getName()+"\t��Ʒ������"+product.getNum()+"\t��Ʒ�۸�"+product.getPrice()+"\t��Ʒ���أ�"+product.getProductAdd()+"\t�� �ڣ�"+product.getDate());
					System.out.println("��������Ʒ�����ڴ���Ʒ���������");
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
					System.out.println("��������Ʒ����Ʒ��ţ�"+product.getNo()+"\t��Ʒ���ƣ�"+product.getName()+"\t��Ʒ������"+product.getNum()+"\t��Ʒ�۸�"+product.getPrice()+"\t��Ʒ���أ�"+product.getProductAdd()+"\t�� �ڣ�"+product.getDate());
					System.out.println("��������Ʒ�����ڴ���Ʒ���������");
					flag = true;
					break;
				}
			}
		}
		if(!flag){
			System.out.println("��������Ʒ������Ʒ�����ڣ������˳�");
			return;
		}
		System.out.println("��������Ʒ������ֵ���밴�س�ȷ�ϣ�����Ҫ�޸ĵ�ֵ�������� '0' ");
		
		System.out.println("��������Ʒ����������Ʒ��ţ�");
		int no = sca.nextInt();				//��Ʒ���
		if(no != 0){
			product.setNo(no);
		}
		System.out.println("��������Ʒ����������Ʒ���ƣ�");
		String name = sca.next();		//��Ʒ����
		if(!"0".equals(name)){
			product.setName(name);
		}
		System.out.println("��������Ʒ����������Ʒ������");
		int num = sca.nextInt();			//��Ʒ����
		if(num != 0){
			product.setNum(num);
		}
		System.out.println("��������Ʒ����������Ʒ�۸�");
		double price = sca.nextDouble();		//��Ʒ�۸�
		if(price != 0){
			product.setPrice(price);
		}
		System.out.println("��������Ʒ����������Ʒ���أ�");
		String productAdd = sca.next();	//��Ʒ����
		if(!"0".equals(productAdd)){
			product.setProductAdd(productAdd);
		}
		System.out.println("��������Ʒ���޸����");
		System.out.println("��������Ʒ����Ʒ��ţ�"+product.getNo()+"\t��Ʒ���ƣ�"+product.getName()+"\t��Ʒ������"+product.getNum()+"\t��Ʒ�۸�"+product.getPrice()+"\t��Ʒ���أ�"+product.getProductAdd()+"\t�� �ڣ�"+product.getDate());
	}
}
