package day06;

public abstract class Ca {
	//���������ֵ
	int max;
	//���va[]���������ĸ���
	int vl;
	//��������
	int [] va;
	//����100��Ԫ�ص�����va
	Ca(){
		vl = 0;
		va = new int [100];
		max = 100;
	}
	//����n+n*50%��Ԫ�ص�����va
	Ca(int n){
		vl = 0;
		va = new int [n + (int)(n * 0.5)];
		max = n + (int)(n * 0.5);
	}
}
