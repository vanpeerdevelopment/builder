package be.vanpeerdevelopment.eclipse.builder.ui;

import static be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Eclipse.eclipse;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.eclipse.Eclipse;

@RunWith(SWTBotJunit4ClassRunner.class)
public abstract class EndToEndTest {

	protected static final String JAVA_PROJECT_NAME = "Java Project";
	protected static final String REGULAR_PROJECT_NAME = "Regular Project";

	protected static Eclipse eclipse;

	@BeforeClass
	public static void beforeTests() {
		eclipse = eclipse();
		closeWelcomeViewIfNeeded();
		openJavaPerspectiveIfNeeded();
		createJavaProjectIfNotExists();
	}

	private static void closeWelcomeViewIfNeeded() {
		if (eclipse.isWelcomeViewOpen())
			closeWelcomeView();
	}

	private static void closeWelcomeView() {
		eclipse
				.selectWelcomeView()
				.close();
	}

	private static void openJavaPerspectiveIfNeeded() {
		if (!eclipse.isJavaPerspectiveOpen())
			openJavaPerspective();
	}

	private static void openJavaPerspective() {
		eclipse
				.windowMenu()
				.openPerspective()
				.other()
				.java();
	}

	private static void createJavaProjectIfNotExists() {
		if (!eclipse.projectExists(JAVA_PROJECT_NAME))
			createJavaProject();
	}

	private static void createJavaProject() {
		eclipse
				.fileMenu()
				.newSubMenu()
				.other()
				.javaProject()
				.setProjectName(JAVA_PROJECT_NAME)
				.finish();
	}
}