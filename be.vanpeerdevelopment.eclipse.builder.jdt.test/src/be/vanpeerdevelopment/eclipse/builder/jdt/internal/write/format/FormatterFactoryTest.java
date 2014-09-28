package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.ToolFactory.M_FORMAT_NEW;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format.FormatterFactory.CodeFormatterFactory;

public class FormatterFactoryTest extends UnitTest {

	@Mock
	private FormatterOptionsFactory formatterOptionsFactory;
	@Mock
	private CodeFormatterFactory codeFormatterFactory;
	@InjectMocks
	private FormatterFactory formatterFactory;

	@Mock
	private IJavaProject project;
	@SuppressWarnings("rawtypes")
	@Mock
	private Map options;
	@Mock
	private CodeFormatter codeFormatter;

	@Before
	public void setup() {
		when(formatterOptionsFactory.createFormatterOptions(project)).thenReturn(options);
		when(codeFormatterFactory.createCodeFormatter(options, M_FORMAT_NEW)).thenReturn(codeFormatter);
	}

	@Test
		public void createNewCompilationUnitFormatter() {
			Formatter result = formatterFactory.createNewCompilationUnitFormatter(project);
	
			assertThat(getCodeFormatter(result)).isEqualTo(codeFormatter);
		}

	private CodeFormatter getCodeFormatter(Formatter formatter) {
		return field("codeFormatter").ofType(CodeFormatter.class).in(formatter).get();
	}
}