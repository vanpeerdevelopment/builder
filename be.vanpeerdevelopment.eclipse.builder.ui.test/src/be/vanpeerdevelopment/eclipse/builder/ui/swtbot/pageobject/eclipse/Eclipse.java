package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell.OpenPerspectiveShell.JAVA_PERSPECTIVE_LABEL;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.JavaEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.menu.FileMenu;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.menu.WindowMenu;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell.GenerateBuilderShell;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view.WelcomeView;

public class Eclipse extends EclipseObject {

	private Eclipse() {
		super(new Workbench());
	}

	public static Eclipse eclipse() {
		return new Eclipse();
	}

	public WelcomeView selectWelcomeView() {
		return new WelcomeView(workbench);
	}

	public boolean isWelcomeViewOpen() {
		return workbench.isViewOpen("Welcome");
	}

	public boolean isJavaPerspectiveOpen() {
		return workbench.isPerspectiveOpen(JAVA_PERSPECTIVE_LABEL);
	}

	public boolean willGenerateBuilderShellOpen() {
		return workbench.willShellOpen("Generate Builder");
	}

	public GenerateBuilderShell selectGenerateBuilderShell() {
		return new GenerateBuilderShell(workbench);
	}

	public FileMenu fileMenu() {
		return new FileMenu(workbench);
	}

	public WindowMenu windowMenu() {
		return new WindowMenu(workbench);
	}

	public boolean projectExists(String projectName) {
		return workbench.projectExists(projectName);
	}

	public boolean fileExists(String projectName, String folderName, String fileName) {
		return workbench.fileExists(projectName, folderName, fileName);
	}

	public boolean classExists(String projectName, String sourceFolderName, String packageName,
			String className) {
		return workbench.classExists(projectName, sourceFolderName, packageName, className);
	}

	public JavaEditor openClass(String projectName, String sourceFolderName, String packageName,
			String className) {
		return workbench.openClass(projectName, sourceFolderName, packageName, className);
	}

	public FileEditor openFile(String projectName, String fileFolder, String fileName) {
		return workbench.openFile(projectName, fileFolder, fileName);
	}
}