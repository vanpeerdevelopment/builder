package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;

public class GenerateBuilderHandlerModel {

	private GenerateBuilderService generateBuilderService;
	private Workbench workbench;

	public GenerateBuilderHandlerModel(GenerateBuilderService generateBuilderService,
			Workbench workbench) {
		this.generateBuilderService = generateBuilderService;
		this.workbench = workbench;
	}

	public void generateBuilder() {
		generateBuilderService.generateBuilder(workbench.getActiveCompilationUnitLocation());
	}
}