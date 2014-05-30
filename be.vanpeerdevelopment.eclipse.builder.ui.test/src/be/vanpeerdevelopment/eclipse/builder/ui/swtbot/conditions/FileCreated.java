package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class FileCreated extends DefaultWorkbenchCondition {

	private String projectName;
	private String folderName;
	private String fileName;

	FileCreated(String projectName, String folderName, String fileName) {
		this.projectName = projectName;
		this.folderName = folderName;
		this.fileName = fileName;
	}

	@Override
	public boolean test() throws Exception {
		return isFileCreated();
	}

	private boolean isFileCreated() {
		return bot.fileExists(projectName, folderName, fileName);
	}

	@Override
	public String getFailureMessage() {
		return "File with name " + fileName + " was not created in "
				+ projectName + "/" + folderName + ".";
	}
}