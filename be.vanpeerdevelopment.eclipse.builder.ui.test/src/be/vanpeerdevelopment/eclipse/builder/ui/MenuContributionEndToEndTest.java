package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.FileEditor;
import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.JavaEditor.SourceContextMenu;

public class MenuContributionEndToEndTest extends EndToEndTest {

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

		assertTrue(generateBuilderMenuText.contains(UNDERLINED_B));
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

		assertTrue(eclipse.willGenerateBuilderShellOpen());

		eclipse
				.selectGenerateBuilderShell()
				.ok();
	}

	@Test
	public void menuContributionNotActiveInNonJavaEditorScope() {
		FileEditor fileEditor = eclipse
				.openFile(
						JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME);

		assertFalse(fileEditor.hasGenerateBuilderInSourceContextMenu());
	}
}