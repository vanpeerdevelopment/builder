package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.menu;

import static org.junit.Assert.assertNotNull;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;

import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.shell.OpenPerspectiveShell;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.shell.PreferencesShell;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class WindowMenu extends EclipseObject {

	private SWTBotMenu windowMenu;
	private SWTBotMenu openPerspectiveSubMenu;

	public WindowMenu(Workbench workbench) {
		super(workbench);
		windowMenu = workbench.menu("Window");
	}

	public WindowMenu openPerspective() {
		openPerspectiveSubMenu = windowMenu.menu("Open Perspective");
		return this;
	}

	public OpenPerspectiveShell other() {
		assertNotNull(
				"First open the open perspective sub menu using openPerspective()",
				openPerspectiveSubMenu);
		openPerspectiveSubMenu.menu("Other...").click();
		return new OpenPerspectiveShell(workbench);
	}

	public PreferencesShell preferences() {
		windowMenu.menu("Preferences").click();
		return new PreferencesShell(workbench);
	}
}