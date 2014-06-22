package be.vanpeerdevelopment.eclipse.builder.ui.pageobject;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public abstract class EclipseObject {

	protected Workbench workbench;

	protected EclipseObject(Workbench workbench) {
		this.workbench = workbench;
	}
}