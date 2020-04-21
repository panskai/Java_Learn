package Chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����ʵ��������������������
 * 
 * 
 * 
 * ���������ң������
 * Ŀ�꣺��װ+ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
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
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start(); 
//	       * 3.������Ϣ
		}
//       * 5�ͷ���Դ
	}
	
	//һ���ͻ�����һ��Channel
	static class Channel implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private Socket client;
		private boolean inRunning;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				inRunning=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("1");
				release();
			}
		}
		//1.������Ϣ
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("������Ϣ����2");
				release();
			}
			return msg;
		}
		//2.������Ϣ
		private void send(String msg) {
			try {
				dos.writeUTF(msg);
				dos.flush();
//				System.out.println("ˢ��");
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println("3");
				release();
			}
		}
		//3.�ͷ���Դ
		private void release() {
			this.inRunning=false;
			Utils.close(dis,dos,client);
		}
		public void run() {
			// TODO Auto-generated method stub
			while(inRunning){
				String msg = receive();
				if(!msg.equals("")){
					send(msg);
				}
			}
		}
	}
}