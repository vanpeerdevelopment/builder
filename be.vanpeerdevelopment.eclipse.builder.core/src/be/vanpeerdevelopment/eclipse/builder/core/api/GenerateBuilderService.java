package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class GenerateBuilderService {

	private BuilderPatternEngine builderPatternEngine;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderService() {
		this.builderPatternEngine = new BuilderPatternEngine();
		this.jdtWriteModel = new JdtWriteModel();
	}

	public IPath generateBuilder(GenerateBuilderCommand command) {
		CreateCompilationUnitCommand createCompilationUnitCommand = builderPatternEngine.generateBuilder(command);
		ReadableCompilationUnit createdBuilder = jdtWriteModel.createCompilationUnit(createCompilationUnitCommand);
		return createdBuilder.getPath();
	}
}