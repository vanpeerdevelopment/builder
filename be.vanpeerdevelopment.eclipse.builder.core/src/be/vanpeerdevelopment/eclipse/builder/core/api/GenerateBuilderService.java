package be.vanpeerdevelopment.eclipse.builder.core.api;

import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class GenerateBuilderService {

	private BuilderPatternEngine builderPatternEngine;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderService() {
		this.builderPatternEngine = new BuilderPatternEngine();
		this.jdtWriteModel = new JdtWriteModel();
	}

	public void generateBuilder(GenerateBuilderCommand command) {
		CreateCompilationUnitCommand createCompilationUnitCommand = builderPatternEngine.generateBuilder(command);
		jdtWriteModel.createCompilationUnit(createCompilationUnitCommand);
	}
}