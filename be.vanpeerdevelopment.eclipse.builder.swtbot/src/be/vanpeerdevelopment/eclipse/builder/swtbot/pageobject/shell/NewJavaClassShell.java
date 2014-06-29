package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.classCreated;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.shellClosed;
import static org.junit.Assert.assertNotNull;
import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.ShellObject;

public class NewJavaClassShell extends ShellObject {

	private String projectName;
	private String sourceFolderName;
	private String packageName;
	private String className;

	public NewJavaClassShell(Workbench workbench) {
		super(workbench, "New Java Class");
	}

	public NewJavaClassShell setSourceFolder(String projectName, String sourceFolderName) {
		this.projectName = projectName;
		this.sourceFolderName = sourceFolderName;
		workbench.textWithLabel("Source folder:").setText(projectName + "/" + sourceFolderName);
		return this;
	}

	public NewJavaClassShell setPackage(String packageName) {
		this.packageName = packageName;
		workbench.textWithLabel("Package:").setText(packageName);
		return this;
	}

	public NewJavaClassShell setClassName(String className) {
		this.className = className;
		workbench.textWithLabel("Name:").setText(className);
		return this;
	}

	public void finish() {
		assertNotNull("First set the project name using setSourceFolder()", projectName);
		assertNotNull("First set the source folder name using setSourceFolder()", sourceFolderName);
		assertNotNull("First set the package name using setPackage()", packageName);
		assertNotNull("First set the class name using setClassName()", className);
		workbench.button("Finish").click();
		workbench.waitUntil(shellClosed("New Java Class"));
		workbench.waitUntil(classCreated(projectName, sourceFolderName, packageName, className));
	}
}