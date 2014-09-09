package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static org.eclipse.ui.PlatformUI.getWorkbench;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;

public class Workbench {

	public IPath getActiveCompilationUnitLocation() {
		return ((IFile) getWorkbench()
				.getActiveWorkbenchWindow()
				.getActivePage()
				.getActiveEditor()
				.getEditorInput()
				.getAdapter(IFile.class))
				.getLocation();
	}
}