package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM;
import static org.eclipse.jdt.core.JavaCore.COMPILER_COMPLIANCE;
import static org.eclipse.jdt.core.JavaCore.COMPILER_SOURCE;
import static org.eclipse.jdt.core.JavaCore.VERSION_1_7;
import static org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants.getEclipseDefaultSettings;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;

import java.util.Map;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class FormatterOptionsFactoryIntegrationTest extends EclipseTest {

	private FormatterOptionsFactory formatterOptionsFactory;
	private IJavaProject project;

	@Before
	public void setup() {
		formatterOptionsFactory = new FormatterOptionsFactory();
		Workspace workspace = new Workspace();
		ReadableCompilationUnit readableCompilationUnit = workspace.getReadableCompilationUnit(javaClassLocation());
		project = getICompilationUnit(readableCompilationUnit).getJavaProject();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void createFormatterOptions() {
		Map expected = getEclipseDefaultSettings();
		expected.put(COMPILER_CODEGEN_TARGET_PLATFORM, VERSION_1_7);
		expected.put(COMPILER_SOURCE, VERSION_1_7);
		expected.put(COMPILER_COMPLIANCE, VERSION_1_7);

		Map result = formatterOptionsFactory.createFormatterOptions(project);

		assertThat(result).isEqualTo(expected);
	}

	private ICompilationUnit getICompilationUnit(ReadableCompilationUnit readableCompilationUnit) {
		return field("compilationUnit").ofType(ICompilationUnit.class).in(readableCompilationUnit).get();
	}
}