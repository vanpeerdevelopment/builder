package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.view;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.ViewObject;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject.editor.JavaEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class PackageExplorerView extends ViewObject {

	public PackageExplorerView(Workbench workbench) {
		super(workbench, "Package Explorer");
	}

	public boolean projectExists(String projectName) {
		for (SWTBotTreeItem project : getAllProjects()) {
			if (project.getText().equals(projectName)) {
				return true;
			}
		}
		return false;
	}

	public boolean fileExists(String projectName, String folderName, String fileName) {
		return projectExists(projectName)
				&& folderExistsInProject(projectName, folderName)
				&& fileExistsInFolderInProject(projectName, folderName, fileName);
	}

	public boolean classExists(String projectName, String sourceFolderName, String packageName,
			String className) {
		return projectExists(projectName)
				&& folderExistsInProject(projectName, sourceFolderName)
				&& packageExistsInFolderInProject(projectName, sourceFolderName, packageName)
				&& classExistsInPacakgeInFolderInProject(projectName, sourceFolderName,
						packageName, className);
	}

	public JavaEditor openClass(String projectName, String sourceFolderName, String packageName,
			String className) {
		view
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(sourceFolderName)
				.expandNode(packageName)
				.getNode(className + ".java")
				.doubleClick();
		return new JavaEditor(workbench, className);
	}

	public FileEditor openFile(String projectName, String fileFolder, String fileName) {
		view
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(fileFolder)
				.getNode(fileName)
				.doubleClick();
		return new FileEditor(workbench, fileName);
	}

	private SWTBotTreeItem[] getAllProjects() {
		return view
				.bot()
				.tree()
				.getAllItems();
	}

	private boolean folderExistsInProject(String projectName, String folderName) {
		return view
				.bot()
				.tree()
				.expandNode(projectName)
				.getNodes()
				.contains(folderName);
	}

	private boolean fileExistsInFolderInProject(String projectName, String folderName,
			String fileName) {
		return itemExistsInFolderInProject(projectName, folderName, fileName);
	}

	private boolean packageExistsInFolderInProject(String projectName, String sourceFolderName,
			String packageName) {
		return itemExistsInFolderInProject(projectName, sourceFolderName, packageName);
	}

	private boolean itemExistsInFolderInProject(String projectName, String folderName,
			String itemName) {
		return view
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(folderName)
				.getNodes()
				.contains(itemName);
	}

	private boolean classExistsInPacakgeInFolderInProject(String projectName,
			String sourceFolderName, String packageName, String className) {
		return view
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(sourceFolderName)
				.expandNode(packageName)
				.getNodes()
				.contains(className + ".java");
	}
}