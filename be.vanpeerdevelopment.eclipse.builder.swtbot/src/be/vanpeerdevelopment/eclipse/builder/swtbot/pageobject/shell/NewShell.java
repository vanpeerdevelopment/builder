package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.ShellObject;

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