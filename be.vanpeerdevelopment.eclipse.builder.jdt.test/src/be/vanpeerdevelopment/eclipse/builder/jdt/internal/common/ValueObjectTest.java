package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration;

public class ValueObjectTest extends UnitTest {

	@Test
	public void equals_whenObjectsHaveSameFieldValues_thenObjectsAreEqual() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("person").build();

		boolean isEqual = packageDeclarationOne.equals(packageDeclarationTwo);

		assertThat(isEqual).isTrue();
	}

	@Test
	public void equals_whenObjectsHaveDifferentFieldValues_thenObjectsAreNotEqual() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("vehicle").build();

		boolean isEqual = packageDeclarationOne.equals(packageDeclarationTwo);

		assertThat(isEqual).isFalse();
	}

	@Test
	public void equals_isReflexive() {
		PackageDeclaration packageDeclaration = aPackageDeclaration().withName("person").build();

		boolean isEqual = packageDeclaration.equals(packageDeclaration);

		assertThat(isEqual).isTrue();
	}

	@Test
	public void equals_isSymmetricForTrue() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("person").build();

		boolean isEqualOneTwo = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualTwoOne = packageDeclarationTwo.equals(packageDeclarationOne);

		assertThat(isEqualOneTwo).isTrue();
		assertThat(isEqualTwoOne).isTrue();
	}

	@Test
	public void equals_isSymmetricForFalse() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("vehicle").build();

		boolean isEqualOneTwo = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualTwoOne = packageDeclarationTwo.equals(packageDeclarationOne);

		assertThat(isEqualOneTwo).isFalse();
		assertThat(isEqualTwoOne).isFalse();
	}

	@Test
	public void equals_isTransitive() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationThree = aPackageDeclaration().withName("person").build();

		boolean isEqualOneTwo = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualTwoThree = packageDeclarationTwo.equals(packageDeclarationThree);
		boolean isEqualOneThree = packageDeclarationOne.equals(packageDeclarationThree);

		assertThat(isEqualOneTwo).isTrue();
		assertThat(isEqualTwoThree).isTrue();
		assertThat(isEqualOneThree).isTrue();
	}

	@Test
	public void equals_isConsistentForTrue() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("person").build();

		boolean isEqualOne = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualTwo = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualThree = packageDeclarationOne.equals(packageDeclarationTwo);

		assertThat(isEqualOne).isTrue();
		assertThat(isEqualTwo).isTrue();
		assertThat(isEqualThree).isTrue();
	}

	@Test
	public void equals_isConsistentForFalse() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("vehicle").build();

		boolean isEqualOne = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualTwo = packageDeclarationOne.equals(packageDeclarationTwo);
		boolean isEqualThree = packageDeclarationOne.equals(packageDeclarationTwo);

		assertThat(isEqualOne).isFalse();
		assertThat(isEqualTwo).isFalse();
		assertThat(isEqualThree).isFalse();
	}

	@Test
	public void hashCode_whenTwoObjectsAreEquals_thenSameHashCode() {
		PackageDeclaration packageDeclarationOne = aPackageDeclaration().withName("person").build();
		PackageDeclaration packageDeclarationTwo = aPackageDeclaration().withName("person").build();

		boolean isEqualOne = packageDeclarationOne.equals(packageDeclarationTwo);
		int hashCodeOne = packageDeclarationOne.hashCode();
		int hashCodeTwo = packageDeclarationTwo.hashCode();

		assertThat(isEqualOne).isTrue();
		assertThat(hashCodeOne).isEqualTo(hashCodeTwo);
	}

	@Test
	public void toString_returnsStringOfWithAllFieldValues() {
		PackageDeclaration packageDeclaration = aPackageDeclaration().withName("person").build();

		String toString = packageDeclaration.toString();

		assertThat(toString).contains(packageDeclaration.getClass().getName());
		assertThat(toString).contains("name=person");
	}
}