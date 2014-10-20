package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinition.ClassDefinitionBuilder.classDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Field.FieldBuilder.field;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder.packageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.Type.TypeBuilder.type;
import static org.apache.commons.lang3.StringUtils.uncapitalize;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class BuilderPatternEngine {

	public static final String BUILDER_SUFFIX = "Builder";

	private JdtReadModel jdtReadModel;

	public BuilderPatternEngine() {
		this.jdtReadModel = new JdtReadModel();
	}

	public CreateCompilationUnitCommand generateBuilder(GenerateBuilderCommand command) {
		return createCompilationUnitCommand()
				.withPackageLocation(command.getDestinationPackageLocation())
				.withCompilationUnit(
						compilationUnit()
								.withName(getBuilderName(command.getSourceCompilationUnitLocation()))
								.withPackageDeclaration(packageDeclaration()
										.withName(getPackageName(command.getDestinationPackageLocation()))
										.build())
								.withClassDefinition(
										classDefinition()
												.withName(getBuilderName(command.getSourceCompilationUnitLocation()))
												.withField(
														field()
																.withType(
																		type()
																				.withName(
																						getJavaClassName(command
																								.getSourceCompilationUnitLocation()))
																				.build())
																.withName(
																		getJavaClassNameAsVariable(command
																				.getSourceCompilationUnitLocation()))
																.build())
												.build())
								.build())
				.build();
	}

	private String getBuilderName(IPath sourceCompilationUnitLocation) {
		return getJavaClassName(sourceCompilationUnitLocation) + BUILDER_SUFFIX;
	}

	private String getJavaClassName(IPath compilationUnitLocation) {
		return jdtReadModel
				.getCompilationUnit(compilationUnitLocation)
				.getOnlyClassDefinition()
				.getSimpleName();
	}

	private String getJavaClassNameAsVariable(IPath compilationUnitLocation) {
		return uncapitalize(getJavaClassName(compilationUnitLocation));
	}

	private String getPackageName(IPath destinationPackageLocation) {
		return jdtReadModel
				.getPackageFragment(destinationPackageLocation)
				.getName();
	}
}