package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class CompilationUnitTest extends UnitTest {

	@Test
	public void getName() {
		String name = "Person";
		CompilationUnit compilationUnit = aCompilationUnit()
				.withName(name)
				.build();

		String result = compilationUnit.getName();

		assertThat(result).isEqualTo(name);
	}

	@Test
	public void getNameWithExtension() {
		String name = "Person";
		CompilationUnit compilationUnit = aCompilationUnit()
				.withName(name)
				.build();

		String result = compilationUnit.getNameWithExtension();

		assertThat(result).isEqualTo(name + ".java");
	}

	@Test
	public void getPackageDeclaration() {
		PackageDeclaration packageDeclaration = aPackageDeclaration().build();
		CompilationUnit compilationUnit = aCompilationUnit()
				.withPackageDeclaration(packageDeclaration)
				.build();

		PackageDeclaration result = compilationUnit.getPackageDeclaration();

		assertThat(result).isEqualTo(packageDeclaration);
	}
}