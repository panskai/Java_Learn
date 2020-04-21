package Study_UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * �˷���ʹ��UDP+���߳�
 * 
 * ���Ͷˣ�ʹ����������װ
 * @author Pandamin
 *
 */
public class TalkSend implements Runnable{
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIP;
	private int toPort;
	public TalkSend(int port,String toIP,int toPort){
		this.toIP = toIP;
		this.toPort =toPort;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			String data;
			try {
				data = reader.readLine();
				byte[] datas = data.getBytes();
				System.out.println(datas);
//				3.��װ��DatagramPacket ������Ҫָ��Ŀ�ĵ�
				DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress(this.toIP,this.toPort));
				
//				4.���Ͱ���receive(DatagramPacket p)
				client.send(packet);
				System.out.println(packet);
				if(data.equals("bye")){
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.close();
	}

}