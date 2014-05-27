package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotPerspective;

public class PerspectiveOpened extends DefaultSWTWorkbenchBotCondition {

	private String perspectiveName;

	private PerspectiveOpened(String perspectiveName) {
		this.perspectiveName = perspectiveName;
	}

	@Override
	public boolean test() throws Exception {
		return perspectiveOpened();
	}

	private boolean perspectiveOpened() {
		for (SWTBotPerspective perspective : bot.perspectives()) {
			if (perspective.getLabel().equals(perspectiveName)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getFailureMessage() {
		return "Perspective with name " + perspectiveName + " did not open.";
	}

	public static PerspectiveOpened perspectiveOpened(String perspectiveName) {
		return new PerspectiveOpened(perspectiveName);
	}
}