package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

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
	public void javaClassIsCreated() {
		assertTrue(eclipse.classExists(JAVA_PROJECT_NAME, JAVA_SOURCE_FOLDER_NAME,
				JAVA_PACKAGE_NAME,
				JAVA_CLASS_NAME));
	}

	@Test
	public void textFileIsCreated() {
		assertTrue(eclipse.fileExists(JAVA_PROJECT_NAME, TEXT_FILE_FOLDER, TEXT_FILE_NAME));
	}
}