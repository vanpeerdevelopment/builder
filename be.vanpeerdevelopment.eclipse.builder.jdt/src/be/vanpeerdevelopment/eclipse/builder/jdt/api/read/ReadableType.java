package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import org.eclipse.jdt.core.IType;

public class ReadableType {

	private IType type;

	public ReadableType(IType type) {
		this.type = type;
	}

	public String getSimpleName() {
		return type.getElementName();
	}
}