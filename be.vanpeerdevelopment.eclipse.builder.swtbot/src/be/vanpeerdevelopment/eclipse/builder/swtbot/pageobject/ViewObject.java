package be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.viewClosed;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions.ConditionFactory.viewOpened;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

import be.vanpeerdevelopment.eclipse.builder.swtbot.internal.utils.Workbench;

public abstract class ViewObject extends EclipseObject {

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