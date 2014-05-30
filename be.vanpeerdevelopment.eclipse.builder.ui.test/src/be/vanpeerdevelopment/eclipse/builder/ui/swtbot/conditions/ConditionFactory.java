package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

public class ConditionFactory {

	public static PerspectiveOpened perspectiveOpened(String perspectiveName) {
		return new PerspectiveOpened(perspectiveName);
	}

	public static ShellOpened shellOpened(String shellName) {
		return new ShellOpened(shellName);
	}

	public static ShellClosed shellClosed(String shellName) {
		return new ShellClosed(shellName);
	}

	public static ViewOpened viewOpened(String viewTitle) {
		return new ViewOpened(viewTitle);
	}

	public static ViewClosed viewClosed(String viewTitle) {
		return new ViewClosed(viewTitle);
	}

	public static ProjectCreated projectCreated(String projectName) {
		return new ProjectCreated(projectName);
	}

	public static FileCreated fileCreated(String projectName, String folderName, String fileName) {
		return new FileCreated(projectName, folderName, fileName);
	}

	public static ClassCreated classCreated(String projectName, String sourceFolderName,
			String packageName, String className) {
		return new ClassCreated(projectName, sourceFolderName, packageName, className);
	}

	public static EditorOpened editorOpened(String editorTitle) {
		return new EditorOpened(editorTitle);
	}

	public static EditorClosed editorClosed(String editorTitle) {
		return new EditorClosed(editorTitle);
	}
}