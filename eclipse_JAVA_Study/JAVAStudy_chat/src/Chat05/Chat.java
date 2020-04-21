package Chat05;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ����ʵ��������������������
 * 
 * 
 * 
 * ���������ң������
 * Ŀ�꣺˽��
 * @author Pandamin
 *

 * 
 */
 
public class Chat {
	private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<Channel>();
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		
		while(true){
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			Channel c = new Channel(client);
			all.add(c);
			new Thread(c).start(); 
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
		private String name;
		public Channel(Socket client) {
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
				inRunning=true;
				//��ȡ����
				this.name = receive();
				//��ӭ��ĵ���
				this.send("��ӭ��ĵ�����");
				sendOthers(this.name+"������������",true);
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
				System.out.println("2");
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
		//+Ⱥ��:��ȡ�Լ�����Ϣ������������
		//+˽��:Լ�����ݸ�ʽ��@xxx:msg
		private void sendOthers(String msg,boolean isSys) {
			boolean isPrivate = msg.startsWith("@");
			if(isPrivate){//˽��
				//��ȡĿ������ݣ�
				int idx = msg.indexOf(":");
				String targetname = msg.substring(1,idx);
				msg = msg.substring(idx+1);
				for(Channel other:all){
					if(other.name.equals(targetname)){//Ŀ��
						other.send(this.name+"���ĵĶ���˵:"+msg);//˽��
						break;
					}
				}
			}else{
				for(Channel other:all){
					if(other==this){
						continue;
					}
					if(!isSys){
						other.send(this.name+"��������˵:"+msg);//Ⱥ��
					}else{
						other.send(msg);//ϵͳ��Ϣ
					}
				}
			}
		}
		//3.�ͷ���Դ
		private void release() {
			this.inRunning=false;
			Utils.close(dis,dos,client);
			//�˳�
			all.remove(this);
			sendOthers(this.name+"�뿪�˴��ͥ", true);
		}
		public void run() {
			// TODO Auto-generated method stub
			while(inRunning){
				String msg = receive();
				if(!msg.equals("")){
//					send(msg);
					sendOthers(msg,false);
				}
			}
		}
	}
}