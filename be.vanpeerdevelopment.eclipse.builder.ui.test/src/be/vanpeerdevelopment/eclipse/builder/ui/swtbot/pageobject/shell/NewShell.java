package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class NewShell extends ShellObject {

	public NewShell(Workbench workbench) {
		super(workbench, "New");
	}

	public NewJavaProjectShell javaProject() {
		workbench.tree().expandNode("Java").select("Java Project");
		workbench.button("Next >").click();
		workbench.waitUntil(shellClosed("New"));
		return new NewJavaProjectShell(workbench);
	}

	public NewFileShell file() {
		workbench.tree().expandNode("General").select("File");
		workbench.button("Next >").click();
		workbench.waitUntil(shellClosed("New"));
		return new NewFileShell(workbench);
	}

	public NewJavaClassShell javaClass() {
		workbench.tree().expandNode("Java").select("Class");
		workbench.button("Next >").click();
		workbench.waitUntil(shellClosed("New"));
		return new NewJavaClassShell(workbench);
	}
}