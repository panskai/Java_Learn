package Sever.basic;
/**
 * ����:��java���еĸ��ֽṹ(���������ԣ�������������)ӳ���һ����java����
 * 1.��ȡClass����       //��ȡͼֽ�����ṹ
 *      1.����.getClass();
 *      2.��.class;
 *�Ƽ�: 3.Class.forName("����.����");
 * 2.���Զ�̬��������   //���Էֽ�ͼֽ
 * 
 * 
 * @author Pandamin
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception {
		/**
		 * ���ַ�ʽ��ȡclass����
		 */
		//1.����.getClass();                      �������Լ��и�lphone,���Լ���(�൱���Լ���ͼֽ)
//		lphone iphone=new lphone();
//		Class clz = iphone.getClass();
		//2.��.class();                           ��������ͨ���ڲ�������ֱ���õ���ͼֽ
//		clz=lphone.class;
		//3.Class.forName("����.����");           �������Լ�֪����ַ��ȥ͵ͼֽ
		Class clz=Class.forName("Sever.basic.lphone");
		
		/**
		 * ��������
		 */
		//��ʽ1:����ȫ
		lphone iphone2=(lphone)clz.newInstance();
		//��ʽ2:��԰�ȫ
//		lphone iphone2=(lphone)clz.getConstructor().newInstance();
		System.out.println(iphone2);
	}
}
class lphone{
	public lphone(){
		
	}
}