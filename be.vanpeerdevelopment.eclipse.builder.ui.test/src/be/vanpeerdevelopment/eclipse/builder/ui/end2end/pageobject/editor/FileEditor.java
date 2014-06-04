package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.editor;

import org.eclipse.swt.SWTException;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;

import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.EditorObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class FileEditor extends EditorObject<FileEditor> {

	public FileEditor(Workbench workbench, String fileName) {
		super(workbench, fileName);
	}

	public boolean hasGenerateBuilderInSourceContextMenu() {
		try {
			editor
					.contextMenu("Source")
					.menu("Generate Builder");
			return true;
		} catch (SWTException e) {
			if (e.throwable instanceof WidgetNotFoundException)
				return false;
			throw e;
		}
	}

	@Override
	protected FileEditor self() {
		return this;
	}
}