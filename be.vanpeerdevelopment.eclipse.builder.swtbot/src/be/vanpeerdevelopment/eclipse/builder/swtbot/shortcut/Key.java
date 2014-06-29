package be.vanpeerdevelopment.eclipse.builder.swtbot.shortcut;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;

public class Key {

	public final static Key CTRL = new Key(Keystrokes.CTRL);
	public final static Key ALT = new Key(Keystrokes.ALT);
	public final static Key SHIFT = new Key(Keystrokes.SHIFT);
	public final static Key F10 = new Key(Keystrokes.F10);

	private KeyStroke key;

	private Key(KeyStroke key) {
		this.key = key;
	}

	public KeyStroke getKey() {
		return key;
	}

	public static Key key(String key) {
		try {
			return new Key(KeyStroke.getInstance(key));
		} catch (ParseException e) {
			throw new RuntimeException("Not able to parse " + key + " to a keystroke.");
		}
	}

	public static KeyStroke[] toKeyStrokes(Key... keys) {
		KeyStroke[] result = new KeyStroke[keys.length];
		for (int i = 0; i < keys.length; i++) {
			result[i] = keys[i].getKey();
		}
		return result;
	}
}