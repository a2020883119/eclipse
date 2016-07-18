package day06;

public class Cb extends Ca implements Ia{
	Cb(){
		super();
	}
	Cb(int n){
		super(n);
	}
	@Override
	public void add(int data) {
		//将一个数存入数组
		if(vl < max){
			va[vl] = data;
			vl++;
			return;
		}
		else{
			max++;
			int [] intArr = new int [max];
			intArr [vl] = data;
			for(int i = 0; i < vl; i++){
				intArr[i] = va[i];
			}
			va = intArr;
			vl++;
		}
	}

	@Override
	public void add(int index, int data) {
		//将一个数存入数组的指定位置
		if(index > vl){
			System.out.println("add() OutOfIndex!");
			return;
		}
		if(index > max){
			int [] intArr = new int [index];
			intArr [index - 1] = data;
			for(int i = 0; i < vl; i++){
				intArr[i] = va[i];
			}
			vl = index;
			max = index;
			va = intArr;
			return;
		}
		if(index < max){
			if(vl < index){
				va[index - 1] = data;
				return;
			}
			for(int i = index; i >= vl ; i--){
				va[i] = va[i - 1];
			}
			va[index - 1] = data;
			vl--;
			return;
		}
		
	}

	@Override
	public void remove() {
		//删除所有数据
		vl = 0;
	}

	@Override
	public void remove(int index) {
		//删除指定位置数据
		if(index > vl){
			System.out.println("remove() OutOfIndex!");
			return;
		}
		for(int i = index; i < vl - 2 ; i++){
			va[i] = va[i + 1];
		}
		vl--;
	}

	@Override
	public int find(int data) {
		//从前开始在数组va中找到参数的位置，并返回
		for(int i = 0; i < vl; i++){
			if(va[i] == data){
				return i + 1;
			}
		}
		return -1;
	}

	@Override
	public int findLast(int data) {
		//从后开始在数组va中找到参数的位置，并返回
		for(int i = vl - 1; i > 0; i--){
			if(va[i] == data){
				return vl - i;
			}
		}
		return -1;
	}

	@Override
	public void change(int index, int data) {
		//将指定位置的值改变为参数的值
		if(index > vl){
			System.out.println("change() OutOfIndex!");
			return;
		}
		va[index - 1] = data;
	}
	
}
