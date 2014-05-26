package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.junit.Test;

public class TestSetupEndToEndTest extends EndToEndTest {

	private static final String JAVA_PERSPECTIVE = "Java";

	@Test(expected = WidgetNotFoundException.class)
	public void welcomeViewIsClosed() {
		workbench.viewByTitle("Welcome");
	}

	@Test
	public void javaPerspectiveOpenByDefault() {
		assertEquals(JAVA_PERSPECTIVE, workbench.activePerspective().getLabel());
	}

}
