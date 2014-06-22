package be.vanpeerdevelopment.eclipse.builder.ui.pageobject.view;

import be.vanpeerdevelopment.eclipse.builder.ui.pageobject.ViewObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class WelcomeView extends ViewObject {

	public WelcomeView(Workbench workbench) {
		super(workbench, "Welcome");
	}
}