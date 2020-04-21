package Study_UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/**
 * 
 * @author Pandamin+��ν���
 * 1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
 * 2.׼������ һ��ת���ֽ�����
 * 3.��װ��DatagramPacket ������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���receive(DatagramPacket p)
 * 5.�ͷ���Դ
 */
public class UDPTalk_client {
	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������....");
//		1.ʹ��DatagramSocket ָ���˿ڣ��������ն�
		DatagramSocket client = new DatagramSocket(10000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		2.׼������ һ��ת���ֽ�����
		while(true){
			String data = reader.readLine();

			byte[] datas = data.getBytes();
			System.out.println(datas);
//			3.��װ��DatagramPacket ������Ҫָ��Ŀ�ĵ�
			DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8889));
			
//			4.���Ͱ���receive(DatagramPacket p)
			client.send(packet);
			System.out.println(packet);
			if(data.equals("bye")){
				break;
			}
		}
		
//		5.�ͷ���Դ
		client.close();
	}
}