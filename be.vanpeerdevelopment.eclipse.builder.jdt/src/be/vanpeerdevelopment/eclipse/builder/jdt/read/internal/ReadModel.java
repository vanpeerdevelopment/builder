package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;

public class ReadModel implements JdtReadModel {

	@Override
	public String getJavaClassName(IPath fileLocation) {
		return getWorkspace()
				.getRoot()
				.getFileForLocation(fileLocation)
				.getName();
	}
}