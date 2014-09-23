package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class JdtWriteModelTest extends UnitTest {

	@Mock
	private Workspace workspace;
	@InjectMocks
	private JdtWriteModel jdtWriteModel;

	@Mock
	private IPath packageLocation;
	@Mock
	private WriteablePackageFragment writeablePackageFragment;
	@Mock
	private ReadableCompilationUnit readableCompilationUnit;

	@Test
	public void createCompilationUnit() {
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.build();
		when(workspace.getPackage(packageLocation)).thenReturn(writeablePackageFragment);
		when(writeablePackageFragment.createCompilationUnit(command)).thenReturn(readableCompilationUnit);

		ReadableCompilationUnit result = jdtWriteModel.createCompilationUnit(command);

		assertThat(result).isEqualTo(readableCompilationUnit);
	}
}