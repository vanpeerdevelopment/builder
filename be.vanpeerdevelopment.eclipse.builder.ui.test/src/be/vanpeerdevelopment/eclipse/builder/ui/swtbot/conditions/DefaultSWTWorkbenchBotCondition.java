package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.ICondition;

abstract class DefaultSWTWorkbenchBotCondition implements ICondition {

	protected SWTWorkbenchBot bot;

	@Override
	public void init(SWTBot bot) {
		if (!SWTWorkbenchBot.class.isAssignableFrom(bot.getClass()))
			throw new IllegalArgumentException("The given swt bot is not a swt workbench bot.");
		this.bot = (SWTWorkbenchBot) bot;
	}
}