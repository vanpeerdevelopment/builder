package be.vanpeerdevelopment.eclipse.builder.ui.swtbot.utils;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.withMnemonic;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.hamcrest.Matcher;

public class MenuItemAddedAfterMenuItemPredicate {

	private String menuItemToCheck;
	private String menuItemToBeAfter;

	private MenuItemAddedAfterMenuItemPredicate(String menuItemToCheck) {
		this.menuItemToCheck = menuItemToCheck;
	}

	public static MenuItemAddedAfterMenuItemPredicate is(String menuItemToCheck) {
		return new MenuItemAddedAfterMenuItemPredicate(menuItemToCheck);
	}

	public MenuItemAddedAfterMenuItemPredicate addedAfter(String menuItemToBeAfter) {
		this.menuItemToBeAfter = menuItemToBeAfter;
		return this;
	}

	public boolean in(final SWTBotMenu containingMenu) {
		return syncExec(containingMenu.display, new Result<Boolean>() {
			@Override
			public Boolean run() {
				int indexToBeAfter = getIndexOfMenuItem(menuItemToBeAfter, containingMenu);
				int indexToCheck = getIndexOfMenuItem(menuItemToCheck, containingMenu);
				return indexToBeAfter != -1
						&& indexToCheck != -1
						&& indexToBeAfter + 1 == indexToCheck;
			}

			private int getIndexOfMenuItem(String menuName, SWTBotMenu containingMenu) {
				int result = -1;
				Menu menu = containingMenu.widget.getMenu();
				Matcher<MenuItem> withMnemonic = withMnemonic(menuName);
				menu.notifyListeners(SWT.Show, new Event());
				MenuItem[] menuItems = menu.getItems();
				for (int i = 0; i < menuItems.length; i++) {
					if (isSeparator(menuItems[i]))
						continue;
					if (withMnemonic.matches(menuItems[i]))
						result = i;
				}
				menu.notifyListeners(SWT.Hide, new Event());
				return result;
			}

			private boolean isSeparator(MenuItem menuItem) {
				return (menuItem.getStyle() & SWT.SEPARATOR) != 0;
			}
		});
	}
}