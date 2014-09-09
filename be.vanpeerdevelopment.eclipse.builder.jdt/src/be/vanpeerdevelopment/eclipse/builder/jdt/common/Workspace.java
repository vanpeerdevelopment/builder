package be.vanpeerdevelopment.eclipse.builder.jdt.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

public class Workspace {

	public IFile getFile(IPath fileLocation) {
		return getWorkspace()
				.getRoot()
				.getFileForLocation(fileLocation);
	}
}