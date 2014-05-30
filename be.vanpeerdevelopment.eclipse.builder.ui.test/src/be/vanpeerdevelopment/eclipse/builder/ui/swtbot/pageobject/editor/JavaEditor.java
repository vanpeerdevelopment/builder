package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EditorObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class JavaEditor extends EditorObject {

	public JavaEditor(Workbench workbench, String className) {
		super(workbench, className + ".java");
	}
}