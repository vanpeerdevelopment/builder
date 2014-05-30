package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view.PackageExplorerView;

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

	private PackageExplorerView getPackageExplorerView() {
		return new PackageExplorerView(this);
	}
}