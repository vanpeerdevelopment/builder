package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import org.eclipse.jdt.core.IType;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtType;

public class TypeAdapter implements JdtType {

	private IType type;

	public TypeAdapter(IType type) {
		this.type = type;
	}

	@Override
	public String getSimpleName() {
		return type.getElementName();
	}
}