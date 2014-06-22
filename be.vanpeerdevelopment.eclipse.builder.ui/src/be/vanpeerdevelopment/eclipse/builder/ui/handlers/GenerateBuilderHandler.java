package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderServiceFactory.createGenerateBuilderService;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;

public class GenerateBuilderHandler extends AbstractHandler {

	private GenerateBuilderService generateBuilderService;
	private Workbench workbench;

	public GenerateBuilderHandler() {
		generateBuilderService = createGenerateBuilderService();
		workbench = new Workbench();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		generateBuilderService.generateBuilder(workbench.getActiveCompilationUnitLocation());
		return null;
	}
}