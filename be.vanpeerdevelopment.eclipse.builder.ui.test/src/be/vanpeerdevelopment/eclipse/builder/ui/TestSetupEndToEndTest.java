package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertEquals;

import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.junit.Test;

public class TestSetupEndToEndTest extends EndToEndTest {

	private static final String WELCOME_VIEW_TITLE = "Welcome";
	private static final String JAVA_PERSPECTIVE_LABEL = "Java";

	@Test(expected = WidgetNotFoundException.class)
	public void welcomeViewIsClosed() {
		workbench.viewByTitle(WELCOME_VIEW_TITLE);
	}

	@Test
	public void javaPerspectiveIsOpenByDefault() {
		assertEquals(JAVA_PERSPECTIVE_LABEL, workbench.activePerspective().getLabel());
	}

}
