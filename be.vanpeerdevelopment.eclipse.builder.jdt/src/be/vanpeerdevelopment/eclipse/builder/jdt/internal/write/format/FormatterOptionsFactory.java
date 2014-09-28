package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.format;

import static org.eclipse.jdt.core.JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM;
import static org.eclipse.jdt.core.JavaCore.COMPILER_COMPLIANCE;
import static org.eclipse.jdt.core.JavaCore.COMPILER_SOURCE;
import static org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants.getEclipseDefaultSettings;

import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;

public class FormatterOptionsFactory {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getFormatterOptions(IJavaProject project) {
		Map options = getEclipseDefaultSettings();
		options.put(COMPILER_CODEGEN_TARGET_PLATFORM, getCompilerCodegenTargetPlatform(project));
		options.put(COMPILER_SOURCE, getCompilerSource(project));
		options.put(COMPILER_COMPLIANCE, getCompilerCompliance(project));
		return options;
	}

	private String getCompilerCodegenTargetPlatform(IJavaProject project) {
		return project.getOption(COMPILER_CODEGEN_TARGET_PLATFORM, true);
	}

	private String getCompilerSource(IJavaProject project) {
		return project.getOption(COMPILER_SOURCE, true);
	}

	private String getCompilerCompliance(IJavaProject project) {
		return project.getOption(COMPILER_COMPLIANCE, true);
	}
}