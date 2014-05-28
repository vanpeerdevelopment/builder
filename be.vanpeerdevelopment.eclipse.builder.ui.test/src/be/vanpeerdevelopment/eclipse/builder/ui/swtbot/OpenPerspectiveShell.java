package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.perspectiveOpened;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;

public class OpenPerspectiveShell extends EclipseObject {

	public static final String JAVA_PERSPECTIVE_LABEL = "Java";

	OpenPerspectiveShell(Workbench workbench) {
		super(workbench);
		workbench.waitUntil(shellOpened("Open Perspective"));
		workbench.shell("Open Perspective").activate();
	}

	public void java() {
		workbench.table().select("Java");
		workbench.button("OK").click();
		workbench.waitUntil(shellClosed("Open Perspective"));
		workbench.waitUntil(perspectiveOpened(JAVA_PERSPECTIVE_LABEL));
	}
}