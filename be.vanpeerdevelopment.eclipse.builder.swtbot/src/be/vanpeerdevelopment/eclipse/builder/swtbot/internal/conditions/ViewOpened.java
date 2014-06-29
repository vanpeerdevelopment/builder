package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions;

class ViewOpened extends DefaultWorkbenchCondition {

	private String viewTitle;

	ViewOpened(String viewTitle) {
		this.viewTitle = viewTitle;
	}

	@Override
	public boolean test() {
		return isViewOpenend();
	}

	private boolean isViewOpenend() {
		return bot.isViewOpen(viewTitle);
	}

	@Override
	public String getFailureMessage() {
		return "View with title " + viewTitle + " did not open.";
	}
}