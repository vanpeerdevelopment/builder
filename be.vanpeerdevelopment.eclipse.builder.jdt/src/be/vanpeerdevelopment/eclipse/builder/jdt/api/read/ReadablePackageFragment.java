package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import org.eclipse.jdt.core.IPackageFragment;

public class ReadablePackageFragment {

	private IPackageFragment packageFragment;

	public ReadablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public String getName() {
		return packageFragment.getElementName();
	}
}