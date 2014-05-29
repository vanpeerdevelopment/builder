package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public abstract class EclipseObject {

	protected Workbench workbench;

	protected EclipseObject(Workbench workbench) {
		this.workbench = workbench;
	}
}