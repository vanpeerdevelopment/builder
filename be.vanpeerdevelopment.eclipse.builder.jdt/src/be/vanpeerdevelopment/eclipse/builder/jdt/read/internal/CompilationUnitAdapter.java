package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadException;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtType;

public class CompilationUnitAdapter implements JdtCompilationUnit {

	private ICompilationUnit compilationUnit;

	public CompilationUnitAdapter(ICompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}

	@Override
	public JdtType getOnlyType() {
		validateExactlyOneTypeExists();
		return getTypes().get(0);
	}

	private void validateExactlyOneTypeExists() {
		validateAtLeastOneTypeExists();
		validateAtMostOneTypeExists();
	}

	private void validateAtLeastOneTypeExists() {
		if (getTypes().size() < 1)
			throw new JdtReadException(
					"Exception while getting the only type in compilation unit: "
							+ getName() + ". No type exists.");
	}

	private void validateAtMostOneTypeExists() {
		if (getTypes().size() > 1)
			throw new JdtReadException(
					"Exception while getting the only type in compilation unit: "
							+ getName() + ". More than one type exists.");
	}

	private List<JdtType> getTypes() {
		try {
			return getTypesIgnoringException();
		} catch (JavaModelException e) {
			throw new JdtReadException(
					"Something went wrong while getting the types in the following compilation unit: "
							+ getName(), e);
		}
	}

	private List<JdtType> getTypesIgnoringException() throws JavaModelException {
		List<JdtType> result = new ArrayList<JdtType>();
		for (IType type : compilationUnit.getTypes()) {
			result.add(new TypeAdapter(type));
		}
		return result;
	}

	private String getName() {
		return compilationUnit.getElementName();
	}
}