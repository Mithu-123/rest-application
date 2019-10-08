package restApplication.thread;

public class ThreadB extends Thread {

	public void run() {
		synchronized (StringResource.resource2) {
			System.out.println("Resource2 "+StringResource.resource2.hashCode());
			System.out.println(Thread.currentThread().getName()+" acquired lock on resource2");
		/*	try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			synchronized (StringResource.resource1) {
				System.out.println(Thread.currentThread().getName()+" acquired lock on resource1");
			}
		}
	}

}