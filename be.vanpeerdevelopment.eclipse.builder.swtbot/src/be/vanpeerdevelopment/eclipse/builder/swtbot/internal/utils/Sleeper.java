package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils;

import java.util.concurrent.TimeUnit;

public class Sleeper {

	public static void sleep(int time, TimeUnit timeUnit) {
		try {
			Thread.sleep(timeUnit.toMillis(time));
		} catch (InterruptedException e) {
			throw new RuntimeException("Something went wrong while sleeping.", e);
		}
	}
}