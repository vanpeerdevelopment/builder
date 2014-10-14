package be.vanpeerdevelopment.eclipse.builder.jdt.api.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format.Formatter;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format.FormatterFactory;

public class JdtWriteModelTest extends UnitTest {

	@Mock
	private Workspace workspace;
	@Mock
	private FormatterFactory formatterFactory;
	@InjectMocks
	private JdtWriteModel jdtWriteModel;

	@Mock
	private IPath packageLocation;
	@Mock
	private CompilationUnit compilationUnit;
	@Mock
	private WriteablePackageFragment writeablePackageFragment;
	@Mock
	private ICompilationUnit createdCompilationUnit;
	@Mock
	private IJavaProject javaProject;
	@Mock
	private Formatter formatter;

	@Before
	public void setup() {
		when(workspace.getWriteablePackageFragment(packageLocation)).thenReturn(writeablePackageFragment);
		when(writeablePackageFragment.createCompilationUnit(compilationUnit)).thenReturn(createdCompilationUnit);
		when(createdCompilationUnit.getJavaProject()).thenReturn(javaProject);
		when(formatterFactory.createNewCompilationUnitFormatter(javaProject)).thenReturn(formatter);
		when(compilationUnit.isInPackage(packageLocation)).thenReturn(true);
	}

	@Test
	public void createCompilationUnit() {
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.withCompilationUnit(compilationUnit)
				.build();

		jdtWriteModel.createCompilationUnit(command);

		verify(writeablePackageFragment).createCompilationUnit(compilationUnit);
		verify(formatter).format(createdCompilationUnit);
	}
}