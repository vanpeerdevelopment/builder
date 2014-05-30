package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorOpened;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class EditorObject extends EclipseObject {

	protected String editorTitle;
	protected SWTBotEclipseEditor editor;

	protected EditorObject(Workbench workbench, String editorTitle) {
		super(workbench);
		this.editorTitle = editorTitle;
		workbench.waitUntil(editorOpened(editorTitle));
		editor = workbench.editorByTitle(editorTitle).toTextEditor();
		editor.show();
	}

	public void pressShortcut(KeyStroke... keyStrokes) {
		editor.pressShortcut(keyStrokes);
	}

	public void close() {
		editor.close();
		workbench.waitUntil(editorClosed(editorTitle));
	}
}