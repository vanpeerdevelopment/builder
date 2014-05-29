package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.projectCreated;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static org.junit.Assert.assertNotNull;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewProjectShell extends ShellObject {

	private String projectName;

	public NewProjectShell(Workbench workbench) {
		super(workbench, "New Project");
	}

	public NewProjectShell setProjectName(String projectName) {
		this.projectName = projectName;
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		assertNotNull("First set the project name using setProjectName()", projectName);
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Project"));
		workbench.waitUntil(projectCreated(projectName));
	}
}