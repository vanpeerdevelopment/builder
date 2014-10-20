package be.vanpeerdevelopment.eclipse.builder.ui.end2end;

import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.ALT;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.CTRL;
import static be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut.Key.key;
import static org.apache.commons.lang3.StringUtils.uncapitalize;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.jface.bindings.keys.ParseException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.ui.EclipseTest;

public class GenerateBuilderHandlerEndToEndTest extends EclipseTest {

	@Test
	public void generateBuilder() throws ParseException {
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
		assertThat(eclipse.willEditorBeOpened(JAVA_CLASS_NAME + "Builder.java")).isTrue();
		assertThat(eclipse.isEditorActive(JAVA_CLASS_NAME + "Builder.java")).isTrue();
		assertThat(eclipse
				.openClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder")
				.getText())
				.isEqualTo(new StringBuilder()
						.append("package " + JAVA_PACKAGE_NAME + ";\n")
						.append("\n")
						.append("public class " + JAVA_CLASS_NAME + "Builder {\n")
						.append("\tprivate " + JAVA_CLASS_NAME + " " + uncapitalize(JAVA_CLASS_NAME) + ";")
						.append("\n}")
						.toString());

		eclipse
				.deleteClass(
						JAVA_PROJECT_NAME,
						JAVA_SOURCE_FOLDER_NAME,
						JAVA_PACKAGE_NAME,
						JAVA_CLASS_NAME + "Builder")
				.ok();
	}
}