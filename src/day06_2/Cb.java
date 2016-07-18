package day06_2;

public class Cb extends Ca implements Ia{
	Cb(){
		super();
	}
	Cb(int n){
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
		if(vl == 0){
			va[0][0] = data;
			vl++;
			return;
		}
		if(vl < va.length * va[0].length && vl > 0){
			va[vl / va[0].length][vl % va[0].length] = data;   
			vl++;
			return;
		}else{
			int [][] newIntArr = new int [va.length + 1][va[0].length];
			for(int i = 0; i < va.length; i++){
				newIntArr[i] = va[i];
			}
			newIntArr[va.length][0] = data;
			va = newIntArr;
			vl++;
			return;
		}
	}

	@Override
	public void add(int index, int data) {
		//��һ�������������ָ��λ��
		if(index > vl || index <= 0){													//�����쳣         �Ƿ���������
			System.out.println("add() error:index: " + index + " OutOfIndex!");
			return;
		}															//�Ӻ���ǰ��ʼ�����ݺ���һλ���ܵĿ��� Ĭ�Ϲ�		
		for(int i = (vl - 1)/ va[0].length; i >= index / va[0].length; i--){					//����
			for(int j = va[0].length - 1; j >= 0; j--){					
				if(i == (vl - 1) / va[0].length && j == va[0].length){
					//��������һ�����ݿ�   ���ǵ�һ��ѭ��  ֱ�Ӱ�jֵ�������һ������λ��
					j = vl - 1 % va[0].length;
				}				
					if(j == va[0].length - 1){											//��λʱ �������ݿ����һ��Ԫ��
						if(i == (vl - 1) / va[0].length){										//��������һ�����ݿ�����һ��Ԫ�أ���������Ҫ���죬�����µ����飬�ƶ���ֵ
							int [][] newIntArr = new int [va.length + 1][va[0].length];
							for(int k = 0; k < va.length; k++){
								newIntArr[k] = va[k];
							}
							newIntArr[i + 1][0] = va[i][j];
							va = newIntArr;								
						}else{															//����������һ�����ݿ�����һ��Ԫ�أ����鲻��Ҫ�������죬ֱ���ƶ���ֵ
							va[i + 1][0] = va[i][j];
						}
					}else{
						va[i][j + 1] = va[i][j];		
					}

				if(i == index / va[0].length && j == (index - 1) % va[0].length){		//��λ����������� �жϸղ��ƶ����ǲ���index - 1������Ҫ�������λ�ã�
					va[index / va[0].length][(index - 1) % va[0].length] = data;			//�����        ˵���Ѿ������յ�    ����ִ�в������    data�ŵ�ָ��λ��   vl++    ���� ����
					vl++;
					return;
				}
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
		if(index == vl){
			vl--;
			return;
		}
		for(int i = (index == 100 ? 99:index) / va[0].length; i <= (vl - 1) / va[0].length; i++){
			for(int j = 0; j < va[0].length; i++){
				if(i == (index == 100 ? 99:index) / va[0].length && j == 0){
					j = (index == 100 ? 99:index) % va[0].length;
				}
				if(j == 0 ){
					va[i - 1][0] = va[i][j];
				}else{
					va[i][j] = va[i][j + 1];
				}
				if(i == (vl == 100 ? 99:vl) / va[0].length && j == vl % va[0].length){
					vl--;
					return;
				}
			}
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
		int count = 0;																												//����������
		for(int i = va.length - 1; i >= 0; i--){//��������
			for(int j = va[0].length - 1; j > 0; j--){
				if(va.length - 1 == i && va[0].length - 1 == j){
					j = vl % va[0].length - 1;
				}
					count++;
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
