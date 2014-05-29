package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.perspectiveOpened;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellOpened;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class OpenPerspectiveShell extends EclipseObject {

	public static final String JAVA_PERSPECTIVE_LABEL = "Java";

	public OpenPerspectiveShell(Workbench workbench) {
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