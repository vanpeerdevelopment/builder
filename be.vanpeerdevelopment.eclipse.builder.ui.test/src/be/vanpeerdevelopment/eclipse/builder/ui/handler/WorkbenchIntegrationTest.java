package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Executable;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Function;
import be.vanpeerdevelopment.eclipse.builder.ui.EclipseTest;

public class WorkbenchIntegrationTest extends EclipseTest {

	private Workbench workbench;

	@Before
	public void setup() {
		workbench = new Workbench();
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.close();
	}

	@Test
	public void getActiveCompilationUnitLocation() {
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME);

		IPath location = eclipse.runInUiThread(new Function<IPath>() {
			@Override
			public IPath execute() {
				return workbench.getActiveCompilationUnitLocation();
			}
		});

		assertThat(getProject(location)).isEqualTo(JAVA_PROJECT_NAME);
		assertThat(getSourceFolder(location)).isEqualTo(JAVA_SOURCE_FOLDER_NAME);
		assertThat(getPackage(location)).isEqualTo(JAVA_PACKAGE_NAME);
		assertThat(getClass(location)).isEqualTo(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void openCompilationUnit() {
		final IPath compilationUnitLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(JAVA_CLASS_NAME + ".java");

		eclipse.runInUiThread(new Executable() {
			@Override
			public void execute() {
				workbench.openCompilationUnit(compilationUnitLocation);
			}
		});

		assertThat(eclipse.willEditorBeOpened(JAVA_CLASS_NAME + ".java")).isTrue();
		assertThat(eclipse.isEditorActive(JAVA_CLASS_NAME + ".java")).isTrue();
	}

	private String getProject(IPath location) {
		return location.removeLastSegments(3).lastSegment();
	}

	private String getSourceFolder(IPath location) {
		return location.removeLastSegments(2).lastSegment();
	}

	private String getPackage(IPath location) {
		return location.removeLastSegments(1).lastSegment();
	}

	private String getClass(IPath location) {
		return location.lastSegment();
	}
}