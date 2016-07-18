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
		//将一个数存入数组
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
		//将一个数存入数组的指定位置
		if(index > vl || index < 0){													//处理异常         非法参数处理
			System.out.println("add() error:index: " + index + " OutOfIndex!");
			return;
		}
		
		if(vl + 1 > va.length * va[0].length){											//插入时位置不够，增加数组，为插入的数据准备地方
			
			if(vl == va.length * va[0].length){											//index 为数组最后一个位置的情况
				add(data);
				return;
			}																			//index 不是数组最后一个位置时，开辟新的数据块，为插入的数据准备地方
			
			int [] newIntArr = new int [va[0].length];
			va[va.length] = newIntArr;
			
			for(int i = va.length - 1; i > vl / va[0].length; i--){  					//除了插入数据的数据块不操作，插入数据的数据块后面的满数据块进行数据迁移
				va[i + 1][0] = va[i][va[0].length];
				for(int j = va[0].length - 1; j >= 1; j--){
					va[i][j] = va[i][j - 1];
				}
			}
			
			va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//前一个数据块最后一个，后一个数据块第一个，跨数据块搬数据			
			for(int i = va.length - 1; i >= index % va[0].length; i--){					//迁移插入数据的数据块中的数据
				va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
			}
			va[index  / va[0].length][index % va[0].length - 1] = data; 				//data放到指定位置                           
			vl++;
			return;
		}
		
		if(vl + 1 <= va.length * va[0].length){											//插入位置足够，直接后移所有数据
			
			if(va.length - vl / va[0].length - 1 >= 2){									//位置够，后数据块 >= 2的情况；
				for(int i = vl % va[0].length; i >= 1; i--){							//搬最后一个数据块（此数据块不满）
					va[index / va[0].length][i] = va[index / va[0].length][i - 1];
				}
				
				for(int i = vl / va[0].length - 1; i > index / va[0].length; i--){  	//搬要插入的数据块和最后一个数据块之间的满数据块
					va[i + 1][0] = va[i][va[0].length];									
					for(int j = va[0].length - 1; j >= 1; j--){
						va[i][j] = va[i][j - 1];
					}
				}
				
				va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//前一个数据块最后一个，后一个数据块第一个，跨数据块搬数据	被插入的数据块移动前执行一次		
				for(int i = va.length - 1; i >= index % va[0].length; i--){					//迁移插入数据的数据块中的数据
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data放到指定位置
				vl++;
				return;
			}
			
			if(va.length - index / va[0].length == 1){									//位置够（数据块不满)，后数据块数量 == 1  
				
				for(int i = vl % va[0].length; i >= 1; i--){							//搬最后一个数据块（此数据块不满）
					va[index / va[0].length][i] = va[index / va[0].length][i - 1];
				}
				
				va[index / va[0].length + 1][va[0].length] = va[index / va[0].length][0]; 	//前一个数据块最后一个，后一个数据块第一个，跨数据块搬数据	被插入的数据块移动前执行一次		
				for(int i = va.length - 1; i >= index % va[0].length; i--){					//迁移插入数据的数据块中的数据
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data放到指定位置
				vl++;
				return;
			}
			
			if(vl / va[0].length == index / va[0].length){								//位置够（要插入的数据块不满），后面数据块数量 == 0
				
				for(int i = va[0].length - 1; i >= index % va[0].length; i--){					//迁移插入数据的数据块中的数据
					va[index  / va[0].length][i] = va[index  / va[0].length][i - 1];
				}
				
				va[index  / va[0].length][index % va[0].length - 1] = data;					//data放到指定位置
				vl++;
				return;
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
		
		if(va.length - vl / va[0].length - 1 >= 2){//前移，位置够，被删除块后面 >= 2 块
			
			for(int i = index % va[0].length ; i < va.length - 1; i++){					//迁移删除数据的数据块中的数据
				va[index  / va[0].length][i - 1] = va[index  / va[0].length][i];
			}
			
			
			vl--;
		}
		
		if(va.length - index / va[0].length == 1){//前移，位置够，被删除块后面 == 1 块
			vl--;
		}
		
		if(vl / va[0].length == index / va[0].length){//前移，位置够，被删除块后面没有数据块
			
			vl--;
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
		int count = 0;																//计数
		boolean flag = false;														//计数器开关
		for(int i = va.length - 1; i > 0; i--){//遍历数组
			for(int j = va[0].length - 1; j > 0; j--){
				if(va[vl / va[0].length][vl % va[0].length] == va[i][j]){			//找到开始位置即打开计数器
					flag = true;
				}
				if(flag == true){													//开关打开运行计数器
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
