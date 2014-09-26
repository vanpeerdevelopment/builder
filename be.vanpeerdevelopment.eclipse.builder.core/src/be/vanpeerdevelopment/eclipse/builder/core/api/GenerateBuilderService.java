package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderLocator;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class GenerateBuilderService {

	private BuilderLocator builderLocator;
	private BuilderPatternEngine builderPatternEngine;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderService() {
		builderLocator = new BuilderLocator();
		this.builderPatternEngine = new BuilderPatternEngine();
		this.jdtWriteModel = new JdtWriteModel();
	}

	public IPath generateBuilder(GenerateBuilderCommand command) {
		CreateCompilationUnitCommand createCompilationUnitCommand = builderPatternEngine.generateBuilder(command);
		jdtWriteModel.createCompilationUnit(createCompilationUnitCommand);
		return builderLocator.getBuilderLocation(
				command.getDestinationPackageLocation(),
				command.getSourceCompilationUnitLocation());
	}
}