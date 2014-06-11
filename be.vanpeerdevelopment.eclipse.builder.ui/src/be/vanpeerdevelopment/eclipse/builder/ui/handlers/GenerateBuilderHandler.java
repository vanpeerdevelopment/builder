package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import static org.eclipse.jface.dialogs.MessageDialog.openInformation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.ui.PlatformUI;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderServiceFactory;

public class GenerateBuilderHandler extends AbstractHandler {

	private GenerateBuilderService generateBuilderService;

	public GenerateBuilderHandler() {
		generateBuilderService = GenerateBuilderServiceFactory.createGenerateBuilderService();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		generateBuilderService.generateBuilder(getActiveCompilationUnitLocation());
		openInformation(
				null,
				"Generate Builder",
				"A builder class will be generated for the active class: "
						+ generateBuilderService.getJavaClassName(getActiveCompilationUnitLocation())
						+ ".java");
		return null;
	}

	private IPath getActiveCompilationUnitLocation() {
		return ((IFile) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow()
				.getActivePage()
				.getActiveEditor()
				.getEditorInput()
				.getAdapter(IFile.class))
				.getLocation();
	}
}