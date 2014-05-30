package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorOpened;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class EditorObject extends EclipseObject {

	private String editorTitle;
	private SWTBotEditor editor;

	protected EditorObject(Workbench workbench, String editorTitle) {
		super(workbench);
		this.editorTitle = editorTitle;
		workbench.waitUntil(editorOpened(editorTitle));
		editor = workbench.editorByTitle(editorTitle);
		editor.show();
	}

	public void close() {
		editor.close();
		workbench.waitUntil(editorClosed(editorTitle));
	}
}