package day06_2;

interface Ia {
	//��һ������������
	void add(int data);
	//��һ�������������ָ��λ��
	void add(int index, int data);
	//ɾ����������
	void remove();
	//ɾ��ָ��λ������
	void remove(int index);
	//��ǰ��ʼ������va���ҵ�������λ�ã�������
	int find(int data);
	//�Ӻ�ʼ������va���ҵ�������λ�ã�������
	int findLast(int data);
	//��ָ��λ�õ�ֵ�ı�Ϊ������ֵ
	void change(int index, int data);
}
