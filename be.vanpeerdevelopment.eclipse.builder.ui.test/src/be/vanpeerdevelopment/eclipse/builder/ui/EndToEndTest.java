package be.vanpeerdevelopment.eclipse.builder.ui;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class EndToEndTest {

	protected static SWTWorkbenchBot workbench;

	@BeforeClass
	public static void beforeTests() {
		workbench = new SWTWorkbenchBot();
	}
}