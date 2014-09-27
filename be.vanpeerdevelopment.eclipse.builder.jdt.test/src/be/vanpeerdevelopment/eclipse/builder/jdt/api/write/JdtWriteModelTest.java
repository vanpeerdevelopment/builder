package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class JdtWriteModelTest extends UnitTest {

	@Mock
	private Workspace workspace;
	@InjectMocks
	private JdtWriteModel jdtWriteModel;

	@Mock
	private CompilationUnit compilationUnit;
	@Mock
	private IPath packageLocation;
	@Mock
	private WriteablePackageFragment writeablePackageFragment;

	@Test
	public void createCompilationUnit() {
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.withCompilationUnit(compilationUnit)
				.build();
		when(workspace.getPackage(packageLocation)).thenReturn(writeablePackageFragment);

		jdtWriteModel.createCompilationUnit(command);

		verify(writeablePackageFragment).createCompilationUnit(compilationUnit);
	}
}