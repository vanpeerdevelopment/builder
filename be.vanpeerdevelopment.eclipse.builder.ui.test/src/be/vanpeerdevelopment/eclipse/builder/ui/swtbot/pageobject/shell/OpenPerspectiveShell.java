package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.perspectiveOpened;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class OpenPerspectiveShell extends ShellObject {

	public static final String JAVA_PERSPECTIVE_LABEL = "Java";

	public OpenPerspectiveShell(Workbench workbench) {
		super(workbench, "Open Perspective");
	}

	public void java() {
		workbench.table().select("Java");
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Open Perspective"));
		workbench.waitUntil(perspectiveOpened(JAVA_PERSPECTIVE_LABEL));
	}
}