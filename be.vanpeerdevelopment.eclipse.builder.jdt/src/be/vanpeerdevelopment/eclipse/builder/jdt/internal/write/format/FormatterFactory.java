package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.ToolFactory.M_FORMAT_NEW;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;

public class FormatterFactory {

	private FormatterOptionsFactory formatterOptionsFactory;
	private CodeFormatterFactory codeFormatterFactory;

	public FormatterFactory() {
		formatterOptionsFactory = new FormatterOptionsFactory();
		codeFormatterFactory = new CodeFormatterFactory();
	}

	@SuppressWarnings("rawtypes")
	public Formatter createNewCompilationUnitFormatter(IJavaProject project) {
		Map options = formatterOptionsFactory.createFormatterOptions(project);
		CodeFormatter codeFormatter = codeFormatterFactory.createCodeFormatter(options, M_FORMAT_NEW);
		return new Formatter(codeFormatter);
	}

	public static class CodeFormatterFactory {

		CodeFormatterFactory() {
		}

		@SuppressWarnings("rawtypes")
		public CodeFormatter createCodeFormatter(Map options, int mode) {
			return ToolFactory.createCodeFormatter(options, mode);
		}
	}
}