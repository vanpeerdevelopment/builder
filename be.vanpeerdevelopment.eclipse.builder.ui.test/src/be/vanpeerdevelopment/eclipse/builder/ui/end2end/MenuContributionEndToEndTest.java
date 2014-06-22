package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static org.eclipse.jface.bindings.keys.KeyStroke.getInstance;
import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.jface.bindings.keys.ParseException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.SWTBotTest;
import be.vanpeerdevelopment.eclipse.builder.ui.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.pageobject.editor.JavaEditor.SourceContextMenu;

public class MenuContributionEndToEndTest extends SWTBotTest {

	private static final String UNDERLINED_B = "&B";

	@Test
	public void menuContributionAddedToSourceMenu() {
		SourceContextMenu sourceContextMenu = eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.sourceContextMenu();

		assertTrue(sourceContextMenu.containsGenerateBuilder());
	}

	@Test
	public void menuContributionAddedToSourceMenuHasMnemonic() {
		String generateBuilderMenuText = eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.sourceContextMenu()
				.generateBuilderMenuText();

		assertThat(generateBuilderMenuText).contains(UNDERLINED_B);
	}

	@Test
	public void menuContributionAddedToSourceMenuAfterGenerateConstructorsFromSuperClass() {
		SourceContextMenu sourceContextMenu = eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.sourceContextMenu();

		assertTrue(sourceContextMenu
				.isGenerateBuilderAddedAfterGenerateConstructorsFromSuperClass());
	}

	@Test
	public void menuContributionActiveInJavaEditorScope() {
		eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.sourceContextMenu()
				.generateBuilder();

		assertTrue(eclipse.willClassBeCreated(
				JAVA_PROJECT_NAME,
				JAVA_SOURCE_FOLDER_NAME,
				JAVA_PACKAGE_NAME,
				JAVA_CLASS_NAME + "Builder"));

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder")
				.ok();
	}

	@Test
	public void menuContributionMnemonicActiveInJavaEditorScope() throws ParseException {
		eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.openContextMenu()
				.pressShortcut(getInstance("S"))
				.pressShortcut(getInstance("B"));

		assertTrue(eclipse.willClassBeCreated(
				JAVA_PROJECT_NAME,
				JAVA_SOURCE_FOLDER_NAME,
				JAVA_PACKAGE_NAME,
				JAVA_CLASS_NAME + "Builder"));

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder")
				.ok();
	}

	@Test
	public void menuContributionNotActiveInNonJavaEditorScope() {
		FileEditor fileEditor = eclipse
				.openFile(
						JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME_WITH_EXTENSION);

		assertFalse(fileEditor.hasGenerateBuilderInSourceContextMenu());
	}
}