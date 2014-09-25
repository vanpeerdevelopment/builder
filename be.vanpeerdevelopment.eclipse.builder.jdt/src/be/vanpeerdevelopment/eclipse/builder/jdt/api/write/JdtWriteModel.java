package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class JdtWriteModel {

	private Workspace workspace;

	public JdtWriteModel() {
		workspace = new Workspace();
	}

	public void createCompilationUnit(CreateCompilationUnitCommand command) {
		WriteablePackageFragment writeablePackageFragment = workspace.getPackage(command.getPackageLocation());
		writeablePackageFragment.createCompilationUnit(command);
	}
}