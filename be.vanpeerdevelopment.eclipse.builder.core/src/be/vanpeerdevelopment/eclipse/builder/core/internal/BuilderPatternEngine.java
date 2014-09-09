package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit.WriteableCompilationUnitBuilder.writeableCompilationUnit;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit;

public class BuilderPatternEngine {

	private JdtReadModel jdtReadModel;

	public BuilderPatternEngine() {
		this.jdtReadModel = new JdtReadModelFactory().createJdtReadModel();
	}

	public WriteableCompilationUnit generateBuilder(IPath compilationUnitLocation) {
		return writeableCompilationUnit()
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