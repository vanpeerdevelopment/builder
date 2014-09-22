package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.classCreated;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.editorOpened;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.fileCreated;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;

import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.editor.JavaEditor;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell.DeleteFileShell;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.view.PackageExplorerView;

public class Workbench extends SWTWorkbenchBot {

	public Workbench() {
	}

	public boolean isViewOpen(String viewTitle) {
		for (SWTBotView view : views()) {
			if (view.getTitle().equals(viewTitle)) {
				return true;
			}
		}
		return false;
	}

	public boolean isShellOpen(String shellName) {
		for (SWTBotShell shell : shells()) {
			if (shell.getText().equals(shellName)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPerspectiveOpen(String perspectiveLabel) {
		return activePerspective().getLabel().equals(perspectiveLabel);
	}

	public boolean isEditorActive(String editorTitle) {
		SWTBotEditor editor = getEditor(editorTitle);
		if (editor == null)
			return false;
		return editor.isActive();
	}

	public boolean isEditorOpen(String editorTitle) {
		SWTBotEditor editor = getEditor(editorTitle);
		return editor != null;
	}

	public boolean willEditorBeOpened(String editorTitle) {
		try {
			waitUntil(editorOpened(editorTitle));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean projectExists(String projectName) {
		return getPackageExplorerView().projectExists(projectName);
	}

	public boolean fileExists(String projectName, String folderName, String fileName) {
		return getPackageExplorerView().fileExists(projectName, folderName, fileName);
	}

	public boolean classExists(String projectName, String sourceFolderName, String packageName,
			String className) {
		return getPackageExplorerView().classExists(projectName, sourceFolderName, packageName,
				className);
	}

	public boolean willClassBeCreated(String projectName, String sourceFolderName,
			String packageName, String className) {
		try {
			waitUntil(classCreated(projectName, sourceFolderName, packageName, className));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public boolean willFileBeCreated(String projectName, String folderName, String fileName) {
		try {
			waitUntil(fileCreated(projectName, folderName, fileName));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

	public JavaEditor openClass(String projectName, String sourceFolderName, String packageName,
			String className) {
		return getPackageExplorerView().openClass(projectName, sourceFolderName, packageName,
				className);
	}

	public FileEditor openFile(String projectName, String fileFolder, String fileName) {
		return getPackageExplorerView().openFile(projectName, fileFolder, fileName);
	}

	public DeleteFileShell deleteClass(String projectName, String sourceFolderName,
			String packageName,
			String className) {
		return getPackageExplorerView().deleteClass(projectName, sourceFolderName, packageName,
				className);
	}

	private PackageExplorerView getPackageExplorerView() {
		return new PackageExplorerView(this);
	}

	private SWTBotEditor getEditor(String editorTitle) {
		for (SWTBotEditor editor : editors()) {
			if (editor.getTitle().equals(editorTitle))
				return editor;
		}
		return null;
	}
}