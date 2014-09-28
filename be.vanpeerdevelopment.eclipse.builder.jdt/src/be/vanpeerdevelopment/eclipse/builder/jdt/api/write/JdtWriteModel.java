package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import org.eclipse.jdt.core.ICompilationUnit;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format.FormatterFactory;

public class JdtWriteModel {

	private Workspace workspace;
	private FormatterFactory formatterFactory;

	public JdtWriteModel() {
		workspace = new Workspace();
		formatterFactory = new FormatterFactory();
	}

	public void createCompilationUnit(CreateCompilationUnitCommand command) {
		ICompilationUnit createdCompilationUnit = workspace
				.getWriteablePackageFragment(command.getPackageLocation())
				.createCompilationUnit(command.getCompilationUnit());
		formatterFactory
				.createNewCompilationUnitFormatter(createdCompilationUnit.getJavaProject())
				.format(createdCompilationUnit);
	}
}