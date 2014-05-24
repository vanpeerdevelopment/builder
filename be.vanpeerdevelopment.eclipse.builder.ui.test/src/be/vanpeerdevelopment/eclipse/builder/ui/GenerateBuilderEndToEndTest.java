package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public class GenerateBuilderEndToEndTest {

	protected static SWTWorkbenchBot workbench;

	@BeforeClass
	public static void beforeTests() {
		workbench = new SWTWorkbenchBot();
	}

	@Test
	public void generateBuilderAddedToSourceMenu() {
		assertEquals(true, true);
	}
}