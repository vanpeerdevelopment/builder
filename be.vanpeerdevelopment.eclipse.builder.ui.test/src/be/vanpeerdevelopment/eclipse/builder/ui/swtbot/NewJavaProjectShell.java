package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;

public class NewJavaProjectShell extends EclipseObject {

	NewJavaProjectShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("New Java Project"));
		workbench.shell("New Java Project").activate();
	}

	public NewJavaProjectShell setProjectName(String projectName) {
		workbench.textWithLabel("Project name:").setText(projectName);
		return this;
	}

	public void finish() {
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Java Project"));
	}
}