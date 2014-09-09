package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

import org.eclipse.jdt.core.IType;

public class ReadableType {

	private IType type;

	ReadableType(IType type) {
		this.type = type;
	}

	public String getSimpleName() {
		return type.getElementName();
	}
}