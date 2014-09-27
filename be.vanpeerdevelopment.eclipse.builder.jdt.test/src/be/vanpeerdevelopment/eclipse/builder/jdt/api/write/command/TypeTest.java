package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ITypeTestBuilder.TYPE_NAME;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class TypeTest extends UnitTest {

	@Test
	public void toCode() {
		Type type = aType()
				.withName(TYPE_NAME)
				.build();

		String code = type.toCode();

		assertThat(code).isEqualTo("public class " + TYPE_NAME + "{}");
	}
}