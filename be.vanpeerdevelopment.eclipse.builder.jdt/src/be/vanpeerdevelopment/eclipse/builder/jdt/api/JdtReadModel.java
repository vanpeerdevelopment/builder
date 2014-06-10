package be.vanpeerdevelopment.eclipse.builder.jdt.api;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import org.eclipse.core.runtime.IPath;

public class JdtReadModel {

	public String getJavaClassName(IPath fileLocation) {
		return getWorkspace()
				.getRoot()
				.getFileForLocation(fileLocation)
				.getName();
	}
}