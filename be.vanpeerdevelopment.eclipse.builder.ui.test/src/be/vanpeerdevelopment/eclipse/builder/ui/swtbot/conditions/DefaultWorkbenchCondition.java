package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.ICondition;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Workbench;

abstract class DefaultWorkbenchCondition implements ICondition {

	protected Workbench bot;

	@Override
	public void init(SWTBot bot) {
		if (!Workbench.class.isAssignableFrom(bot.getClass()))
			throw new IllegalArgumentException("The given swt bot is not a workbench.");
		this.bot = (Workbench) bot;
	}
}