package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell.OpenPerspectiveShell.JAVA_PERSPECTIVE_LABEL;
import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.swt.finder.results.Result;

import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.editor.JavaEditor;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.menu.FileMenu;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.menu.WindowMenu;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell.DeleteFileShell;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.view.WelcomeView;

public class Eclipse extends EclipseObject {

	private Eclipse() {
		super(new Workbench());
	}

	public static Eclipse eclipse() {
		return new Eclipse();
	}

	public Display getDisplay() {
		return workbench.getDisplay();
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

	public boolean willFileBeCreated(String projectName, String folderName, String fileName) {
		return workbench.willFileBeCreated(projectName, folderName, fileName);
	}

	public boolean willClassBeCreated(String projectName, String sourceFolderName,
			String packageName, String className) {
		return workbench
				.willClassBeCreated(projectName, sourceFolderName, packageName, className);
	}

	public JavaEditor openClass(String projectName, String sourceFolderName, String packageName,
			String className) {
		return workbench.openClass(projectName, sourceFolderName, packageName, className);
	}

	public FileEditor openFile(String projectName, String fileFolder, String fileName) {
		return workbench.openFile(projectName, fileFolder, fileName);
	}

	public DeleteFileShell deleteClass(String projectName, String sourceFolderName,
			String packageName,
			String className) {
		return workbench.deleteClass(projectName, sourceFolderName, packageName, className);
	}

	public <T> T runInUiThread(final Function<T> function) {
		return syncExec(getDisplay(), new Result<T>() {
			@Override
			public T run() {
				return function.execute();
			}
		});
	}
}