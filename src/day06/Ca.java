package day06;

public abstract class Ca {
	//缓冲区最大值
	int max;
	//存放va[]数组中数的个数
	int vl;
	//整形数组
	int [] va;
	//创建100个元素的数组va
	Ca(){
		vl = 0;
		va = new int [100];
		max = 100;
	}
	//创建n+n*50%个元素的数组va
	Ca(int n){
		vl = 0;
		va = new int [n + (int)(n * 0.5)];
		max = n + (int)(n * 0.5);
	}
}
