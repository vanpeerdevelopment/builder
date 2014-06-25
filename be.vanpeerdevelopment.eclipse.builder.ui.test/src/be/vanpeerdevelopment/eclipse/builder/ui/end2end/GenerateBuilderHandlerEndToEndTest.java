package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static org.eclipse.jface.bindings.keys.KeyStroke.getInstance;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.ALT;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.CTRL;
import static org.junit.Assert.assertTrue;

import org.eclipse.jface.bindings.keys.ParseException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.SWTBotTest;

public class GenerateBuilderHandlerEndToEndTest extends SWTBotTest {

	@Test
	public void generateBuilder() throws ParseException {
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.pressShortcut(CTRL, ALT, getInstance("B"));

		assertTrue(eclipse.willClassBeCreated(
				JAVA_PROJECT_NAME,
				JAVA_SOURCE_FOLDER_NAME,
				JAVA_PACKAGE_NAME,
				JAVA_CLASS_NAME + "Builder"));

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder")
				.ok();
	}
}
