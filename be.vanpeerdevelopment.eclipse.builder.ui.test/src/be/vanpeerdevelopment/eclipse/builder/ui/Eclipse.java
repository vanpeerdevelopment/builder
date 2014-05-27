package be.vanpeerdevelopment.eclipse.builder.ui;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;

public class Eclipse {

	public static final String JAVA_PERSPECTIVE_LABEL = "Java";
	public static final String WELCOME_VIEW_TITLE = "Welcome";

	private SWTWorkbenchBot workbenchBot;

	private Eclipse() {
		this.workbenchBot = new SWTWorkbenchBot();
	}

	public void closeWelcomeViewIfNeeded() {
		if (isWelcomeViewOpen())
			closeWelcomeView();
	}

	public boolean isWelcomeViewOpen() {
		for (SWTBotView view : workbenchBot.views()) {
			if (view.getTitle().equals(WELCOME_VIEW_TITLE)) {
				return true;
			}
		}
		return false;
	}

	private void closeWelcomeView() {
		workbenchBot
				.viewByTitle(WELCOME_VIEW_TITLE)
				.close();
	}

	public void openJavaPerspectiveIfNeeded() {
		if (!isJavaPerspectiveOpen())
			openJavaPerspective();
	}

	public boolean isJavaPerspectiveOpen() {
		return workbenchBot.activePerspective().getLabel().equals(JAVA_PERSPECTIVE_LABEL);
	}

	private void openJavaPerspective() {
		workbenchBot
				.menu("Window")
				.menu("Open Perspective")
				.menu("Other...")
				.click();
		workbenchBot
				.shell("Open Perspective")
				.activate();
		workbenchBot
				.table()
				.select("Java");
		workbenchBot
				.button("OK")
				.click();
	}

	public static Eclipse eclipse() {
		return new Eclipse();
	}
}