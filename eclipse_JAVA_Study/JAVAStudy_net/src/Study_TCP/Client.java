package Study_TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	/**
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
		// TODO Auto-generated method stub
//		 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
//		 * 2.���������������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		dos.writeUTF(data);
		dos.flush();
//		 * 3.�ͷ���Դ
		dos.close();
		client.close();
	}

}