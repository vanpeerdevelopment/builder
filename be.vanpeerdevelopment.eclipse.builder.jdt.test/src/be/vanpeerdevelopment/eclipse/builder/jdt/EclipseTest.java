package be.vanpeerdevelopment.eclipse.builder.jdt;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Eclipse.eclipse;
import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import org.eclipse.core.runtime.IPath;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import be.vanpeerdevelopment.eclipse.builder.swtbot.SWTBotTest;
import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.eclipse.Eclipse;

public abstract class EclipseTest extends SWTBotTest {

	protected static final String JAVA_PROJECT_NAME = "builder";
	protected static final String JAVA_SOURCE_FOLDER_NAME = "src";
	protected static final String JAVA_PACKAGE_NAME = "person";
	protected static final String JAVA_CLASS_NAME = "Person";

	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	protected static Eclipse eclipse;

	@BeforeClass
	public static void beforeTests() {
		eclipse = eclipse();
		closeWelcomeViewIfNeeded();
		openJavaPerspectiveIfNeeded();
		createJavaProjectIfNotExists();
		showlineNumbers();
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

	private static void showlineNumbers() {
		eclipse
				.windowMenu()
				.preferences()
				.generalTextEditors()
				.checkShowLineNumbers()
				.ok();
	}

	protected IPath getPackageLocation() {
		return getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME);
	}

	protected IPath javaClassLocation() {
		return getPackageLocation()
				.append(JAVA_CLASS_NAME + ".java");
	}

	protected void expectExceptionWithMessage(Class<? extends Throwable> exceptionClass, String message) {
		expectedException.expect(exceptionClass);
		expectedException.expectMessage(message);
	}
}