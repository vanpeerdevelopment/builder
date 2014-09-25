package be.vanpeerdevelopment.eclipse.builder.jdt.element;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.core.resources.IResource;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public class ICompilationUnitTestBuilder {

	public static final String COMPILATION_UNIT_NAME = "CompilationUnitName";

	private ICompilationUnit compilationUnit;

	private ICompilationUnitTestBuilder() {
		compilationUnit = mock(ICompilationUnit.class);
	}

	public static ICompilationUnitTestBuilder anICompilationUnit() {
		return new ICompilationUnitTestBuilder();
	}

	public ICompilationUnit build() {
		return compilationUnit;
	}

	public ICompilationUnitTestBuilder withName(String name) {
		when(compilationUnit.getElementName()).thenReturn(name);
		return this;
	}

	public ICompilationUnitTestBuilder withResource(IResource resource) {
		when(compilationUnit.getResource()).thenReturn(resource);
		return this;
	}

	public ICompilationUnitTestBuilder withTypes(IType... types) {
		try {
			when(compilationUnit.getTypes()).thenReturn(types);
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public ICompilationUnitTestBuilder withoutTypes() {
		return withTypes();
	}

	public ICompilationUnitTestBuilder withFailingGetTypes() {
		try {
			when(compilationUnit.getTypes()).thenThrow(new JavaModelException(new IllegalArgumentException(), 1));
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		return this;
	}
}