package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

class ViewClosed extends DefaultWorkbenchCondition {

	private String viewName;

	ViewClosed(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public boolean test() {
		return viewClosed();
	}

	private boolean viewClosed() {
		for (SWTBotView view : bot.views()) {
			if (view.getTitle().equals(viewName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getFailureMessage() {
		return "View with name " + viewName + " did not close.";
	}
}