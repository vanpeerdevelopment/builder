package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import org.eclipse.jdt.core.IType;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.ReadableType;

public class ReadableTypeAdapter implements ReadableType {

	private IType type;

	public ReadableTypeAdapter(IType type) {
		this.type = type;
	}

	@Override
	public String getSimpleName() {
		return type.getElementName();
	}
}