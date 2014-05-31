package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.eclipse.jface.bindings.keys.KeyStroke.getInstance;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.ALT;
import static org.eclipse.swtbot.swt.finder.keyboard.Keystrokes.CTRL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.jface.bindings.keys.ParseException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.shell.PreferencesShell.KeysPreferencesShell;

public class KeyBindingEndToEndTest extends EndToEndTest {

	@Test
	public void keyBindingActiveInJavaEditorScope() throws ParseException {
		eclipse
				.openClass(JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME)
				.pressShortcut(CTRL, ALT, getInstance("B"));

		assertTrue(eclipse.willGenerateBuilderShellOpen());

		eclipse
				.selectGenerateBuilderShell()
				.ok();
	}

	@Test
	public void keyBindingNotActiveInNonJavaEditorScope() throws ParseException {
		eclipse
				.openFile(JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME)
				.pressShortcut(CTRL, ALT, getInstance("B"));

		assertFalse(eclipse.willGenerateBuilderShellOpen());
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