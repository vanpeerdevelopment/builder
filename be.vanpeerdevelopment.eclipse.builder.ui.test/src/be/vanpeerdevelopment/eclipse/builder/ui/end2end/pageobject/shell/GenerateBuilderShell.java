package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class GenerateBuilderShell extends ShellObject {

	public GenerateBuilderShell(Workbench workbench) {
		super(workbench, "Generate Builder");
	}

	public void ok() {
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Generate Builder"));
	}
}