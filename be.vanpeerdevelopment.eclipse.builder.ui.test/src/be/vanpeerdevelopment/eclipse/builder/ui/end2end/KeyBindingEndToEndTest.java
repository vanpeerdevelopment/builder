package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.ALT;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.CTRL;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.key;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.jface.bindings.keys.ParseException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.swtbot.pageobject.shell.PreferencesShell.KeysPreferencesShell;
import be.vanpeerdevelopment.eclipse.builder.ui.EclipseTest;

public class KeyBindingEndToEndTest extends EclipseTest {

	@Test
	public void keyBindingActiveInJavaEditorScope() throws ParseException {
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.pressShortcut(CTRL, ALT, key("B"));

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
	public void keyBindingNotActiveInNonJavaEditorScope() throws ParseException {
		eclipse
				.openFile(JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME_WITH_EXTENSION)
				.pressShortcut(CTRL, ALT, key("B"));

		assertFalse(eclipse.willFileBeCreated(
				JAVA_PROJECT_NAME,
				TEXT_FILE_FOLDER,
				TEXT_FILE_NAME + "Builder" + TEXT_FILE_EXTENSION));
	}

	@Test
	public void keyBindingVisibleInSourceMenu() {
		String generateBuilderMenuText = eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.sourceContextMenu()
				.generateBuilderMenuText();

		assertTrue(generateBuilderMenuText.contains("Ctrl+Alt+B"));
	}

	@Test
	public void keyBindingAddedInPreferencesInDefaultScheme() throws InterruptedException {
		KeysPreferencesShell keysPreferencesShell = eclipse
				.windowMenu()
				.preferences()
				.generalKeys()
				.setScheme("Default");

		assertTrue(keysPreferencesShell.containsCommand("Generate Builder"));
		assertEquals(
				"Generate Builder",
				keysPreferencesShell.getCommandName("Generate Builder"));
		assertEquals(
				"A builder class will be generated for the active class.",
				keysPreferencesShell.getDescription("Generate Builder"));
		assertEquals(
				"Ctrl+Alt+B",
				keysPreferencesShell.getKeyBinding("Generate Builder"));
		assertEquals(
				"Editing Java Source",
				keysPreferencesShell.getWhenActive("Generate Builder"));
		assertEquals(
				"Source",
				keysPreferencesShell.getCategory("Generate Builder"));

		keysPreferencesShell
				.cancel();
	}
}