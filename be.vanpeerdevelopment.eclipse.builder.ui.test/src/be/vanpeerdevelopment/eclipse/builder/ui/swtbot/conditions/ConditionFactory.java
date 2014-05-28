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

	public static ViewClosed viewClosed(String viewName) {
		return new ViewClosed(viewName);
	}
}