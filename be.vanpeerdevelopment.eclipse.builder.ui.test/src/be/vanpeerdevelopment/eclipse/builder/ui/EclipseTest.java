package be.vanpeerdevelopment.eclipse.builder.ui;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Eclipse.eclipse;

import org.junit.BeforeClass;

import be.vanpeerdevelopment.eclipse.builder.swtbot.SWTBotTest;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Eclipse;

public abstract class EclipseTest extends SWTBotTest {

	protected static final String JAVA_PROJECT_NAME = "builder";
	protected static final String JAVA_SOURCE_FOLDER_NAME = "src";
	protected static final String JAVA_PACKAGE_NAME = "person";
	protected static final String JAVA_CLASS_NAME = "Person";
	protected static final String TEXT_FILE_FOLDER = "resources";
	protected static final String TEXT_FILE_NAME = "builder-todo-list";
	protected static final String TEXT_FILE_EXTENSION = ".txt";
	protected static final String TEXT_FILE_NAME_WITH_EXTENSION = TEXT_FILE_NAME
			+ TEXT_FILE_EXTENSION;

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
		if (!eclipse.projectExists(JAVA_PROJECT_NAME)) {
			createJavaProject();
			createJavaClassInJavaProject();
			createTextFileInJavaProject();
		}
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

	private static void createJavaClassInJavaProject() {
		eclipse
				.fileMenu()
				.newSubMenu()
				.other()
				.javaClass()
				.setSourceFolder(JAVA_PROJECT_NAME, JAVA_SOURCE_FOLDER_NAME)
				.setPackage(JAVA_PACKAGE_NAME)
				.setClassName(JAVA_CLASS_NAME)
				.finish();
	}

	private static void createTextFileInJavaProject() {
		eclipse
				.fileMenu()
				.newSubMenu()
				.other()
				.file()
				.setParentFolder(JAVA_PROJECT_NAME, TEXT_FILE_FOLDER)
				.setFileName(TEXT_FILE_NAME_WITH_EXTENSION)
				.finish();
	}

}