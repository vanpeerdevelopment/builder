package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class ReadablePackageFragmentIntegrationTest extends EclipseTest {

	private JdtReadModel jdtReadModel;

	@Before
	public void setup() {
		jdtReadModel = new JdtReadModel();
	}

	@Test
	public void getName() {
		ReadablePackageFragment packageFragment = jdtReadModel.getPackageFragment(packageLocation());

		String name = packageFragment.getName();

		assertThat(name).isEqualTo(JAVA_PACKAGE_NAME);
	}
}