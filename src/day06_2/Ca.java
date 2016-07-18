package day06_2;

public abstract class Ca {
	//存放va[]数组中数的个数
	int vl;
	//整形数组
	int [] [] va;
	//创建100个元素的数组va
	Ca(){
		vl = 0;
		va = new int [1][100];
	}
	//创建n+n*50%个元素的数组va
	Ca(int n){
		vl = 0;
		va = new int [1][n + (int)(n * 0.5)];
	}
}
