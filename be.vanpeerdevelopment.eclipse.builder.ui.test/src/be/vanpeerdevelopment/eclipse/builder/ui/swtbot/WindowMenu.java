package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static org.junit.Assert.assertNotNull;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;

public class WindowMenu extends EclipseObject {

	private SWTBotMenu windowMenu;
	private SWTBotMenu openPerspectiveSubMenu;

	WindowMenu(Workbench workbench) {
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
}