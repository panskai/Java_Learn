package Chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң������
 * Ŀ�꣺ʵ��һ���ͻ����������շ���Ϣ
 * @author Pandamin
 *
 */
 
public class Chat {
	public static void main(String[] args) throws IOException {
		System.out.println("----------Server------------");
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		
//       * 3.������Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		
//       * 4.������Ϣ
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());		
		dos.writeUTF(datas);
		dos.flush();
//       * 5�ͷ���Դ
		dos.close();
		dis.close();
		client.close();
	}
}