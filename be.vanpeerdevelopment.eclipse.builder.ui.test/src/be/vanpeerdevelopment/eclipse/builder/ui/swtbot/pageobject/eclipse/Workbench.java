package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

public class Workbench extends SWTWorkbenchBot {

	Workbench() {
	}

	public boolean isViewOpen(String viewTitle) {
		for (SWTBotView view : views()) {
			if (view.getTitle().equals(viewTitle)) {
				return true;
			}
		}
		return false;
	}

	public boolean isPerspectiveOpen(String perspectiveLabel) {
		return activePerspective().getLabel().equals(perspectiveLabel);
	}

	public boolean projectExists(String projectName) {
		for (SWTBotTreeItem project : getAllProjects()) {
			if (project.getText().equals(projectName)) {
				return true;
			}
		}
		return false;
	}

	public boolean classExists(String projectName, String sourceFolderName, String packageName,
			String className) {
		return projectExists(projectName)
				&& folderExistsInProject(projectName, sourceFolderName)
				&& packageExistsInFolderInProject(projectName, sourceFolderName, packageName)
				&& classExistsInPacakgeInFolderInProject(projectName, sourceFolderName,
						packageName, className);
	}

	public boolean fileExists(String projectName, String folderName, String fileName) {
		return projectExists(projectName)
				&& folderExistsInProject(projectName, folderName)
				&& fileExistsInFolderInProject(projectName, folderName, fileName);
	}

	private boolean folderExistsInProject(String projectName, String folderName) {
		return viewByTitle("Package Explorer")
				.bot()
				.tree()
				.expandNode(projectName)
				.getNodes()
				.contains(folderName);
	}

	private boolean packageExistsInFolderInProject(String projectName, String sourceFolderName,
			String packageName) {
		return itemExistsInFolderInProject(projectName, sourceFolderName, packageName);
	}

	private boolean fileExistsInFolderInProject(String projectName, String folderName,
			String fileName) {
		return itemExistsInFolderInProject(projectName, folderName, fileName);
	}

	private boolean itemExistsInFolderInProject(String projectName, String folderName,
			String itemName) {
		return viewByTitle("Package Explorer")
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(folderName)
				.getNodes()
				.contains(itemName);
	}

	private boolean classExistsInPacakgeInFolderInProject(String projectName,
			String sourceFolderName, String packageName, String className) {
		return viewByTitle("Package Explorer")
				.bot()
				.tree()
				.expandNode(projectName)
				.expandNode(sourceFolderName)
				.expandNode(packageName)
				.getNodes()
				.contains(className + ".java");
	}

	private SWTBotTreeItem[] getAllProjects() {
		return viewByTitle("Package Explorer")
				.bot()
				.tree()
				.getAllItems();
	}
}