package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class BuilderPatternEngine {

	private JdtReadModel jdtReadModel;

	public BuilderPatternEngine() {
		this.jdtReadModel = new JdtReadModel();
	}

	public CreateCompilationUnitCommand generateBuilder(IPath compilationUnitLocation) {
		return createCompilationUnitCommand()
				.withSiblingCompilationUnitLocation(compilationUnitLocation)
				.withName(getJavaClassName(compilationUnitLocation) + "Builder")
				.build();
	}

	private String getJavaClassName(IPath compilationUnitLocation) {
		return jdtReadModel
				.getCompilationUnit(compilationUnitLocation)
				.getOnlyType()
				.getSimpleName();
	}
}