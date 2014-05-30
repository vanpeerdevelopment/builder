package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class ClassCreated extends DefaultWorkbenchCondition {

	private String projectName;
	private String sourceFolderName;
	private String packageName;
	private String className;

	ClassCreated(String projectName, String sourceFolderName, String packageName, String className) {
		this.projectName = projectName;
		this.sourceFolderName = sourceFolderName;
		this.packageName = packageName;
		this.className = className;
	}

	@Override
	public boolean test() throws Exception {
		return isClassCreated();
	}

	private boolean isClassCreated() {
		return bot.classExists(projectName, sourceFolderName, packageName, className);
	}

	@Override
	public String getFailureMessage() {
		return "Class with name " + className + " was not created in "
				+ projectName + "/" + sourceFolderName + "/" + packageName + ".";
	}
}