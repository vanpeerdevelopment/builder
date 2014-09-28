package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM;
import static org.eclipse.jdt.core.JavaCore.COMPILER_COMPLIANCE;
import static org.eclipse.jdt.core.JavaCore.COMPILER_SOURCE;
import static org.eclipse.jdt.core.JavaCore.VERSION_1_5;
import static org.eclipse.jdt.core.JavaCore.VERSION_1_6;
import static org.eclipse.jdt.core.JavaCore.VERSION_1_7;
import static org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants.getEclipseDefaultSettings;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format.FormatterOptionsFactory;

public class FormatterOptionsFactoryTest extends UnitTest {

	private FormatterOptionsFactory formatterOptionsFactory;
	@Mock
	private IJavaProject project;

	@Before
	public void setup() {
		formatterOptionsFactory = new FormatterOptionsFactory();
		when(project.getOption(COMPILER_CODEGEN_TARGET_PLATFORM, true)).thenReturn(VERSION_1_7);
		when(project.getOption(COMPILER_SOURCE, true)).thenReturn(VERSION_1_6);
		when(project.getOption(COMPILER_COMPLIANCE, true)).thenReturn(VERSION_1_5);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getFormatterOptions() {
		Map expected = getEclipseDefaultSettings();
		expected.put(COMPILER_CODEGEN_TARGET_PLATFORM, VERSION_1_7);
		expected.put(COMPILER_SOURCE, VERSION_1_6);
		expected.put(COMPILER_COMPLIANCE, VERSION_1_5);

		Map result = formatterOptionsFactory.getFormatterOptions(project);

		assertThat(result).isEqualTo(expected);
	}
}