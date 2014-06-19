package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class DeleteFileShell extends ShellObject {

	public DeleteFileShell(Workbench workbench) {
		super(workbench, "Delete");
	}

	public void ok() {
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Delete"));
	}
}