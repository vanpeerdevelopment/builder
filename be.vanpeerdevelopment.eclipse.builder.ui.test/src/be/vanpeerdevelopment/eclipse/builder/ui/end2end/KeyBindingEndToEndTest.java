package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.ALT;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.CTRL;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.key;
import static org.fest.assertions.Assertions.assertThat;

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

		assertThat(eclipse
				.willClassBeCreated(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder"))
				.isTrue();

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

		assertThat(eclipse
				.willFileBeCreated(
						JAVA_PROJECT_NAME,
						TEXT_FILE_FOLDER,
						TEXT_FILE_NAME + "Builder" + TEXT_FILE_EXTENSION))
				.isFalse();
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

		assertThat(generateBuilderMenuText).contains("Ctrl+Alt+B");
	}

	@Test
	public void keyBindingAddedInPreferencesInDefaultScheme() throws InterruptedException {
		KeysPreferencesShell keysPreferencesShell = eclipse
				.windowMenu()
				.preferences()
				.generalKeys()
				.setScheme("Default");

		assertThat(keysPreferencesShell.containsCommand("Generate Builder")).isTrue();
		assertThat(keysPreferencesShell.getCommandName("Generate Builder")).isEqualTo("Generate Builder");
		assertThat(keysPreferencesShell.getDescription("Generate Builder"))
				.isEqualTo("A builder class will be generated for the active class.");
		assertThat(keysPreferencesShell.getKeyBinding("Generate Builder")).isEqualTo("Ctrl+Alt+B");
		assertThat(keysPreferencesShell.getWhenActive("Generate Builder")).isEqualTo("Editing Java Source");
		assertThat(keysPreferencesShell.getCategory("Generate Builder")).isEqualTo("Source");

		keysPreferencesShell
				.cancel();
	}
}