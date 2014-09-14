package be.vanpeerdevelopment.eclipse.builder.jdt;

import static org.mockito.Mockito.mock;

import org.eclipse.jdt.core.IType;

public class ITypeTestBuilder {

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
}