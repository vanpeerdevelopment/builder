package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.editor;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.MenuItemAddedAfterMenuItemPredicate.is;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.CTRL;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.SHIFT;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.key;

import org.eclipse.swt.SWTException;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;

import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.EditorObject;

public class JavaEditor extends EditorObject<JavaEditor> {

	public JavaEditor(Workbench workbench, String className) {
		super(workbench, className + ".java");
	}

	public JavaEditor navigateTo(int line) {
		editor.navigateTo(line - 1, 0);
		return this;
	}

	public JavaEditor typeText(String text) {
		editor.typeText(text);
		return this;
	}

	public JavaEditor format() {
		pressShortcut(CTRL, SHIFT, key("F"));
		return this;
	}

	public JavaEditor save() {
		pressShortcut(CTRL, key("S"));
		return this;
	}

	public SourceContextMenu sourceContextMenu() {
		return new SourceContextMenu(editor);
	}

	public static class SourceContextMenu {

		private SWTBotMenu sourceContextMenu;

		public SourceContextMenu(SWTBotEclipseEditor editor) {
			sourceContextMenu = editor.contextMenu("Source");
		}

		public String generateBuilderMenuText() {
			return sourceContextMenu.menu("Generate Builder").getText();
		}

		public boolean isGenerateBuilderAddedAfterGenerateConstructorsFromSuperClass() {
			return is("Generate Builder")
					.addedAfter("Generate Constructors from Superclass...")
					.in(sourceContextMenu);
		}

		public void generateBuilder() {
			sourceContextMenu.menu("Generate Builder").click();
		}

		public boolean containsGenerateBuilder() {
			try {
				sourceContextMenu.menu("Generate Builder");
				return true;
			} catch (SWTException e) {
				if (e.throwable instanceof WidgetNotFoundException)
					return false;
				throw e;
			}
		}
	}

	@Override
	protected JavaEditor self() {
		return this;
	}
}