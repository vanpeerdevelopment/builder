package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.SWTBotTest;

public class WorkbenchIntegrationTest extends SWTBotTest {

	private Workbench workbench;

	@Before
	public void setup() {
		workbench = new Workbench();
	}

	@Test
	public void getActiveCompilationUnitLocation() {
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME);

		IPath location = syncExec(eclipse.getDisplay(), new Result<IPath>() {
			@Override
			public IPath run() {
				return workbench.getActiveCompilationUnitLocation();
			}
		});

		assertThat(getProject(location)).isEqualTo(JAVA_PROJECT_NAME);
		assertThat(getSourceFolder(location)).isEqualTo(JAVA_SOURCE_FOLDER_NAME);
		assertThat(getPackage(location)).isEqualTo(JAVA_PACKAGE_NAME);
		assertThat(getClass(location)).isEqualTo(JAVA_CLASS_NAME + ".java");
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