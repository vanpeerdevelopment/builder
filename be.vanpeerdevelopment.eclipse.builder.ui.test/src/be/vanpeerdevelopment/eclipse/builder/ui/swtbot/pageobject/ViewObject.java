package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.viewClosed;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class ViewObject extends EclipseObject {

	protected String viewTitle;
	protected SWTBotView view;

	protected ViewObject(Workbench workbench, String viewTitle) {
		super(workbench);
		this.viewTitle = viewTitle;
		view = workbench.viewByTitle(viewTitle);
	}

	public void close() {
		view.close();
		workbench.waitUntil(viewClosed(viewTitle));
	}
}