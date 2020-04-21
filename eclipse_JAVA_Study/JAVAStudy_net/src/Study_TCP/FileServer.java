package Study_TCP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ϥ���̣�
 * ����������
 * 1.ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 * @author Pandamin
 *
 */
public class FileServer {
	public static void main(String[] args) throws IOException {
//		 * ����������
//		 * 1.ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
//		 * 2.����ʽ�ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
//		 * 3.���������������
		InputStream is = new BufferedInputStream(client.getInputStream());
		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("src/3.png"));
		byte[] flush = new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1){
			System.out.println();
			os.write(flush,0,len);
		}
		os.flush();
//		 * 4.�ͷ���Դ
		os.close();
		is.close();
	}
}