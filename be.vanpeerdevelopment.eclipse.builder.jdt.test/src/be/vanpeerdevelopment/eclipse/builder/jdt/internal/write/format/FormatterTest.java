package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.ICompilationUnit.NO_AST;
import static org.eclipse.jdt.core.formatter.CodeFormatter.K_COMPILATION_UNIT;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.text.edits.TextEdit;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class FormatterTest extends UnitTest {

	private static final String SOURCE_CODE = "source code";

	@Mock
	private CodeFormatter codeFormatter;
	private Formatter formatter;

	@Mock
	private ICompilationUnit compilationUnit;
	@Mock
	private ICompilationUnit workingCopy;
	@Mock
	private TextEdit formatTextEdit;

	@Before
	public void setup() throws JavaModelException {
		formatter = new Formatter(codeFormatter);
		when(compilationUnit.getWorkingCopy(null)).thenReturn(workingCopy);
		when(workingCopy.getSource()).thenReturn(SOURCE_CODE);
		when(codeFormatter
				.format(
						K_COMPILATION_UNIT,
						SOURCE_CODE,
						0,
						SOURCE_CODE.length(),
						0,
						System.getProperty("line.separator")))
				.thenReturn(formatTextEdit);
	}

	@Test
	public void format() throws JavaModelException {
		formatter.format(compilationUnit);

		verify(workingCopy).applyTextEdit(formatTextEdit, null);
		verify(workingCopy).reconcile(NO_AST, false, null, null);
		verify(workingCopy).commitWorkingCopy(false, null);
		verify(workingCopy).discardWorkingCopy();
	}
}