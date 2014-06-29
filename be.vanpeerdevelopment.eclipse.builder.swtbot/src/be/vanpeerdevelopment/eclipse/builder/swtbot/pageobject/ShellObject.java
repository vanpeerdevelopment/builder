package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.shellOpened;
import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;

public abstract class ShellObject extends EclipseObject {

	protected ShellObject(Workbench workbench, String shellName) {
		super(workbench);
		workbench.waitUntil(shellOpened(shellName));
		workbench.shell(shellName).activate();
	}
}