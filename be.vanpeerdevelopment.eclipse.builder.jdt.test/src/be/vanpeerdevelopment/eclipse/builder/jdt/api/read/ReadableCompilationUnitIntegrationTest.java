package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadableCompilationUnitIntegrationTest extends EclipseTest {

	private static final String CLASS_WITHOUT_TYPE = "ClassWithoutType";

	private JdtReadModel jdtReadModel;

	@BeforeClass
	public static void createExtraCompilationUnits() {
		eclipse
				.fileMenu()
				.newSubMenu()
				.other()
				.javaClass()
				.setSourceFolder(JAVA_PROJECT_NAME, JAVA_SOURCE_FOLDER_NAME)
				.setPackage(JAVA_PACKAGE_NAME)
				.setClassName(CLASS_WITHOUT_TYPE)
				.finish();
		eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						CLASS_WITHOUT_TYPE)
				.deleteLine(3)
				.deleteLine(5)
				.save();
	}

	@AfterClass
	public static void deleteExtraCompilationUnits() {
		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						CLASS_WITHOUT_TYPE)
				.ok();
	}

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
	}

	@Test
	public void getName() {
		ReadableCompilationUnit compilationUnitWithOneType = jdtReadModel.getCompilationUnit(javaClassLocation());
		String name = compilationUnitWithOneType.getName();

		assertThat(name).isEqualTo(JAVA_CLASS_NAME + ".java");
	}

	@Test
	public void getOnlyType() {
		ReadableCompilationUnit compilationUnitWithOneType = jdtReadModel.getCompilationUnit(javaClassLocation());
		ReadableType onlyType = compilationUnitWithOneType.getOnlyType();

		assertThat(onlyType.getSimpleName()).isEqualTo(JAVA_CLASS_NAME);
	}

	@Test
	public void getOnlyType_WhenNoTypes_ThrowsJdtReadException() {
		ReadableCompilationUnit compilationUnitWithoutType = jdtReadModel
				.getCompilationUnit(classWithoutTypeLocation());

		expectExceptionWithMessage(
				JdtReadException.class,
				"Exception while getting the only type in compilation unit: " + CLASS_WITHOUT_TYPE + ".java."
						+ " No type exists.");
		compilationUnitWithoutType.getOnlyType();
	}

	private IPath classWithoutTypeLocation() {
		return getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(CLASS_WITHOUT_TYPE + ".java");
	}
}