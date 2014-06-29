package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.perspectiveOpened;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.shellClosed;
import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.ShellObject;

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