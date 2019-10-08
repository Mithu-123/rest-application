package restApplication;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restApplication.thread.ThreadA;
import restApplication.thread.ThreadB;

@RestController
@RequestMapping(path = "/generate")
public class Generator {

	Logger logger = LoggerFactory.getLogger(Generator.class);

	@GetMapping(path = "/outOfMemory", produces = "application/json")
	public void generateOutOfMemoryError() throws InterruptedException {

		logger.info("********************* generateOutOfMemoryError() Called*****************");

		int dummyArraySize = 15;
		System.out.println("Max JVM memory: " + Runtime.getRuntime().maxMemory());
		long memoryConsumed = 0;
		try {
			long[] memoryAllocated = null;
			for (int loop = 0; loop < Integer.MAX_VALUE; loop++) {
				memoryAllocated = new long[dummyArraySize];
				memoryAllocated[0] = 0;
				memoryConsumed += dummyArraySize * Long.SIZE;
				System.out.println("Memory Consumed till now: " + memoryConsumed);
				dummyArraySize *= dummyArraySize * 2;
				Thread.sleep(900);
			}
		} catch (OutOfMemoryError outofMemory) {

			System.out.println("Catching out of memory error");
			logger.info("********************* generateOutOfMemoryError() Finished*****************");
			throw outofMemory;
		}

	}

	@GetMapping(path = "/deadLock", produces = "application/json")
	public String simulateThreadDeadLock() throws InterruptedException {
		logger.info("*********************simulateThreadDeadLock() Called*****************");
		Thread threadA = new ThreadA();
		Thread threadB = new ThreadB();
		threadA.start();
		threadB.start();

		Thread.sleep(8000);
		// Collecting thread dump
		final StringBuilder dump = new StringBuilder();
		final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 500);
		for (ThreadInfo threadInfo : threadInfos) {
			dump.append('"');
			dump.append(threadInfo.getThreadName());
			dump.append("\" ");
			final Thread.State state = threadInfo.getThreadState();
			dump.append("\n   java.lang.Thread.State: ");
			dump.append(state);
			final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
			for (final StackTraceElement stackTraceElement : stackTraceElements) {
				dump.append("\n        at ");
				dump.append(stackTraceElement);
			}
			dump.append("\n\n");
		}
		logger.info("*********************simulateThreadDeadLock() finished*****************");
		return dump.toString();

	}

}
