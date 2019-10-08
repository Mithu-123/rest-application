package restApplication.thread;

public class ThreadA extends Thread {
	public void run() {

		synchronized (StringResource.resource1) {
			System.out.println("Resource1 "+StringResource.resource1.hashCode());
			System.out.println(Thread.currentThread().getName()+" acquired lock on resource1");
			/*try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			synchronized (StringResource.resource2) {
				System.out.println(Thread.currentThread().getName()+"acquired lock on resource2");
			}
		}
	}

}
