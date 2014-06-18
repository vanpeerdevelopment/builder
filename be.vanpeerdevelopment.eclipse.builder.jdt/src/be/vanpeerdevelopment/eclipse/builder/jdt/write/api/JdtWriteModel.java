package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import org.eclipse.core.runtime.IPath;

public interface JdtWriteModel {

	WriteablePackageFragment getPackage(IPath compilationUnitLocation);
}