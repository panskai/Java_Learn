package JAVAnew_IO;

import java.io.*;

/**
 * Create By ${���ɿ�} on S{DATE}
 * �ַ���+������
 *
 * ����Դ��
 * ѡ������
 * ������
 * �ͷ���Դ��
 */
public class Buffur_IO_03 {
    public static void main(String[] args) {
        File src = new File("dst.txt");
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            char[] flush = new char[1024];
            int len=-1;
            while((len=reader.read(flush))!=-1) {
                String msg = new String(flush, 0, flush.length);
                System.out.println(msg);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
        }
    }
