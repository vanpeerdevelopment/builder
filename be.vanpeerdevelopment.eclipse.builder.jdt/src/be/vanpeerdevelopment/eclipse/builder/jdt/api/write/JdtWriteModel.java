package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import org.eclipse.jdt.core.IPackageFragment;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class JdtWriteModel {

	private Workspace workspace;

	public JdtWriteModel() {
		workspace = new Workspace();
	}

	public void createCompilationUnit(CreateCompilationUnitCommand command) {
		IPackageFragment packageFragment = workspace.getPackage(command.getPackageLocation());
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);
		writeablePackageFragment.createCompilationUnit(command);
	}
}