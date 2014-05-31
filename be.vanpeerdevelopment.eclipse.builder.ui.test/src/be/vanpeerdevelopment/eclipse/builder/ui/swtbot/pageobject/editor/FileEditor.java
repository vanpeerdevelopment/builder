package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EditorObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class FileEditor extends EditorObject {

	public FileEditor(Workbench workbench, String fileName) {
		super(workbench, fileName);
	}
}