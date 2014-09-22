package be.vanpeerdevelopment.eclipse.builder.jdt.element;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;

public class IResourceTestBuilder {

	private IResource resource;

	private IResourceTestBuilder() {
		resource = mock(IResource.class);
	}

	public static IResourceTestBuilder anIResource() {
		return new IResourceTestBuilder();
	}

	public IResource build() {
		return resource;
	}

	public IResourceTestBuilder withLocation(IPath location) {
		when(resource.getLocation()).thenReturn(location);
		return this;
	}
}