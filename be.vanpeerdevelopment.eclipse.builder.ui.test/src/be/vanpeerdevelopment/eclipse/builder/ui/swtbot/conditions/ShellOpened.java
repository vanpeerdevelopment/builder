package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

class ShellOpened extends DefaultCondition {

	private String shellName;

	ShellOpened(String shellName) {
		this.shellName = shellName;
	}

	@Override
	public boolean test() {
		return shellOpened();
	}

	private boolean shellOpened() {
		for (SWTBotShell shell : bot.shells()) {
			if (shell.getText().equals(shellName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getFailureMessage() {
		return "Shell with name " + shellName + " did not open.";
	}
}