package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;

public class GenerateBuilderHandlerModel {

	private Workbench workbench;
	private GenerateBuilderService generateBuilderService;

	public GenerateBuilderHandlerModel() {
		this.workbench = new Workbench();
		this.generateBuilderService = new GenerateBuilderService();
	}

	public void generateBuilder() {
		generateBuilderService.generateBuilder(workbench.getActiveCompilationUnitLocation());
	}
}