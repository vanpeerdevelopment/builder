package be.vanpeerdevelopment.eclipse.builder.jdt.write.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.common.FileUtils.getFile;
import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteablePackageFragment;

public class JdtWriteModelImpl implements JdtWriteModel {

	@Override
	public WriteablePackageFragment getPackage(IPath compilationUnitLocation) {
		IFile file = getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = createCompilationUnitFrom(file);
		IPackageFragment packageFragment = (IPackageFragment) compilationUnit.getParent();
		return new WriteablePackageFragmentAdapter(packageFragment);
	}
}