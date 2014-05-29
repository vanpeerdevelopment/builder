package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.view;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.viewClosed;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.EclipseObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class WelcomeView extends EclipseObject {

	public static final String WELCOME_VIEW_TITLE = "Welcome";

	private SWTBotView welcomeView;

	public WelcomeView(Workbench workbench) {
		super(workbench);
		welcomeView = workbench.viewByTitle(WELCOME_VIEW_TITLE);
	}

	public void close() {
		welcomeView.close();
		workbench.waitUntil(viewClosed(WELCOME_VIEW_TITLE));
	}
}