package be.vanpeerdevelopment.eclipse.builder.ui.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.fileCreated;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;
import static org.junit.Assert.assertNotNull;
import be.vanpeerdevelopment.eclipse.builder.ui.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class NewFileShell extends ShellObject {

	private String projectName;
	private String folderName;
	private String fileName;

	public NewFileShell(Workbench workbench) {
		super(workbench, "New File");
	}

	public NewFileShell setParentFolder(String projectName, String folderName) {
		this.projectName = projectName;
		this.folderName = folderName;
		workbench.textWithLabel("Enter or select the parent folder:")
				.setText(projectName + "/" + folderName);
		return this;
	}

	public NewFileShell setFileName(String fileName) {
		this.fileName = fileName;
		workbench.textWithLabel("File name:").setText(fileName);
		return this;
	}

	public void finish() {
		assertNotNull("First set the project name using setParentFolder()", projectName);
		assertNotNull("First set the folder name using setParentFolder()", folderName);
		assertNotNull("First set the file name using setFileName()", fileName);
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New File"));
		workbench.waitUntil(fileCreated(projectName, folderName, fileName));
	}
}