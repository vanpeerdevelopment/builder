package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine.BUILDER_SUFFIX;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableType;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class BuilderPatternEngineTest extends UnitTest {

	private static final String TYPE_NAME = "Person";

	@Mock
	private JdtReadModel jdtReadModel;
	@InjectMocks
	private BuilderPatternEngine builderPatternEngine;

	@Mock
	private GenerateBuilderCommand command;
	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private IPath packageLocation;
	@Mock
	private ReadableCompilationUnit compilationUnit;
	@Mock
	private ReadableType type;

	@Test
	public void generateBuilder() {
		when(command.getSourceCompilationUnitLocation()).thenReturn(compilationUnitLocation);
		when(command.getDestinationPackageLocation()).thenReturn(packageLocation);
		when(jdtReadModel.getCompilationUnit(compilationUnitLocation)).thenReturn(compilationUnit);
		when(compilationUnit.getOnlyType()).thenReturn(type);
		when(type.getSimpleName()).thenReturn(TYPE_NAME);

		CreateCompilationUnitCommand createCompilationUnitCommand = builderPatternEngine.generateBuilder(command);

		assertThat(createCompilationUnitCommand).isEqualTo(createCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.withCompilationUnit(compilationUnit()
						.withName(TYPE_NAME + BUILDER_SUFFIX)
						.build())
				.build());
	}
}