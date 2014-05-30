package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class EditorOpened extends DefaultWorkbenchCondition {

	private String editorTitle;

	public EditorOpened(String editorTitle) {
		this.editorTitle = editorTitle;
	}

	@Override
	public boolean test() throws Exception {
		return editorOpened();
	}

	private boolean editorOpened() {
		return bot.isEditorOpen(editorTitle);
	}

	@Override
	public String getFailureMessage() {
		return "Editor with title " + editorTitle + " did not open.";
	}
}