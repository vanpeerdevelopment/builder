package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Workbench {

	private IWorkbench workbench;

	public Workbench() {
		workbench = PlatformUI.getWorkbench();
	}

	public IPath getActiveCompilationUnitLocation() {
		return ((IFile) workbench
				.getActiveWorkbenchWindow()
				.getActivePage()
				.getActiveEditor()
				.getEditorInput()
				.getAdapter(IFile.class))
				.getLocation();
	}
}