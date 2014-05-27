package be.vanpeerdevelopment.eclipse.builder.ui;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class EndToEndTest {

	protected static final String WELCOME_VIEW_TITLE = "Welcome";
	protected static final String JAVA_PERSPECTIVE_LABEL = "Java";

	protected static SWTWorkbenchBot workbench;

	@BeforeClass
	public static void beforeTests() {
		workbench = new SWTWorkbenchBot();
		closeWelcomeViewIfNeeded();
		openJavaPerspectiveIfNeeded();
	}

	private static void closeWelcomeViewIfNeeded() {
		if (isWelcomeViewOpen())
			closeWelcomeView();
	}

	private static boolean isWelcomeViewOpen() {
		for (SWTBotView view : workbench.views())
			if (view.getTitle().equals(WELCOME_VIEW_TITLE))
				return true;
		return false;
	}

	private static void closeWelcomeView() {
		workbench
				.viewByTitle(WELCOME_VIEW_TITLE)
				.close();
	}

	private static void openJavaPerspectiveIfNeeded() {
		if (!isJavaPerspectiveOpen())
			openJavaPerspective();
	}

	private static boolean isJavaPerspectiveOpen() {
		return workbench.activePerspective().getLabel().equals(JAVA_PERSPECTIVE_LABEL);
	}

	private static void openJavaPerspective() {
		workbench
				.menu("Window")
				.menu("Open Perspective")
				.menu("Other...")
				.click();
		workbench
				.shell("Open Perspective")
				.activate();
		workbench
				.table()
				.select("Java");
		workbench
				.button("OK")
				.click();
	}
}