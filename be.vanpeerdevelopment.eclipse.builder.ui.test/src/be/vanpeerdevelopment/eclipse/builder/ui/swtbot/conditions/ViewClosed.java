package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;


class ViewClosed extends DefaultWorkbenchCondition {

	private String viewName;

	ViewClosed(String viewName) {
		this.viewName = viewName;
	}

	@Override
	public boolean test() {
		return isViewClosed();
	}

	private boolean isViewClosed() {
		return !bot.isViewOpen(viewName);
	}

	@Override
	public String getFailureMessage() {
		return "View with name " + viewName + " did not close.";
	}
}