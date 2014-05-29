package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell.OpenPerspectiveShell.JAVA_PERSPECTIVE_LABEL;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view.WelcomeView.WELCOME_VIEW_TITLE;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.menu.FileMenu;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.menu.WindowMenu;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view.WelcomeView;

public class Eclipse extends EclipseObject {

	private Eclipse() {
		super(new Workbench());
	}

	public static Eclipse eclipse() {
		return new Eclipse();
	}

	public boolean isWelcomeViewOpen() {
		return workbench.isViewOpen(WELCOME_VIEW_TITLE);
	}

	public WelcomeView selectWelcomeView() {
		return new WelcomeView(workbench);
	}

	public boolean isJavaPerspectiveOpen() {
		return workbench.isPerspectiveOpen(JAVA_PERSPECTIVE_LABEL);
	}

	public WindowMenu windowMenu() {
		return new WindowMenu(workbench);
	}

	public boolean projectExists(String projectName) {
		return workbench.projectExists(projectName);
	}

	public boolean fileExsists(String projectName, String folderName, String fileName) {
		return workbench.fileExists(projectName, folderName, fileName);
	}

	public FileMenu fileMenu() {
		return new FileMenu(workbench);
	}
}