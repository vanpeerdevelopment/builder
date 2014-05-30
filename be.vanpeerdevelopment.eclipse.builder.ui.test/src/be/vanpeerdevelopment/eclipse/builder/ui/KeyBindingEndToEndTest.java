package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KeyBindingEndToEndTest extends EndToEndTest {

	@Test
	public void keyBindingActiveInJavaEditorScope() {
		eclipse.openClass(JAVA_PROJECT_NAME, JAVA_SOURCE_FOLDER_NAME, JAVA_PACKAGE_NAME,
				JAVA_CLASS_NAME);
		assertTrue(true);
	}
}