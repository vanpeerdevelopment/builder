package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import org.eclipse.jdt.core.IType;

public class ReadableClassDefinition {

	private IType type;

	public ReadableClassDefinition(IType type) {
		this.type = type;
	}

	public String getSimpleName() {
		return type.getElementName();
	}
}