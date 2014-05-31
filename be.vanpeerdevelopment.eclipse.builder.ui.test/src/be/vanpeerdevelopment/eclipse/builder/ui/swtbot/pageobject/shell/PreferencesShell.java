package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ConditionFactory.shellClosed;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.ShellObject;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

public class PreferencesShell extends ShellObject {

	public PreferencesShell(Workbench workbench) {
		super(workbench, "Preferences");
	}

	public KeysPreferencesShell generalKeys() {
		workbench.tree().expandNode("General").select("Keys");
		return new KeysPreferencesShell(workbench);
	}

	public void cancel() {
		workbench.button("Cancel").click();
		workbench.waitUntil(shellClosed("Preferences"));
	}

	public static class KeysPreferencesShell extends PreferencesShell {

		private static final int INDEX_OF_COMMAND_TREE = 1;

		public KeysPreferencesShell(Workbench workbench) {
			super(workbench);
		}

		public KeysPreferencesShell setScheme(String scheme) {
			workbench.comboBoxWithLabel("Scheme:").setSelection(scheme);
			return this;
		}

		public KeysPreferencesShell selectCommand(String commandName) {
			workbench.tree(INDEX_OF_COMMAND_TREE).select(commandName);
			return this;
		}

		public boolean containsCommand(String commandName) {
			return indexOfCommand(commandName) != -1;
		}

		public String getCommandName(String commandName) {
			return workbench
					.tree(INDEX_OF_COMMAND_TREE)
					.cell(indexOfCommand(commandName), "Command");
		}

		public String getDescription(String commandName) {
			selectCommand(commandName);
			return workbench.textWithLabel("Description:").getText();
		}

		public String getKeyBinding(String commandName) {
			return workbench
					.tree(INDEX_OF_COMMAND_TREE)
					.cell(indexOfCommand(commandName), "Binding");
		}

		public String getWhenActive(String commandName) {
			return workbench
					.tree(INDEX_OF_COMMAND_TREE)
					.cell(indexOfCommand(commandName), "When");
		}

		public String getCategory(String commandName) {
			return workbench
					.tree(INDEX_OF_COMMAND_TREE)
					.cell(indexOfCommand(commandName), "Category");
		}

		private int indexOfCommand(String commandName) {
			SWTBotTreeItem[] allCommands = workbench.tree(INDEX_OF_COMMAND_TREE).getAllItems();
			for (int i = 0; i < allCommands.length; i++) {
				if (allCommands[i].getText().equals(commandName))
					return i;
			}
			return -1;
		}
	}
}