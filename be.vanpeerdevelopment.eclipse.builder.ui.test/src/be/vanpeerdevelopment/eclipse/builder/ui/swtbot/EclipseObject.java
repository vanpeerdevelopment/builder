package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

public abstract class EclipseObject {

	protected Workbench workbench;

	protected EclipseObject(Workbench workbench) {
		this.workbench = workbench;
	}
}