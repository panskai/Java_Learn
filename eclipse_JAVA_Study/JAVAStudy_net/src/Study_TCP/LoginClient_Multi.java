package Study_TCP;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient_Multi {

	/**
	 * ģ���¼+����ͻ�������
	 * 
	 * 
	 *  * ��Ϥ���̣�
 * �����ͻ�����
 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
 * 2.���������������
 * 3.�ͷ���Դ
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("------Client-------");
		// TODO Auto-generated method stub
//		 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
		
		Socket client = new Socket("localhost",8888);
//		 * 2.���������������
		new Send(client).send();
		new Receive(client).receive();
		client.close();
	}
	static class Send{
		private DataOutputStream dos;
		private BufferedReader reader ;
		private Socket client;
		private String msg;
		public Send(Socket client) {
			reader = new BufferedReader(new InputStreamReader(System.in));
			this.msg = init();
			// TODO Auto-generated constructor stub
			this.client=client;
			try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private String init(){
			try {
				System.out.println("�������û�����");
				String uname = reader.readLine();
				System.out.println("���������룺");
				String upwd = reader.readLine();
				return "uname="+uname+"&"+"upwd="+upwd;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
		public void send(){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
	static class Receive{
		private DataInputStream dis;
		private Socket client;
		public Receive(Socket client){
			this.client=client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void receive(){
			String result;
			try {
				result = dis.readUTF();
				System.out.println(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}