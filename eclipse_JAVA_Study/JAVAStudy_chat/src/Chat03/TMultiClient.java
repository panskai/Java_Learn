package Chat03;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����ʵ��������������������
 * 
 * 
 * ���������ң��ͻ���
 * Ŀ�꣺��װ+ʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
 * @author Pandamin
 *
 */
public class TMultiClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----------Client------------");
//		 * 1.�������ӣ�ʹ��Socket�����ͻ���+��������ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
		
//		 * 2.���������������(������Ϣ)
		new Thread(new Send(client)).start();
		new Thread(new Receive(client)).start();
		
	}
}