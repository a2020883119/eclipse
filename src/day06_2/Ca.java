package day06_2;

public abstract class Ca {
	//���va[]���������ĸ���
	int vl;
	//��������
	int [] [] va;
	//����100��Ԫ�ص�����va
	Ca(){
		vl = 0;
		va = new int [1][100];
	}
	//����n+n*50%��Ԫ�ص�����va
	Ca(int n){
		vl = 0;
		va = new int [1][n + (int)(n * 0.5)];
	}
}
