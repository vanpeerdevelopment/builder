package be.vanpeerdevelopment.eclipse.builder.jdt.write.internal;

import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

import be.vanpeerdevelopment.eclipse.builder.jdt.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteablePackageFragment;

public class JdtWriteModelImpl implements JdtWriteModel {

	private Workspace workspace;

	public JdtWriteModelImpl() {
		workspace = new Workspace();
	}

	@Override
	public WriteablePackageFragment getPackage(IPath compilationUnitLocation) {
		IFile file = workspace.getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = createCompilationUnitFrom(file);
		IPackageFragment packageFragment = (IPackageFragment) compilationUnit.getParent();
		return new WriteablePackageFragmentAdapter(packageFragment);
	}
}