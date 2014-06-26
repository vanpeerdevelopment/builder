package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.internal.JdtReadModelImpl;

public class JdtReadModelFactoryTest extends UnitTest {

	private JdtReadModelFactory factory = new JdtReadModelFactory();

	@Test
	public void createJdtReadModel() {
		JdtReadModel jdtReadModel = factory.createJdtReadModel();

		assertThat(jdtReadModel).isInstanceOf(JdtReadModelImpl.class);
	}
}