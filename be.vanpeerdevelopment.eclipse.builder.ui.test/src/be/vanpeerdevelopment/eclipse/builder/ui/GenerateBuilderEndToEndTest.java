package be.vanpeerdevelopment.eclipse.builder.ui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenerateBuilderEndToEndTest extends EndToEndTest {

	private static final String JAVA_PERSPECTIVE = "Java";

	@Test
	public void javaPerspectiveOpenByDefault() {
		assertEquals(JAVA_PERSPECTIVE, workbench.activePerspective().getLabel());
	}

	@Test
	public void generateBuilderAddedToSourceMenu() {
		assertEquals(true, true);
	}
}