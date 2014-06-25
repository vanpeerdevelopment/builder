package be.vanpeerdevelopment.eclipse.builder.core.internal;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit;

public class GenerateBuilderServiceImpl implements GenerateBuilderService {

	private BuilderPatternEngine builderPatternEngine;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderServiceImpl(BuilderPatternEngine builderPatternEngine,
			JdtWriteModel jdtWriteModel) {
		this.builderPatternEngine = builderPatternEngine;
		this.jdtWriteModel = jdtWriteModel;
	}

	@Override
	public void generateBuilder(IPath compilationUnitLocation) {
		WriteableCompilationUnit builder = builderPatternEngine
				.generateBuilder(compilationUnitLocation);
		jdtWriteModel
				.getPackage(compilationUnitLocation)
				.createCompilationUnit(builder);
	}
}