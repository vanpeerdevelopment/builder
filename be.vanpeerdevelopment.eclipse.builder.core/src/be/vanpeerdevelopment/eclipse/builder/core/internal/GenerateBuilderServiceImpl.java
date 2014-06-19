package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory.createJdtReadModel;
import static be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModelFactory.createJdtWriteModel;
import static be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit.WriteableCompilationUnitBuilder.writeableCompilationUnit;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;

public class GenerateBuilderServiceImpl implements GenerateBuilderService {

	private JdtReadModel jdtReadModel;
	private JdtWriteModel jdtWriteModel;

	public GenerateBuilderServiceImpl() {
		jdtReadModel = createJdtReadModel();
		jdtWriteModel = createJdtWriteModel();
	}

	@Override
	public void generateBuilder(IPath compilationUnitLocation) {
		jdtWriteModel
				.getPackage(compilationUnitLocation)
				.createCompilationUnit(writeableCompilationUnit()
						.withName(getJavaClassName(compilationUnitLocation) + "Builder")
						.build());
	}

	private String getJavaClassName(IPath compilationUnitLocation) {
		return jdtReadModel
				.getCompilationUnit(compilationUnitLocation)
				.getOnlyType()
				.getSimpleName();
	}
}