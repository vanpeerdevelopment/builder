package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class ShellClosed extends DefaultWorkbenchCondition {

	private String shellName;

	ShellClosed(String shellName) {
		this.shellName = shellName;
	}

	@Override
	public boolean test() {
		return isShellClosed();
	}

	private boolean isShellClosed() {
		return !bot.isShellOpen(shellName);
	}

	@Override
	public String getFailureMessage() {
		return "Shell with name " + shellName + " did not close.";
	}
}