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
		//将一个数存入数组
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
		//将一个数存入数组的指定位置
		if(index > vl || index <= 0){													//处理异常         非法参数处理
			System.out.println("add() error:index: " + index + " OutOfIndex!");
			return;
		}															//从后往前开始把数据后移一位功能的开关 默认关		
		for(int i = (vl - 1)/ va[0].length; i >= index / va[0].length; i--){					//遍历
			for(int j = va[0].length - 1; j >= 0; j--){					
				if(i == (vl - 1) / va[0].length && j == va[0].length){
					//如果在最后一个数据块   且是第一次循环  直接把j值等于最后一个数的位置
					j = vl - 1 % va[0].length;
				}				
					if(j == va[0].length - 1){											//移位时 发现数据块最后一个元素
						if(i == (vl - 1) / va[0].length){										//如果是最后一个数据块的最后一个元素，数组则需要延伸，创建新的数组，移动数值
							int [][] newIntArr = new int [va.length + 1][va[0].length];
							for(int k = 0; k < va.length; k++){
								newIntArr[k] = va[k];
							}
							newIntArr[i + 1][0] = va[i][j];
							va = newIntArr;								
						}else{															//如果不是最后一个数据块的最后一个元素，数组不需要考虑延伸，直接移动数值
							va[i + 1][0] = va[i][j];
						}
					}else{
						va[i][j + 1] = va[i][j];		
					}

				if(i == index / va[0].length && j == (index - 1) % va[0].length){		//移位操作进行完后 判断刚才移动的是不是index - 1（数据要被插入的位置）
					va[index / va[0].length][(index - 1) % va[0].length] = data;			//如果是        说明已经到达终点    可以执行插入操作    data放到指定位置   vl++    返回 结束
					vl++;
					return;
				}
			}
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
		
		if(index > vl || index < 0){//异常处理   非法参数异常
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
		//从前开始在数组va中找到参数的位置，并返回
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
		//从后开始在数组va中找到参数的位置，并返回
		int count = 0;																												//计数器开关
		for(int i = va.length - 1; i >= 0; i--){//遍历数组
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
		//将指定位置的值改变为参数的值
		if(index > vl || index < 0){//异常处理   非法参数异常
			System.out.println("change() error:index: " + index + " OutOfIndex!");
			return;
		}
		va[index  / va[0].length][index % va[0].length - 1] = data;					//data放到指定位置
		vl++;
		return;
	}
	
}
