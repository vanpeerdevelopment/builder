package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject;

import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;

public abstract class EclipseObject {

	protected Workbench workbench;

	protected EclipseObject(Workbench workbench) {
		this.workbench = workbench;
	}
}