package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public class ReadableCompilationUnit {

	private ICompilationUnit compilationUnit;

	public ReadableCompilationUnit(ICompilationUnit compilationUnit) {
		this.compilationUnit = compilationUnit;
	}

	public String getName() {
		return compilationUnit.getElementName();
	}

	public IPath getPath() {
		return compilationUnit.getResource().getLocation();
	}

	public ReadableClassDefinition getOnlyClassDefinition() {
		validateExactlyOneClassDefinitionExists();
		return getClassDefinitions().get(0);
	}

	private void validateExactlyOneClassDefinitionExists() {
		validateAtLeastOneClassDefinitionExists();
		validateAtMostOneClassDefinitionExists();
	}

	private void validateAtLeastOneClassDefinitionExists() {
		if (getClassDefinitions().size() < 1)
			throw new JdtReadException(
					"Exception while getting the only class definition in compilation unit: "
							+ getName() + ". No class definition exists.");
	}

	private void validateAtMostOneClassDefinitionExists() {
		if (getClassDefinitions().size() > 1)
			throw new JdtReadException(
					"Exception while getting the only class definition in compilation unit: "
							+ getName() + ". More than one class definition exists.");
	}

	private List<ReadableClassDefinition> getClassDefinitions() {
		try {
			return getClassDefinitionsIgnoringException();
		} catch (JavaModelException e) {
			throw new JdtReadException(
					"Something went wrong while getting the class definitions in the following compilation unit: "
							+ getName(), e);
		}
	}

	private List<ReadableClassDefinition> getClassDefinitionsIgnoringException() throws JavaModelException {
		List<ReadableClassDefinition> result = new ArrayList<ReadableClassDefinition>();
		for (IType type : compilationUnit.getTypes()) {
			result.add(new ReadableClassDefinition(type));
		}
		return result;
	}
}