package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class WriteablePackageFragmentIntegrationTest extends EclipseTest {

	private static final String COMPILATION_UNIT_NAME = JAVA_CLASS_NAME + "Builder";

	private WriteablePackageFragment writeablePackageFragment;

	@Before
	public void setup() {
		Workspace workspace = new Workspace();
		writeablePackageFragment = workspace.getPackage(
				getWorkspace()
						.getRoot()
						.getLocation()
						.append(JAVA_PROJECT_NAME)
						.append(JAVA_SOURCE_FOLDER_NAME)
						.append(JAVA_PACKAGE_NAME));
	}

	@Test
	public void createCompilationUnit_WillCreateNewCompilationUnit() {
		writeablePackageFragment
				.createCompilationUnit(aCreateCompilationUnitCommand()
						.withName(COMPILATION_UNIT_NAME)
						.build());

		assertThat(eclipse
				.willClassBeCreated(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME))
				.isTrue();

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.ok();
	}

	@Test
	public void createCompilationUnit_HasCorrectContent() {
		writeablePackageFragment
				.createCompilationUnit(aCreateCompilationUnitCommand()
						.withName(COMPILATION_UNIT_NAME)
						.build());

		assertThat(eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.getText())
				.isEqualTo("package " + JAVA_PACKAGE_NAME + ";");

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.ok();
	}

	@Test
	public void createCompilationUnit_ReturnsPathToNewCompilationUnit() {
		ReadableCompilationUnit readableCompilationUnit = writeablePackageFragment
				.createCompilationUnit(aCreateCompilationUnitCommand()
						.withName(COMPILATION_UNIT_NAME)
						.build());

		assertThat(getProject(readableCompilationUnit.getPath())).isEqualTo(JAVA_PROJECT_NAME);
		assertThat(getSourceFolder(readableCompilationUnit.getPath())).isEqualTo(JAVA_SOURCE_FOLDER_NAME);
		assertThat(getPackage(readableCompilationUnit.getPath())).isEqualTo(JAVA_PACKAGE_NAME);
		assertThat(getClass(readableCompilationUnit.getPath())).isEqualTo(COMPILATION_UNIT_NAME + ".java");

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.ok();
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