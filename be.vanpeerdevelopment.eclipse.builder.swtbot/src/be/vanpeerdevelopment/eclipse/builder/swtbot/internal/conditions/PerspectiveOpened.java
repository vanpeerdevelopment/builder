package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions;

class PerspectiveOpened extends DefaultWorkbenchCondition {

	private String perspectiveName;

	PerspectiveOpened(String perspectiveName) {
		this.perspectiveName = perspectiveName;
	}

	@Override
	public boolean test() throws Exception {
		return isPerspectiveOpened();
	}

	private boolean isPerspectiveOpened() {
		return bot.isPerspectiveOpen(perspectiveName);
	}

	@Override
	public String getFailureMessage() {
		return "Perspective with name " + perspectiveName + " did not open.";
	}
}