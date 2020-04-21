package Test;
/**
 *��������һ���˿ͣ�һ���ϰ壬 �˿�������ӳԣ�ÿ�ι˿����ˣ�
 *�ϰ�Ҫ���������ʲô���˿ͻش�԰��ӣ��ϰ�Ϳ�ʼ�����ӣ��˿ͽ���˯�ߣ�
 *�ϰ�Ҫ10����һ�����ӣ����ú�˿Ϳ��ԣ���30����꣬
 *����ش�һ���óԣ���20��������й˿ͼ��룬���û�а���Ҫ���� �ϰ�Ҫͣ���������н���˯��
 * @author Pandamin
 */
public class Stro {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		store container=new store();
		new Boss(container,12).start();
		new Consumer(container,2).start();
	}
}
//�ϰ�
class Boss extends Thread{
	private boolean making = true;
	private int bcount = 0;//�ϰ����˵İ�����
	static int allbcount;//�ܰ�����
	store container;
	public Boss(store container,int allbcount) {
		super();
		this.container = container;
		this.allbcount = allbcount;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(making){
			try {
				bcount++;
				container.push(new bun(bcount));
				Thread.sleep(1*1000);
				System.out.println("1s�ӹ�ȥ��......����"+bcount+"������");
				if(allbcount==bcount){
					System.out.println("����İ����������ˣ�");
					making = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		making = true;
	}
}
//�˿�
class Consumer extends Thread{
	private int ebcount;//�˿͵���ӵ�����
	private boolean eating = true;
	store container;	
	public Consumer(store container,int ebcount) {
		super();
		this.container = container;
		this.ebcount = ebcount;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(eating){
			try {
				Thread.sleep(3*1000);
				container.pop();
				ebcount--;
				if(ebcount==0){
					System.out.println("�˿�˵���Ӻó�");
					eating = false;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		eating = true;
	}
}
//�ŵ�
class store{
	bun[] buns=new bun[10];
	int count=0;
	//��������
	public synchronized void push(bun bun) {
		if(count==buns.length){
			try {
				System.out.println("�ϰ���Ϣһ�ᣡ");
				this.wait();//�߳�����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buns[count++]=bun;
		this.notifyAll();//����
		System.out.println("�˿�����.....");
	}
	//���۰���
	public synchronized bun pop() {
		if(count==0){
			try {
				System.out.println("�˿���Ϣһ��");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//�߳�����
		}
		count--;
		this.notifyAll();//����;
		System.out.println("�ϰ忪����");
		return null;
	}
}
//����
class bun{
	int id;
	public bun(int id) {
		super();
		this.id = id;
	}
}