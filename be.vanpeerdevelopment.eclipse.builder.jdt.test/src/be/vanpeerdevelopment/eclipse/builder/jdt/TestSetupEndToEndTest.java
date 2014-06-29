package be.vanpeerdevelopment.eclipse.builder.jdt;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

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
}