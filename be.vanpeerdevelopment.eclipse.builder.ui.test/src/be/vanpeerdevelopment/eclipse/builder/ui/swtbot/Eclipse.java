package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.OpenPerspectiveShell.JAVA_PERSPECTIVE_LABEL;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.WelcomeView.WELCOME_VIEW_TITLE;

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

	public FileMenu fileMenu() {
		return new FileMenu(workbench);
	}
}