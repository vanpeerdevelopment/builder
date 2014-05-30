package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.conditions;

class ProjectCreated extends DefaultWorkbenchCondition {

	private String projectName;

	ProjectCreated(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public boolean test() throws Exception {
		return isProjectCreated();
	}

	private boolean isProjectCreated() {
		return bot.projectExists(projectName);
	}

	@Override
	public String getFailureMessage() {
		return "Project with name " + projectName + " was not created.";
	}
}