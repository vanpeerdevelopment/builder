package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public class ReadableCompilationUnit {

	private ICompilationUnit compilationUnit;

	ReadableCompilationUnit(ICompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}

	public ReadableType getOnlyType() {
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

	private List<ReadableType> getTypes() {
		try {
			return getTypesIgnoringException();
		} catch (JavaModelException e) {
			throw new JdtReadException(
					"Something went wrong while getting the types in the following compilation unit: "
							+ getName(), e);
		}
	}

	private List<ReadableType> getTypesIgnoringException() throws JavaModelException {
		List<ReadableType> result = new ArrayList<ReadableType>();
		for (IType type : compilationUnit.getTypes()) {
			result.add(new ReadableType(type));
		}
		return result;
	}

	private String getName() {
		return compilationUnit.getElementName();
	}
}