package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.eclipse.ui.PlatformUI.getWorkbench;
import static org.eclipse.ui.ide.IDE.openEditor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

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

	public void openCompilationUnit(IPath compilationUnitLocation) {
		try {
			openCompilationUnitIgnoringException(compilationUnitLocation);
		} catch (PartInitException e) {
			throw new RuntimeException(
					"Something went wrong while opening the compilation unit: " + compilationUnitLocation,
					e);
		}
	}

	private void openCompilationUnitIgnoringException(IPath compilationUnitLocation) throws PartInitException {
		IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile compilationUnit = getWorkspace().getRoot().getFileForLocation(compilationUnitLocation);
		openEditor(page, compilationUnit, true);
	}
}