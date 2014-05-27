package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

public class ShellClosed extends DefaultCondition {

	private String shellName;

	private ShellClosed(String shellName) {
		this.shellName = shellName;
	}

	@Override
	public boolean test() {
		return shellClosed();
	}

	private boolean shellClosed() {
		for (SWTBotShell shell : bot.shells()) {
			if (shell.getText().equals(shellName)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getFailureMessage() {
		return "Shell with name " + shellName + " did not close.";
	}

	public static ShellClosed shellClosed(String shellName) {
		return new ShellClosed(shellName);
	}
}