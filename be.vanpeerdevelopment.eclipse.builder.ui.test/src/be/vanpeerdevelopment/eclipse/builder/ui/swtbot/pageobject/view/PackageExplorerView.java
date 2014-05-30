package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.JavaEditor;

public class PackageExplorerView extends EclipseObject {

	public static final String PACKAGE_EXPLORER_VIEW_TITLE = "Package Explorer";

	private SWTBotView packageExplorerView;

	public PackageExplorerView(Workbench workbench) {
		super(workbench);
		packageExplorerView = workbench.viewByTitle(PACKAGE_EXPLORER_VIEW_TITLE);
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
		packageExplorerView
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(sourceFolderName)
				.expandNode(packageName)
				.getNode(className + ".java")
				.doubleClick();
		return new JavaEditor(workbench, className);
	}

	private SWTBotTreeItem[] getAllProjects() {
		return packageExplorerView
				.bot()
				.tree()
				.getAllItems();
	}

	private boolean folderExistsInProject(String projectName, String folderName) {
		return packageExplorerView
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
		return packageExplorerView
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(folderName)
				.getNodes()
				.contains(itemName);
	}

	private boolean classExistsInPacakgeInFolderInProject(String projectName,
			String sourceFolderName, String packageName, String className) {
		return packageExplorerView
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(sourceFolderName)
				.expandNode(packageName)
				.getNodes()
				.contains(className + ".java");
	}
}