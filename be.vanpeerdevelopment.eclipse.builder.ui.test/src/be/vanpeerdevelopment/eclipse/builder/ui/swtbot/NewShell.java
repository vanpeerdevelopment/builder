package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;

public class NewShell extends EclipseObject {

	NewShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("New"));
		workbench.shell("New").activate();
	}

	public NewJavaProjectShell javaProject() {
		workbench.tree().expandNode("Java").select("Java Project");
		workbench.button("Next >").click();
		workbench.waitUntil(shellClosed("New"));
		return new NewJavaProjectShell(workbench);
	}

	public NewProjectShell project() {
		workbench.tree().expandNode("General").select("Project");
		workbench.button("Next >").click();
		workbench.waitUntil(shellClosed("New"));
		return new NewProjectShell(workbench);
	}
}
