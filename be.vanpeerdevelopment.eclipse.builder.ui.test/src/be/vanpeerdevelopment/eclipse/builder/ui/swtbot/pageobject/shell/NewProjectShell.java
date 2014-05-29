package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewProjectShell extends ShellObject {

	public NewProjectShell(Workbench workbench) {
		super(workbench, "New Project");
	}

	public NewProjectShell setProjectName(String projectName) {
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Project"));
		// TODO: wait until project is created.
	}
}