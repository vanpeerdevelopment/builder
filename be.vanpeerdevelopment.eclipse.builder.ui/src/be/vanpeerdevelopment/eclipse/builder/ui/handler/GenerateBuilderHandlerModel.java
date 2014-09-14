package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand.GenerateBuilderCommandBuilder.generateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;

public class GenerateBuilderHandlerModel {

	private Workbench workbench;
	private GenerateBuilderService generateBuilderService;

	public GenerateBuilderHandlerModel() {
		this.workbench = new Workbench();
		this.generateBuilderService = new GenerateBuilderService();
	}

	public void generateBuilder() {
		GenerateBuilderCommand command = generateBuilderCommand()
				.withCompilationUnitLocation(workbench.getActiveCompilationUnitLocation())
				.build();
		generateBuilderService.generateBuilder(command);
	}
}