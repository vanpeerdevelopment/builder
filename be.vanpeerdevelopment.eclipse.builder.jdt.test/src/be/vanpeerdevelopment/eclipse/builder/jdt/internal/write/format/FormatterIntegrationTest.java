package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinitionTestBuilder.aClassDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder.packageDeclaration;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;

import org.eclipse.jdt.core.ICompilationUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class FormatterIntegrationTest extends EclipseTest {

	private static final String UNFORMATTED_COMPILATION_UNIT_NAME = JAVA_CLASS_NAME + "Builder";
	private Formatter formatter;
	private ICompilationUnit compilationUnit;

	@Before
	public void setup() {
		createUnformattedCompilationUnit();
		openUnformattedCompilationUnit();

		Workspace workspace = new Workspace();
		ReadableCompilationUnit readableCompilationUnit = workspace.getReadableCompilationUnit(packageLocation()
				.append(UNFORMATTED_COMPILATION_UNIT_NAME + ".java"));
		compilationUnit = getICompilationUnit(readableCompilationUnit);
		FormatterFactory formatterFactory = new FormatterFactory();
		formatter = formatterFactory.createNewCompilationUnitFormatter(compilationUnit.getJavaProject());
	}

	@After
	public void tearDown() {
		deleteUnformattedCompilationUnit();
	}

	@Test
	public void format() throws Exception {
		assertThat(compilationUnit.getSource()).isEqualTo(new StringBuilder()
				.append("package " + JAVA_PACKAGE_NAME + ";")
				.append("\n")
				.append("public class " + UNFORMATTED_COMPILATION_UNIT_NAME + "{}")
				.toString());

		formatter.format(compilationUnit);

		assertThat(compilationUnit.getSource()).isEqualTo(new StringBuilder()
				.append("package " + JAVA_PACKAGE_NAME + ";")
				.append(lineSeparator())
				.append(lineSeparator())
				.append("public class " + UNFORMATTED_COMPILATION_UNIT_NAME + " {")
				.append(lineSeparator())
				.append("}")
				.toString());
	}

	private String lineSeparator() {
		return System.getProperty("line.separator");
	}

	private void createUnformattedCompilationUnit() {
		Workspace workspace = new Workspace();
		WriteablePackageFragment writeablePackageFragment = workspace.getWriteablePackageFragment(packageLocation());
		writeablePackageFragment.createCompilationUnit(compilationUnit()
				.withName(UNFORMATTED_COMPILATION_UNIT_NAME)
				.withPackageDeclaration(packageDeclaration()
						.withName(JAVA_PACKAGE_NAME)
						.build())
				.withClassDefinition(aClassDefinition()
						.withName(UNFORMATTED_COMPILATION_UNIT_NAME)
						.build())
				.build());
	}

	private void openUnformattedCompilationUnit() {
		eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						UNFORMATTED_COMPILATION_UNIT_NAME);
	}

	private ICompilationUnit getICompilationUnit(ReadableCompilationUnit readableCompilationUnit) {
		return field("compilationUnit").ofType(ICompilationUnit.class).in(readableCompilationUnit).get();
	}

	private void deleteUnformattedCompilationUnit() {
		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						UNFORMATTED_COMPILATION_UNIT_NAME)
				.ok();
	}
}