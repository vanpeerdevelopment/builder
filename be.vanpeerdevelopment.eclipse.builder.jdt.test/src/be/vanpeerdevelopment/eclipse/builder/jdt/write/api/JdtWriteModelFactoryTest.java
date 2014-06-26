package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.internal.JdtWriteModelImpl;

public class JdtWriteModelFactoryTest extends UnitTest {

	private JdtWriteModelFactory factory = new JdtWriteModelFactory();

	@Test
	public void createJdtWriteModel() {
		JdtWriteModel jdtWriteModel = factory.createJdtWriteModel();

		assertThat(jdtWriteModel).isInstanceOf(JdtWriteModelImpl.class);
	}
}