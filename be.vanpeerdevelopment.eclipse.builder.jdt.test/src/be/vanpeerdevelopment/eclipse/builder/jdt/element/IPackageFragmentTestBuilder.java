package be.vanpeerdevelopment.eclipse.builder.jdt.element;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

public class IPackageFragmentTestBuilder {

	public static final String PACKAGE_NAME = "be.vanpeerdevelopment.eclipse.builder";

	private IPackageFragment packageFragment;

	private IPackageFragmentTestBuilder() {
		packageFragment = mock(IPackageFragment.class);
	}

	public static IPackageFragmentTestBuilder anIPackageFragment() {
		return new IPackageFragmentTestBuilder();
	}

	public IPackageFragment build() {
		return packageFragment;
	}

	public IPackageFragmentTestBuilder withName(String packageName) {
		when(packageFragment.getElementName()).thenReturn(packageName);
		return this;
	}

	public IPackageFragmentTestBuilder withFailingCreateCompilationUnit() {
		try {
			when(packageFragment.createCompilationUnit(
					anyString(),
					anyString(),
					anyBoolean(),
					any(IProgressMonitor.class)))
					.thenThrow(new JavaModelException(new IllegalArgumentException(), 1));
		} catch (JavaModelException e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	public IPackageFragmentTestBuilder withCompilationUnitToCreate(ICompilationUnit compilationUnit)
			throws JavaModelException {
		when(packageFragment.createCompilationUnit(
				anyString(),
				anyString(),
				anyBoolean(),
				any(IProgressMonitor.class)))
				.thenReturn(compilationUnit);
		return this;
	}
}