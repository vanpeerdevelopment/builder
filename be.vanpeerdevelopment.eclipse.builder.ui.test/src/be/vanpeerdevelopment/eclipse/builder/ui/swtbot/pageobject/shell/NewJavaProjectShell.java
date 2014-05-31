package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.projectCreated;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static org.junit.Assert.assertNotNull;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewJavaProjectShell extends ShellObject {

	private String projectName;

	public NewJavaProjectShell(Workbench workbench) {
		super(workbench, "New Java Project");
	}

	public NewJavaProjectShell setProjectName(String projectName) {
		this.projectName = projectName;
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		assertNotNull("First set the project name using setProjectName()", projectName);
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Java Project"), 10000);
		workbench.waitUntil(projectCreated(projectName));
	}
}