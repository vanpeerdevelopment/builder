package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.ICompilationUnit.NO_AST;
import static org.eclipse.jdt.core.formatter.CodeFormatter.K_COMPILATION_UNIT;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.text.edits.TextEdit;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;

public class Formatter {

	private CodeFormatter codeFormatter;

	Formatter(CodeFormatter codeFormatter) {
		this.codeFormatter = codeFormatter;
	}

	public void format(ICompilationUnit compilationUnit) {
		try {
			ICompilationUnit workingCopy = compilationUnit.getWorkingCopy(null);
			String source = workingCopy.getSource();
			TextEdit formatEdit = codeFormatter
					.format(
							K_COMPILATION_UNIT,
							source,
							0,
							source.length(),
							0,
							System.getProperty("line.separator"));
			workingCopy.applyTextEdit(formatEdit, null);
			workingCopy.reconcile(NO_AST, false, null, null);
			workingCopy.commitWorkingCopy(false, null);
			workingCopy.discardWorkingCopy();
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while formatting the following compilation unit: " +
							compilationUnit.getElementName(), e);
		}
	}
}