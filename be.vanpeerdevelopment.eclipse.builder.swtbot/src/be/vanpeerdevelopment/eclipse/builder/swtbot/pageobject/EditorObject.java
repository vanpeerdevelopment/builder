package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.editorClosed;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.editorOpened;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.F10;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.SHIFT;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.toKeyStrokes;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;

import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key;

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

	public S pressShortcut(Key... keys) {
		editor.pressShortcut(toKeyStrokes(keys));
		return self();
	}

	public void close() {
		editor.close();
		workbench.waitUntil(editorClosed(editorTitle));
	}

	protected abstract S self();
}