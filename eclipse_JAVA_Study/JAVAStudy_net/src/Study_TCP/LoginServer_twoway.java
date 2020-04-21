package Study_TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼+˫��
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
public class LoginServer_twoway {
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
		
		String uname="";
		String upwd="";
		
		//����
		String[] dataArray = datas.split("&");
		for(String info:dataArray){
			String[] useInfo = info.split("=");
			if(useInfo[0].equals("uname")){
				System.out.println("�û���Ϊ��"+useInfo[1]);
				uname=useInfo[1];
			}else if(useInfo[0].equals("upwd")){
				System.out.println("����Ϊ��"+useInfo[1]);
				upwd=useInfo[1];
			}
		}
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		if(uname.equals("pandamin")&&upwd.equals("123")){
			System.out.println("��¼�ɹ�");
			dos.writeUTF("��¼�ɹ�");
		}else{
			System.out.println("��¼ʧ��");
			dos.writeUTF("��¼ʧ��");
		}
		dos.flush();
//		System.out.println(datas);
//		 * 4.�ͷ���Դ
		dis.close();
	}
}