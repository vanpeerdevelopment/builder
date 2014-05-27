package be.vanpeerdevelopment.eclipse.builder.ui;

import static be.vanpeerdevelopment.eclipse.builder.ui.Eclipse.eclipse;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class EndToEndTest {

	protected static Eclipse eclipse;

	@BeforeClass
	public static void beforeTests() {
		eclipse = eclipse();
		eclipse.closeWelcomeViewIfNeeded();
		eclipse.openJavaPerspectiveIfNeeded();
	}
}