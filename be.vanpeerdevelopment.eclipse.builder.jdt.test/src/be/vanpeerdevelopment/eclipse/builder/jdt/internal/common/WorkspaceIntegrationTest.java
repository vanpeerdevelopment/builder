package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadablePackageFragment;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class WorkspaceIntegrationTest extends EclipseTest {

	private Workspace workspace;

	@Before
	public void setup() {
		workspace = new Workspace();
	}

	@Test
	public void getReadableCompilationUnit() throws Exception {
		IPath compilationUnitLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(JAVA_CLASS_NAME + ".java");

		ReadableCompilationUnit readableCompilationUnit = workspace.getReadableCompilationUnit(compilationUnitLocation);

		assertThat(readableCompilationUnit.getName()).isEqualTo(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void getWriteablePackageFragment() {
		IPath packageLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME);

		WriteablePackageFragment writeablePackageFragment = workspace.getWriteablePackageFragment(packageLocation);

		assertThat(getPackageFragment(writeablePackageFragment).getElementName()).isEqualTo(JAVA_PACKAGE_NAME);
	}

	@Test
	public void getReadablePackageFragment() {
		IPath packageLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME);

		ReadablePackageFragment readablePackageFragment = workspace.getReadablePackageFragment(packageLocation);

		assertThat(getPackageFragment(readablePackageFragment).getElementName()).isEqualTo(JAVA_PACKAGE_NAME);
	}

	private IPackageFragment getPackageFragment(WriteablePackageFragment writeablePackageFragment) {
		return field("packageFragment").ofType(IPackageFragment.class).in(writeablePackageFragment).get();
	}

	private IPackageFragment getPackageFragment(ReadablePackageFragment readablePackageFragment) {
		return field("packageFragment").ofType(IPackageFragment.class).in(readablePackageFragment).get();
	}
}