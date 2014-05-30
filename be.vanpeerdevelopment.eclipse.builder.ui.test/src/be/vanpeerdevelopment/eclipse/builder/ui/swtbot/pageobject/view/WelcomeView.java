package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ViewObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class WelcomeView extends ViewObject {

	public WelcomeView(Workbench workbench) {
		super(workbench, "Welcome");
	}
}