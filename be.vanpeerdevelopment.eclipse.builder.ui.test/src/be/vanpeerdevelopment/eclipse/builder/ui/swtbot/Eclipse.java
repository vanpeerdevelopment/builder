package be.vanpeerdevelopment.eclipse.builder.ui.swtbot;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.PerspectiveOpened.perspectiveOpened;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ShellClosed.shellClosed;
import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions.ViewClosed.viewClosed;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

public class Eclipse {

	public static final String JAVA_PERSPECTIVE_LABEL = "Java";
	public static final String WELCOME_VIEW_TITLE = "Welcome";
	public static final String JAVA_PROJECT_NAME = "Java Project";

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
		workbenchBot.waitUntil(viewClosed(WELCOME_VIEW_TITLE));

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
		workbenchBot.waitUntil(perspectiveOpened(JAVA_PERSPECTIVE_LABEL));
	}

	public void createJavaProjectIfNotExists() {
		if (!javaProjectExists())
			createJavaProject();
	}

	public boolean javaProjectExists() {
		for (SWTBotTreeItem project : getAllProjects()) {
			if (project.getText().equals(JAVA_PROJECT_NAME)) {
				return true;
			}
		}
		return false;
	}

	private SWTBotTreeItem[] getAllProjects() {
		return workbenchBot
				.viewByTitle("Package Explorer")
				.bot()
				.tree()
				.getAllItems();
	}

	private void createJavaProject() {
		workbenchBot
				.menu("File")
				.menu("New")
				.menu("Other...")
				.click();
		workbenchBot
				.shell("New")
				.activate();
		workbenchBot
				.tree()
				.expandNode("Java")
				.select(JAVA_PROJECT_NAME);
		workbenchBot
				.button("Next >")
				.click();
		workbenchBot
				.textWithLabel("Project name:")
				.setText(JAVA_PROJECT_NAME);
		workbenchBot
				.button("Finish")
				.click();
		workbenchBot.waitUntil(shellClosed("New Java Project"));
	}

	public static Eclipse eclipse() {
		return new Eclipse();
	}
}