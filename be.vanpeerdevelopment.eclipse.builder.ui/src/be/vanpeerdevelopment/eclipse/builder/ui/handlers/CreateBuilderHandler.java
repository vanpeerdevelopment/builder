package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import static org.eclipse.jface.dialogs.MessageDialog.openInformation;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class CreateBuilderHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		openInformation(
				null,
				"Create Builder",
				"A builder class will be generated for the active class.");
		return null;
	}

}