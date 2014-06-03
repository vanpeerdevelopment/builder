package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.MenuItemAddedAfterMenuItemPredicate.is;

import org.eclipse.swt.SWTException;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEclipseEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EditorObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class JavaEditor extends EditorObject {

	public JavaEditor(Workbench workbench, String className) {
		super(workbench, className + ".java");
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
}