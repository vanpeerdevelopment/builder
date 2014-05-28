package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;

public class NewProjectShell extends EclipseObject {

	NewProjectShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("New Project"));
		workbench.shell("New Project").activate();
	}

	public NewProjectShell setProjectName(String projectName) {
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Project"));
	}
}