package Chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң������
 * Ŀ�꣺ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
 * @author Pandamin
 *
 * ���⣺
 * 1.���벻��ά��
 * 2.�ͻ��˶�дû�зֿ���������д���
 * 
 */
 
public class TMultiChat {
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		
		while(true){
			final Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			
			new Thread(new Runnable(){
				public void run() {
					// TODO Auto-generated method stub
					DataInputStream dis = null;
					DataOutputStream dos = null;
					try {
						dis = new DataInputStream(client.getInputStream());
						dos = new DataOutputStream(client.getOutputStream());	
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					boolean isRunning = true;
					while(isRunning){
						String datas;
						try {
							datas = dis.readUTF();
//						       * 4.������Ϣ
							dos.writeUTF(datas);
							dos.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					try {
						if(null==dos)
							dos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(null==dis)
							dis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						if(null==client)
							client.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						isRunning = false;
					}
				}
			}).start();
//	       * 3.������Ϣ
		}
//       * 5�ͷ���Դ
	}
}