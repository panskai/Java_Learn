package JAVAnew_IO;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Create By ${���ɿ�} on S{DATE}
 * ��00-03С�ۺ�
 *
 * 1.��ͼƬ��ȡ��������
 * 2.���ֽ�����д�����ļ�
 *
 */
public class IO_Study04 {
    public static void main(String[] args) {
//        1.����Դ:Դͷ���ֽ�����
        byte[] dest;
//        2.ѡ����������Ҫʹ������������ʹ�ò��ܷ��Ͷ�̬��
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
//            3.����(д��)
            String msg = "show me the code";
            byte[] datas = msg.getBytes();
            baos.write(datas,0,datas.length);
            baos.flush();
            dest = baos.toByteArray();
            System.out.println(dest);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
        }
    }
