package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.ShellObject;

public class DeleteFileShell extends ShellObject {

	public DeleteFileShell(Workbench workbench) {
		super(workbench, "Delete");
	}

	public void ok() {
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Delete"));
	}
}