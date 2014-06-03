package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class ShellObject extends EclipseObject {

	protected ShellObject(Workbench workbench, String shellName) {
		super(workbench);
		workbench.waitUntil(shellOpened(shellName));
		workbench.shell(shellName).activate();
	}
}