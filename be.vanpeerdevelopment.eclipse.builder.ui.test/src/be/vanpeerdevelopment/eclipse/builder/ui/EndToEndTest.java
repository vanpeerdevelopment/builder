package be.vanpeerdevelopment.eclipse.builder.ui;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.Eclipse.eclipse;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.Eclipse;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class EndToEndTest {

	protected static Eclipse eclipse;

	@BeforeClass
	public static void beforeTests() {
		eclipse = eclipse();
		eclipse.closeWelcomeViewIfNeeded();
		eclipse.openJavaPerspectiveIfNeeded();
		eclipse.createJavaProjectIfNotExists();
		eclipse.createRegularProjectIfNotExists();
	}
}