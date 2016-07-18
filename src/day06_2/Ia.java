package day06_2;

interface Ia {
	//将一个数存入数组
	void add(int data);
	//将一个数存入数组的指定位置
	void add(int index, int data);
	//删除所有数据
	void remove();
	//删除指定位置数据
	void remove(int index);
	//从前开始在数组va中找到参数的位置，并返回
	int find(int data);
	//从后开始在数组va中找到参数的位置，并返回
	int findLast(int data);
	//将指定位置的值改变为参数的值
	void change(int index, int data);
}
