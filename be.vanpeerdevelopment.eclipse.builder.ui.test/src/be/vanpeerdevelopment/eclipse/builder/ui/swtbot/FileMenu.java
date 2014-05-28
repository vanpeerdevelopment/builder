package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static org.junit.Assert.assertNotNull;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;

public class FileMenu extends EclipseObject {

	private SWTBotMenu fileMenu;
	private SWTBotMenu newSubMenu;

	FileMenu(Workbench workbench) {
		super(workbench);
		fileMenu = workbench.menu("File");
	}

	public FileMenu newSubMenu() {
		newSubMenu = fileMenu.menu("New");
		return this;
	}

	public NewShell other() {
		assertNotNull("First open the new sub menu using newSubMenu()", newSubMenu);
		newSubMenu.menu("Other...").click();
		return new NewShell(workbench);
	}
}