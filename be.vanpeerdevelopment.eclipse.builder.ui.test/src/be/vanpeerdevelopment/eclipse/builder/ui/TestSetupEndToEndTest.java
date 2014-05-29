package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestSetupEndToEndTest extends EndToEndTest {

	@Test
	public void welcomeViewIsClosed() {
		assertFalse(eclipse.isWelcomeViewOpen());
	}

	@Test
	public void javaPerspectiveIsOpen() {
		assertTrue(eclipse.isJavaPerspectiveOpen());
	}

	@Test
	public void javaProjectIsCreated() {
		assertTrue(eclipse.projectExists(JAVA_PROJECT_NAME));
	}

	@Test
	public void textFileIsCreated() {
		assertTrue(eclipse.fileExsists(JAVA_PROJECT_NAME, TEXT_FILE_FOLDER, TEXT_FILE_NAME));
	}
}