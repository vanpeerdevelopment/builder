package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinitionTestBuilder.aClassDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.FieldTestBuilder.aField;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class WriteablePackageFragmentIntegrationTest extends EclipseTest {

	private static final String COMPILATION_UNIT_NAME = JAVA_CLASS_NAME + "Builder";

	@BeforeClass
	public static void setup() {
		Workspace workspace = new Workspace();
		WriteablePackageFragment writeablePackageFragment = workspace.getWriteablePackageFragment(
				getWorkspace()
						.getRoot()
						.getLocation()
						.append(JAVA_PROJECT_NAME)
						.append(JAVA_SOURCE_FOLDER_NAME)
						.append(JAVA_PACKAGE_NAME));
		writeablePackageFragment
				.createCompilationUnit(aCompilationUnit()
						.withName(COMPILATION_UNIT_NAME)
						.withPackageDeclaration(aPackageDeclaration()
								.withName(JAVA_PACKAGE_NAME)
								.build())
						.withClassDefinition(aClassDefinition()
								.withName(COMPILATION_UNIT_NAME)
								.withField(aField()
										.withType(aType()
												.withName("Person")
												.build())
										.withName("person")
										.build())
								.build())
						.build());
	}

	@AfterClass
	public static void deleteCompilationUnit() {
		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.ok();
	}

	@Test
	public void createCompilationUnit_WillCreateNewCompilationUnit() {
		assertThat(eclipse
				.willClassBeCreated(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME))
				.isTrue();
	}

	@Test
	public void createCompilationUnit_HasCorrectContent() {
		assertThat(eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						COMPILATION_UNIT_NAME)
				.getText())
				.isEqualTo("package " + JAVA_PACKAGE_NAME + ";\n"
						+ "public class " + COMPILATION_UNIT_NAME + "{\n"
						+ "private Person person;\n"
						+ "}");
	}
}