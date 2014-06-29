package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.EclipseTest;

public class TestSetupEndToEndTest extends EclipseTest {

	@Test
	public void welcomeViewIsClosed() {
		assertThat(eclipse.isWelcomeViewOpen()).isFalse();
	}

	@Test
	public void javaPerspectiveIsOpen() {
		assertThat(eclipse.isJavaPerspectiveOpen()).isTrue();
	}

	@Test
	public void javaProjectIsCreated() {
		assertThat(eclipse.projectExists(JAVA_PROJECT_NAME)).isTrue();
	}

	@Test
	public void javaClassIsCreated() {
		assertThat(eclipse
				.classExists(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME))
				.isTrue();
	}

	@Test
	public void textFileIsCreated() {
		assertThat(eclipse
				.fileExists(
						JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME_WITH_EXTENSION))
				.isTrue();
	}
}