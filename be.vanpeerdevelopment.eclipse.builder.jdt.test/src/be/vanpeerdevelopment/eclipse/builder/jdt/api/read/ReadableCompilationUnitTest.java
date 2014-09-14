package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static be.vanpeerdevelopment.eclipse.builder.jdt.ICompilationUnitTestBuilder.anICompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.ITypeTestBuilder.anIType;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IType;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class ReadableCompilationUnitTest extends UnitTest {

	private static final String COMPILATION_UNIT_NAME = "CompilationUnitName";

	@Test
	public void getOnlyType() {
		IType type = anIType().build();
		ICompilationUnit compilationUnit = anICompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.withTypes(type)
				.build();
		ReadableCompilationUnit readableCompilationUnit = new ReadableCompilationUnit(compilationUnit);

		ReadableType readableType = readableCompilationUnit.getOnlyType();

		assertThat(getType(readableType)).isEqualTo(type);
	}

	@Test
	public void getOnlyType_WhenSomethingGoesWrongWhenGettingTypes_ThrowsJdtReadException() {
		ICompilationUnit compilationUnit = anICompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.withFailingGetTypes()
				.build();
		ReadableCompilationUnit readableCompilationUnit = new ReadableCompilationUnit(compilationUnit);

		expectExceptionWithMessage(
				JdtReadException.class,
				"Something went wrong while getting the types in the following compilation unit: "
						+ COMPILATION_UNIT_NAME);

		readableCompilationUnit.getOnlyType();
	}

	@Test
	public void getOnlyType_WhenNoTypes_ThrowsJdtReadModelException() {
		ICompilationUnit compilationUnit = anICompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.withoutTypes()
				.build();
		ReadableCompilationUnit readableCompilationUnit = new ReadableCompilationUnit(compilationUnit);

		expectExceptionWithMessage(JdtReadException.class,
				"Exception while getting the only type in compilation unit: " + COMPILATION_UNIT_NAME
				+ ". No type exists.");

		readableCompilationUnit.getOnlyType();
	}

	@Test
	public void getOnlyType_WhenMultipleTypes_ThrowsJdtReadModelException() {
		ICompilationUnit compilationUnit = anICompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.withTypes(anIType().build(), anIType().build())
				.build();
		ReadableCompilationUnit readableCompilationUnit = new ReadableCompilationUnit(compilationUnit);

		expectExceptionWithMessage(JdtReadException.class,
				"Exception while getting the only type in compilation unit: " + COMPILATION_UNIT_NAME
				+ ". More than one type exists.");

		readableCompilationUnit.getOnlyType();
	}

	private IType getType(ReadableType readableType) {
		return field("type").ofType(IType.class).in(readableType).get();
	}
}