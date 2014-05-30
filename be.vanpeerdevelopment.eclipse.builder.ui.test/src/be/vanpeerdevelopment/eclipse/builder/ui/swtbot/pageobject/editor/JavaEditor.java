package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorOpened;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class JavaEditor extends EclipseObject {

	public JavaEditor(Workbench workbench, String className) {
		super(workbench);
		workbench.waitUntil(editorOpened(className + ".java"));
		workbench.editorByTitle(className + ".java").show();
	}
}