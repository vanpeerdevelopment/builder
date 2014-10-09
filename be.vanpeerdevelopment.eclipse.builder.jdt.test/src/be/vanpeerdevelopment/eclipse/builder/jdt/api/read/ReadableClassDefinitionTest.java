package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.anIType;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.jdt.core.IType;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class ReadableClassDefinitionTest extends UnitTest {

	private static final String TYPE_NAME = "TypeName";

	@Test
	public void getSimpleName() throws Exception {
		IType type = anIType()
				.withName(TYPE_NAME)
				.build();

		ReadableClassDefinition readableClassDefinition = new ReadableClassDefinition(type);

		assertThat(readableClassDefinition.getSimpleName()).isEqualTo(TYPE_NAME);
	}
}
