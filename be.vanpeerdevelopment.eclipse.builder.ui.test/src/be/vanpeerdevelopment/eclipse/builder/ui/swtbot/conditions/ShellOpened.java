package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class ShellOpened extends DefaultWorkbenchCondition {

	private String shellName;

	ShellOpened(String shellName) {
		this.shellName = shellName;
	}

	@Override
	public boolean test() {
		return isShellOpened();
	}

	private boolean isShellOpened() {
		return bot.isShellOpen(shellName);
	}

	@Override
	public String getFailureMessage() {
		return "Shell with name " + shellName + " did not open.";
	}
}