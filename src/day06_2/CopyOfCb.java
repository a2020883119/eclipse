package day06_2;

public class CopyOfCb extends Ca implements Ia{
	CopyOfCb(){
		super();
	}
	CopyOfCb(int n){
		super(n);
	}
	
//	private int dataCellCount;
//	private int dataLumpCount;
//	private int totalDataCellCount;
//	
//	public int getDataCellCount() {
//		return dataCellCount;
//	}
//	public void setDataCellCount(int dataCellCount) {
//		this.dataCellCount = va[0].length;
//	}
//	public int getDataLumpCount() {
//		return dataLumpCount;
//	}
//	public void setDataLumpCount(int dataLumpCount) {
//		this.dataLumpCount = va.length;
//	}
//	public int getTotalDataCellCount() {
//		return totalDataCellCount;
//	}
//	public void setTotalDataCellCount(int totalDataCellCount) {
//		this.totalDataCellCount = va.length * va[0].length;
//	}
	
	@Override
	public void add(int data) {
		//��һ������������
		if(vl < va.length * va[0].length){
			va[vl / va[0].length][vl % va[0].length - 1] = data;   
			vl++;
			return;
		}
		else{
			int [] newIntArr = new int [va[0].length];
			newIntArr [0] = data;
			va[va.length] = newIntArr;
			vl++;
		}
	}

	@Override
	public void add(int index, int data) {
		//��һ�������������ָ��λ��
		if(index > vl || index < 0){													//�����쳣         �Ƿ���������
			System.out.println("add() error:index: " + index + " OutOfIndex!");
			return;
		}
		
		if(vl + 1 > va.length * va[0].length){											//����ʱλ�ò������������飬Ϊ���������׼���ط�
			
			if(vl == va.length * va[0].length){											//index Ϊ�������һ��λ�õ����
				add(data);
				return;
			}																			//index �����������һ��λ��ʱ�������µ����ݿ飬Ϊ���������׼���ط�
			
			int [] newIntArr = new int [va[0].length];
			va[va.length] = newIntArr;
			
			for(int i = va.length - 1; i > vl / va[0].length; i--){  					//���˲������ݵ����ݿ鲻�������������ݵ����ݿ����������ݿ��������Ǩ��
				va[i + 1][0] = va[i][va[0].length];
				for(int j = va[0].length - 1; j >= 1; j--){
					va[i][j] = va[i][j - 1];
				}
			}
			
			va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//ǰһ�����ݿ����һ������һ�����ݿ��һ���������ݿ������			
			for(int i = va.length - 1; i >= index % va[0].length; i--){					//Ǩ�Ʋ������ݵ����ݿ��е�����
				va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
			}
			va[index  / va[0].length][index % va[0].length - 1] = data; 				//data�ŵ�ָ��λ��                           
			vl++;
			return;
		}
		
		if(vl + 1 <= va.length * va[0].length){											//����λ���㹻��ֱ�Ӻ�����������
			
			if(va.length - vl / va[0].length - 1 >= 2){									//λ�ù��������ݿ� >= 2�������
				for(int i = vl % va[0].length; i >= 1; i--){							//�����һ�����ݿ飨�����ݿ鲻����
					va[index / va[0].length][i] = va[index / va[0].length][i - 1];
				}
				
				for(int i = vl / va[0].length - 1; i > index / va[0].length; i--){  	//��Ҫ��������ݿ�����һ�����ݿ�֮��������ݿ�
					va[i + 1][0] = va[i][va[0].length];									
					for(int j = va[0].length - 1; j >= 1; j--){
						va[i][j] = va[i][j - 1];
					}
				}
				
				va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//ǰһ�����ݿ����һ������һ�����ݿ��һ���������ݿ������	����������ݿ��ƶ�ǰִ��һ��		
				for(int i = va.length - 1; i >= index % va[0].length; i--){					//Ǩ�Ʋ������ݵ����ݿ��е�����
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data�ŵ�ָ��λ��
				vl++;
				return;
			}
			
			if(va.length - index / va[0].length == 1){									//λ�ù������ݿ鲻��)�������ݿ����� == 1  
				
				for(int i = vl % va[0].length; i >= 1; i--){							//�����һ�����ݿ飨�����ݿ鲻����
					va[index / va[0].length][i] = va[index / va[0].length][i - 1];
				}
				
				va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//ǰһ�����ݿ����һ������һ�����ݿ��һ���������ݿ������	����������ݿ��ƶ�ǰִ��һ��		
				for(int i = va.length - 1; i >= index % va[0].length; i--){					//Ǩ�Ʋ������ݵ����ݿ��е�����
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data�ŵ�ָ��λ��
				vl++;
				return;
			}
			
			if(vl / va[0].length == index / va[0].length){								//λ�ù���Ҫ��������ݿ鲻�������������ݿ����� == 0
				
				for(int i = va[0].length - 1; i >= index % va[0].length; i--){					//Ǩ�Ʋ������ݵ����ݿ��е�����
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data�ŵ�ָ��λ��
				vl++;
				return;
			}
			
		}
		
	}

	@Override
	public void remove() {
		//ɾ����������
		vl = 0;
	}

	@Override
	public void remove(int index) {
		//ɾ��ָ��λ������
		if(index > vl || index < 0){//�쳣����   �Ƿ������쳣
			System.out.println("remove() error:index: " + index + " OutOfIndex!");
			return;
		}
		
		if(va.length - vl / va[0].length - 1 >= 2){//ǰ�ƣ�λ�ù�����ɾ������� >= 2 ��
			
			for(int i = index % va[0].length ; i < va.length - 1; i++){					//Ǩ��ɾ�����ݵ����ݿ��е�����
				va[index  / va[0].length][i - 1] = va[index  / va[0].length][i];
			}
			
			
			vl--;
		}
		
		if(va.length - index / va[0].length == 1){//ǰ�ƣ�λ�ù�����ɾ������� == 1 ��
			vl--;
		}
		
		if(vl / va[0].length == index / va[0].length){//ǰ�ƣ�λ�ù�����ɾ�������û�����ݿ�
			
			vl--;
		}
	}

	@Override
	public int find(int data) {
		//��ǰ��ʼ������va���ҵ�������λ�ã�������
		int count = 0;
		for(int i = 0; i < va.length; i++){
			for(int j = 0; j < va[0].length; j++){
				count++;
				if(va[i][j] == data){
					return count;
				}
			}
		}
		return -1;
	}

	@Override
	public int findLast(int data) {
		//�Ӻ�ʼ������va���ҵ�������λ�ã�������
		int count = 0;																//����
		boolean flag = false;														//����������
		for(int i = va.length - 1; i > 0; i--){//��������
			for(int j = va[0].length - 1; j > 0; j--){
				if(va[vl / va[0].length][vl % va[0].length] == va[i][j]){			//�ҵ���ʼλ�ü��򿪼�����
					flag = true;
				}
				if(flag == true){													//���ش����м�����
					count++;
				}
				if(va[i][j] == data){												//return
					return vl - count + 1;
				}
			}
		}
		return -1;
	}

	@Override
	public void change(int index, int data) {
		//��ָ��λ�õ�ֵ�ı�Ϊ������ֵ
		if(index > vl || index < 0){//�쳣����   �Ƿ������쳣
			System.out.println("change() error:index: " + index + " OutOfIndex!");
			return;
		}
		va[index  / va[0].length][index % va[0].length - 1] = data;					//data�ŵ�ָ��λ��
		vl++;
		return;
	}
	
}
