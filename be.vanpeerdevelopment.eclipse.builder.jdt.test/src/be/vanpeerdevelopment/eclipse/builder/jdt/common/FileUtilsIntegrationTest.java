package be.vanpeerdevelopment.eclipse.builder.jdt.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class FileUtilsIntegrationTest extends EclipseTest {

	@Test
	public void getFile() throws Exception {
		IPath javaClassLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(JAVA_CLASS_NAME + ".java");

		IFile file = FileUtils.getFile(javaClassLocation);

		assertThat(file.getName()).isEqualTo(JAVA_CLASS_NAME + ".java");
	}
}