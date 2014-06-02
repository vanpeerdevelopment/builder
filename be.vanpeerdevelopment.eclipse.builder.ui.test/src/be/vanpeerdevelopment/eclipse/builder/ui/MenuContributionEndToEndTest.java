package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.swtbot.pageobject.editor.FileEditor;

public class MenuContributionEndToEndTest extends EndToEndTest {

	@Test
	public void menuContributionNotVisibleInNonJavaEditorScope() {
		FileEditor fileEditor = eclipse.openFile(
				JAVA_PROJECT_NAME,
				TEXT_FILE_FOLDER,
				TEXT_FILE_NAME);

		assertFalse(fileEditor.hasGenerateBuilderInSourceContextMenu());
	}
}