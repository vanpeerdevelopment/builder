package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewJavaProjectShell extends ShellObject {

	public NewJavaProjectShell(Workbench workbench) {
		super(workbench, "New Java Project");
	}

	public NewJavaProjectShell setProjectName(String projectName) {
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Java Project"));
		// TODO: wait until project is created.
	}
}