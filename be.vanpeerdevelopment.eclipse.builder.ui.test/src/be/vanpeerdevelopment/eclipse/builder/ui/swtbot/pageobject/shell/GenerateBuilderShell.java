package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class GenerateBuilderShell extends ShellObject {

	public GenerateBuilderShell(Workbench workbench) {
		super(workbench, "Generate Builder");
	}

	public void ok() {
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Generate Builder"));
	}
}