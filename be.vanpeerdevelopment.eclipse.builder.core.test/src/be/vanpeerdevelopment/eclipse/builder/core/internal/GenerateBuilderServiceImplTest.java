package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteablePackageFragment;

public class GenerateBuilderServiceImplTest extends UnitTest {

	@Mock
	private BuilderPatternEngine builderPatternEngine;
	@Mock
	private JdtWriteModel jdtWriteModel;
	@InjectMocks
	private GenerateBuilderServiceImpl generateBuilderServiceImpl;

	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private WriteableCompilationUnit builder;
	@Mock
	private WriteablePackageFragment packageFragment;

	@Test
	public void generateBuilder() throws Exception {
		when(builderPatternEngine.generateBuilder(compilationUnitLocation)).thenReturn(builder);
		when(jdtWriteModel.getPackage(compilationUnitLocation)).thenReturn(packageFragment);

		generateBuilderServiceImpl.generateBuilder(compilationUnitLocation);

		verify(packageFragment).createCompilationUnit(builder);
	}
}