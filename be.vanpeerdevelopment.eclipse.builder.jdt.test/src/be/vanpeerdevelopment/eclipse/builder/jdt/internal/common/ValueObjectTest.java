package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;

public class ValueObjectTest extends UnitTest {

	@Test
	public void equals_whenObjectsHaveSameFieldValues_thenObjectsAreEqual() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Person").build();

		boolean isEqual = compilationUnitOne.equals(compilationUnitTwo);

		assertThat(isEqual).isTrue();
	}

	@Test
	public void equals_whenObjectsHaveDifferentFieldValues_thenObjectsAreNotEqual() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Vehicle").build();

		boolean isEqual = compilationUnitOne.equals(compilationUnitTwo);

		assertThat(isEqual).isFalse();
	}

	@Test
	public void equals_isReflexive() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();

		boolean isEqual = compilationUnitOne.equals(compilationUnitOne);

		assertThat(isEqual).isTrue();
	}

	@Test
	public void equals_isSymmetricForTrue() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Person").build();

		boolean isEqualOneTwo = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualTwoOne = compilationUnitTwo.equals(compilationUnitOne);

		assertThat(isEqualOneTwo).isTrue();
		assertThat(isEqualTwoOne).isTrue();
	}

	@Test
	public void equals_isSymmetricForFalse() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Vehicle").build();

		boolean isEqualOneTwo = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualTwoOne = compilationUnitTwo.equals(compilationUnitOne);

		assertThat(isEqualOneTwo).isFalse();
		assertThat(isEqualTwoOne).isFalse();
	}

	@Test
	public void equals_isTransitive() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitThree = aCompilationUnit().withName("Person").build();

		boolean isEqualOneTwo = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualTwoThree = compilationUnitTwo.equals(compilationUnitThree);
		boolean isEqualOneThree = compilationUnitOne.equals(compilationUnitThree);

		assertThat(isEqualOneTwo).isTrue();
		assertThat(isEqualTwoThree).isTrue();
		assertThat(isEqualOneThree).isTrue();
	}

	@Test
	public void equals_isConsistentForTrue() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Person").build();

		boolean isEqualOne = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualTwo = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualThree = compilationUnitOne.equals(compilationUnitTwo);

		assertThat(isEqualOne).isTrue();
		assertThat(isEqualTwo).isTrue();
		assertThat(isEqualThree).isTrue();
	}

	@Test
	public void equals_isConsistentForFalse() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Vehicle").build();

		boolean isEqualOne = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualTwo = compilationUnitOne.equals(compilationUnitTwo);
		boolean isEqualThree = compilationUnitOne.equals(compilationUnitTwo);

		assertThat(isEqualOne).isFalse();
		assertThat(isEqualTwo).isFalse();
		assertThat(isEqualThree).isFalse();
	}

	@Test
	public void hashCode_whenTwoObjectsAreEquals_thenSameHashCode() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();
		CompilationUnit compilationUnitTwo = aCompilationUnit().withName("Person").build();

		boolean isEqualOne = compilationUnitOne.equals(compilationUnitTwo);
		int hashCodeOne = compilationUnitOne.hashCode();
		int hashCodeTwo = compilationUnitTwo.hashCode();

		assertThat(isEqualOne).isTrue();
		assertThat(hashCodeOne).isEqualTo(hashCodeTwo);
	}

	@Test
	public void toString_returnsStringOfWithAllFieldValues() {
		CompilationUnit compilationUnitOne = aCompilationUnit().withName("Person").build();

		String toString = compilationUnitOne.toString();

		assertThat(toString).contains(compilationUnitOne.getClass().getName());
		assertThat(toString).contains("name=Person");
	}
}