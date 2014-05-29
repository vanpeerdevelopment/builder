package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewJavaProjectShell extends EclipseObject {

	public NewJavaProjectShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("New Java Project"));
		workbench.shell("New Java Project").activate();
		// TODO: refactor setup into superclass.
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