package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.editorOpened;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.F10;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.SHIFT;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public abstract class EditorObject<S extends EditorObject<S>> extends EclipseObject {

	protected String editorTitle;
	protected SWTBotEclipseEditor editor;

	protected EditorObject(Workbench workbench, String editorTitle) {
		super(workbench);
		this.editorTitle = editorTitle;
		workbench.waitUntil(editorOpened(editorTitle));
		editor = workbench.editorByTitle(editorTitle).toTextEditor();
		editor.show();
	}

	public S openContextMenu() {
		pressShortcut(SHIFT, F10);
		return self();
	}

	public S pressShortcut(KeyStroke... keyStrokes) {
		editor.pressShortcut(keyStrokes);
		return self();
	}

	public void close() {
		editor.close();
		workbench.waitUntil(editorClosed(editorTitle));
	}

	protected abstract S self();
}