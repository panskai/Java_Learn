package Study_TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼+����
 * 
 * ��Ϥ���̣�
 * ����������
 * 1.ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 * @author Pandamin
 *
 */
public class LoginServer {
	public static void main(String[] args) throws IOException {
//		 * ����������
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
//		 * 3.���������������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		
		//����
		String[] dataArray = datas.split("&");
		for(String info:dataArray){
			String[] useInfo = info.split("=");
			if(useInfo[0].equals("uname")){
				System.out.println("�û���Ϊ��"+useInfo[1]);
			}else if(useInfo[0].equals("upwd")){
				System.out.println("����Ϊ��"+useInfo[1]);
			}
		}
//		System.out.println(datas);
//		 * 4.�ͷ���Դ
		dis.close();
	}
}