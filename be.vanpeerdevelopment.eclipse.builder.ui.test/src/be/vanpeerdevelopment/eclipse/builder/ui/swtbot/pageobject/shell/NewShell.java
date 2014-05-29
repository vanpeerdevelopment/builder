package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewShell extends EclipseObject {

	public NewShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("New"));
		workbench.shell("New").activate();
		// TODO: refactor setup into superclass.
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
