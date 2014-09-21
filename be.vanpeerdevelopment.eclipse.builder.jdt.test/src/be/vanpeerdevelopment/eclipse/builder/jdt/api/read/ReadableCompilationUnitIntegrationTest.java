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
	private static final String CLASS_WITH_TWO_TYPES = "ClassWithTwoTypes";

	private JdtReadModel jdtReadModel;

	@BeforeClass
	public static void createExtraCompilationUnits() {
		createCompilationUnitWithoutType();
		createCompilationUnitWithTwoTypes();
	}

	@AfterClass
	public static void deleteExtraCompilationUnits() {
		deleteCompilationUnitWithoutType();
		deleteCompilationUnitWithTwoTypes();
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
				.getCompilationUnit(compilationUnitWithoutTypeLocation());

		expectExceptionWithMessage(
				JdtReadException.class,
				"Exception while getting the only type in compilation unit: " + CLASS_WITHOUT_TYPE + ".java."
						+ " No type exists.");
		compilationUnitWithoutType.getOnlyType();
	}

	@Test
	public void getOnlyType_WhenTwoTypes_ThrowsJdtReadException() {
		ReadableCompilationUnit compilationUnitWithTwoTypes = jdtReadModel
				.getCompilationUnit(compilationUnitWithTwoTypesLocation());

		expectExceptionWithMessage(
				JdtReadException.class,
				"Exception while getting the only type in compilation unit: " + CLASS_WITH_TWO_TYPES + ".java."
						+ " More than one type exists.");
		compilationUnitWithTwoTypes.getOnlyType();
	}

	private static void createCompilationUnitWithoutType() {
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

	private static void createCompilationUnitWithTwoTypes() {
		eclipse
				.fileMenu()
				.newSubMenu()
				.other()
				.javaClass()
				.setSourceFolder(JAVA_PROJECT_NAME, JAVA_SOURCE_FOLDER_NAME)
				.setPackage(JAVA_PACKAGE_NAME)
				.setClassName(CLASS_WITH_TWO_TYPES)
				.finish();
		eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						CLASS_WITH_TWO_TYPES)
				.navigateToLine(6)
				.insertText("class SecondClass {}")
				.save();
	}

	private static void deleteCompilationUnitWithoutType() {
		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						CLASS_WITHOUT_TYPE)
				.ok();
	}

	private static void deleteCompilationUnitWithTwoTypes() {
		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						CLASS_WITH_TWO_TYPES)
				.ok();
	}

	private IPath compilationUnitWithoutTypeLocation() {
		return getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(CLASS_WITHOUT_TYPE + ".java");
	}

	private IPath compilationUnitWithTwoTypesLocation() {
		return getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME)
				.append(CLASS_WITH_TWO_TYPES + ".java");
	}
}