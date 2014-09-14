package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderContext.GenerateBuilderContextBuilder.generateBuilderContext;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderContext;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;

public class GenerateBuilderHandlerModel {

	private Workbench workbench;
	private GenerateBuilderService generateBuilderService;

	public GenerateBuilderHandlerModel() {
		this.workbench = new Workbench();
		this.generateBuilderService = new GenerateBuilderService();
	}

	public void generateBuilder() {
		GenerateBuilderContext context = generateBuilderContext()
				.withCompilationUnitLocation(workbench.getActiveCompilationUnitLocation())
				.build();
		generateBuilderService.generateBuilder(context);
	}
}