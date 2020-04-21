package Study_UDP;
/**
 * 加入多线程，实现双向交流，模拟在线咨询
 * @author Pandamin
 *
 */
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(7777,"localhost",9999)).start();
		
		new Thread(new TalkReceive(8888)).start();
	}
}
