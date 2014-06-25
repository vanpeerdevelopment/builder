package be.vanpeerdevelopment.eclipse.builder.core.api;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.internal.GenerateBuilderServiceImpl;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModelFactory;

public class GenerateBuilderServiceFactoryTest extends UnitTest {

	@Mock
	private JdtReadModelFactory jdtReadModelFactory;
	@Mock
	private JdtWriteModelFactory jdtWriteModelFactory;
	@InjectMocks
	private GenerateBuilderServiceFactory generateBuilderServiceFactory;

	@Mock
	private JdtReadModel jdtReadModel;
	@Mock
	private JdtWriteModel jdtWriteModel;

	@Test
	public void createGenerateBuilderService() throws Exception {
		when(jdtReadModelFactory.createJdtReadModel()).thenReturn(jdtReadModel);
		when(jdtWriteModelFactory.createJdtWriteModel()).thenReturn(jdtWriteModel);

		GenerateBuilderService generateBuilderService = generateBuilderServiceFactory
				.createGenerateBuilderService();

		assertThat(generateBuilderService).isInstanceOf(GenerateBuilderServiceImpl.class);
		assertThat(getJdtReadModel(generateBuilderService)).isEqualTo(jdtReadModel);
		assertThat(getJdtWriteModel(generateBuilderService)).isEqualTo(jdtWriteModel);
	}

	private JdtReadModel getJdtReadModel(GenerateBuilderService generateBuilderService) {
		return field("jdtReadModel").ofType(JdtReadModel.class).in(generateBuilderService).get();
	}

	private JdtWriteModel getJdtWriteModel(GenerateBuilderService generateBuilderService) {
		return field("jdtWriteModel").ofType(JdtWriteModel.class).in(generateBuilderService).get();
	}
}