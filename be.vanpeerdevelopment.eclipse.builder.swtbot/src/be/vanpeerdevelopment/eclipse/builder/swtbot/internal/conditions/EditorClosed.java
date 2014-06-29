package be.vanpeerdevelopment.eclipse.builder.swtbot.internal.conditions;

class EditorClosed extends DefaultWorkbenchCondition {

	private String editorTitle;

	public EditorClosed(String editorTitle) {
		this.editorTitle = editorTitle;
	}

	@Override
	public boolean test() throws Exception {
		return isEditorClosed();
	}

	private boolean isEditorClosed() {
		return !bot.isEditorOpen(editorTitle);
	}

	@Override
	public String getFailureMessage() {
		return "Editor with title " + editorTitle + " did not close.";
	}
}