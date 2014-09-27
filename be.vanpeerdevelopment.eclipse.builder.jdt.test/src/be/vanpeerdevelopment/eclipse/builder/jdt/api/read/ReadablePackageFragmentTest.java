package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.anIPackageFragment;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.jdt.core.IPackageFragment;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class ReadablePackageFragmentTest extends UnitTest {

	private static final String PACKAGE_NAME = "be.vanpeerdevelopment.eclipse.builder";

	@Test
	public void getName() {
		IPackageFragment packageFragment = anIPackageFragment()
				.withName(PACKAGE_NAME)
				.build();
		ReadablePackageFragment readablePackageFragment = new ReadablePackageFragment(packageFragment);

		String result = readablePackageFragment.getName();

		assertThat(result).isEqualTo(PACKAGE_NAME);
	}
}