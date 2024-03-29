package Study_UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/**
 * 
 * @author Pandamin+多次交流
 * 1.使用DatagramSocket 指定端口，创建接收端
 * 2.准备数据 一定转成字节数组
 * 3.封装成DatagramPacket 包裹需要指定目的地
 * 4.发送包裹receive(DatagramPacket p)
 * 5.释放资源
 */
public class UDPTalk_client {
	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中....");
//		1.使用DatagramSocket 指定端口，创建接收端
		DatagramSocket client = new DatagramSocket(10000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		2.准备数据 一定转成字节数组
		while(true){
			String data = reader.readLine();

			byte[] datas = data.getBytes();
			System.out.println(datas);
//			3.封装成DatagramPacket 包裹需要指定目的地
			DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",8889));
			
//			4.发送包裹receive(DatagramPacket p)
			client.send(packet);
			System.out.println(packet);
			if(data.equals("bye")){
				break;
			}
		}
		
//		5.释放资源
		client.close();
	}
}
