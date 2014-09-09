package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderServiceFactory;

public class GenerateBuilderHandlerModel {

	private Workbench workbench;
	private GenerateBuilderService generateBuilderService;

	public GenerateBuilderHandlerModel() {
		this.workbench = new Workbench();
		this.generateBuilderService = new GenerateBuilderServiceFactory().createGenerateBuilderService();
	}

	public void generateBuilder() {
		generateBuilderService.generateBuilder(workbench.getActiveCompilationUnitLocation());
	}
}