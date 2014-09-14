package be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class CreateCompilationUnitCommandTest extends UnitTest {

	@Test
	public void getSiblingCompilationUnitLocation() {
		IPath siblingCompilationUnitLocation = mock(IPath.class);
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withSiblingCompilationUnitLocation(siblingCompilationUnitLocation)
				.build();

		assertThat(command.getSiblingCompilationUnitLocation()).isEqualTo(siblingCompilationUnitLocation);
	}

	@Test
	public void getName() {
		String name = "Person";
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withName(name)
				.build();

		assertThat(command.getName()).isEqualTo(name);
	}

	@Test
	public void getNameWithExtension() {
		String name = "Person";
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withName(name)
				.build();

		assertThat(command.getNameWithExtension()).isEqualTo(name + ".java");
	}
}