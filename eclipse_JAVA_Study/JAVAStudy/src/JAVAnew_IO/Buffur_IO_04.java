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
public class Buffur_IO_04 {
    public static void main(String[] args) {
        File src = new File("dst.txt");
        Writer writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(src));
            String msg = new String();
            msg="hsajhdjashjdhsajd";
            char[] datas = msg.toCharArray();
            writer.write(datas,0,datas.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch(Exception e){
                e.printStackTrace();
                }
            }
        }
    }
