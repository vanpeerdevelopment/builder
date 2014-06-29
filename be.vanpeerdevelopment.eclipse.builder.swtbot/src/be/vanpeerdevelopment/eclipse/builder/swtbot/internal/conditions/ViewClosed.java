package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions;

class ViewClosed extends DefaultWorkbenchCondition {

	private String viewTitle;

	ViewClosed(String viewTitle) {
		this.viewTitle = viewTitle;
	}

	@Override
	public boolean test() {
		return isViewClosed();
	}

	private boolean isViewClosed() {
		return !bot.isViewOpen(viewTitle);
	}

	@Override
	public String getFailureMessage() {
		return "View with title " + viewTitle + " did not close.";
	}
}