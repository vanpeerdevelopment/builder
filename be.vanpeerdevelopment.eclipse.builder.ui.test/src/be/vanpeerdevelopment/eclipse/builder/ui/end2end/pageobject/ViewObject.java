package be.vanpeerdevelopment.eclipse.builder.ui.end2end.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.viewClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.viewOpened;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils.Workbench;

public class ViewObject extends EclipseObject {

	protected String viewTitle;
	protected SWTBotView view;

	protected ViewObject(Workbench workbench, String viewTitle) {
		super(workbench);
		this.viewTitle = viewTitle;
		workbench.waitUntil(viewOpened(viewTitle));
		view = workbench.viewByTitle(viewTitle);
		view.show();
	}

	public void close() {
		view.close();
		workbench.waitUntil(viewClosed(viewTitle));
	}
}