package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommand;

public class GenerateBuilderService {

	private BuilderPatternEngine builderPatternEngine;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderService() {
		this.builderPatternEngine = new BuilderPatternEngine();
		this.jdtWriteModel = new JdtWriteModel();
	}

	public void generateBuilder(IPath compilationUnitLocation) {
		CreateCompilationUnitCommand command = builderPatternEngine.generateBuilder(compilationUnitLocation);
		jdtWriteModel.createCompilationUnit(command);
	}
}