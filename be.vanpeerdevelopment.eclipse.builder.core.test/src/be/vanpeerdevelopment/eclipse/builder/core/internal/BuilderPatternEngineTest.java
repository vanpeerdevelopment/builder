package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine.BUILDER_SUFFIX;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinition.ClassDefinitionBuilder.classDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder.packageDeclaration;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableClassDefinition;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadablePackageFragment;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class BuilderPatternEngineTest extends UnitTest {

	private static final String CLASS_DEFINITION_NAME = "Person";
	private static final String PACKAGE_NAME = "be.vanpeerdevelopment.eclipse.builder";

	@Mock
	private JdtReadModel jdtReadModel;
	@InjectMocks
	private BuilderPatternEngine builderPatternEngine;

	@Mock
	private GenerateBuilderCommand command;
	@Mock
	private IPath packageLocation;
	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private ReadablePackageFragment packageFragment;
	@Mock
	private ReadableCompilationUnit compilationUnit;
	@Mock
	private ReadableClassDefinition classDefinition;

	@Before
	public void setup() {
		when(command.getDestinationPackageLocation()).thenReturn(packageLocation);
		when(command.getSourceCompilationUnitLocation()).thenReturn(compilationUnitLocation);
		when(jdtReadModel.getPackageFragment(packageLocation)).thenReturn(packageFragment);
		when(packageFragment.getName()).thenReturn(PACKAGE_NAME);
		when(jdtReadModel.getCompilationUnit(compilationUnitLocation)).thenReturn(compilationUnit);
		when(compilationUnit.getOnlyClassDefinition()).thenReturn(classDefinition);
		when(classDefinition.getSimpleName()).thenReturn(CLASS_DEFINITION_NAME);
	}

	@Test
	public void generateBuilder() {
		CreateCompilationUnitCommand createCompilationUnitCommand = builderPatternEngine.generateBuilder(command);

		assertThat(createCompilationUnitCommand).isEqualTo(createCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.withCompilationUnit(compilationUnit()
						.withName(CLASS_DEFINITION_NAME + BUILDER_SUFFIX)
						.withPackageDeclaration(packageDeclaration()
								.withName(PACKAGE_NAME)
								.build())
						.withClassDefinition(classDefinition()
								.withName(CLASS_DEFINITION_NAME + BUILDER_SUFFIX)
								.build())
						.build())
				.build());
	}
}