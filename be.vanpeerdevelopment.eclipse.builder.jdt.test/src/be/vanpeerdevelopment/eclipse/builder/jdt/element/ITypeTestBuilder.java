package be.vanpeerdevelopment.eclipse.builder.jdt.element;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.jdt.core.IType;

public class ITypeTestBuilder {

	public static final String TYPE_NAME = "Person";

	private IType type;

	private ITypeTestBuilder() {
		type = mock(IType.class);
	}

	public static ITypeTestBuilder anIType() {
		return new ITypeTestBuilder();
	}

	public IType build() {
		return type;
	}

	public ITypeTestBuilder withName(String name) {
		when(type.getElementName()).thenReturn(name);
		return this;
	}
}