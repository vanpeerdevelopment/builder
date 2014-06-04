##Tasks

- [ ] Develop
	- [x] Write end to end tests
	- [x] Complete pom (ci, issues, scm, ...)
	- [ ] Create target platform
	- [ ] Multiple plug-in projects providing a public api
	- [ ] Create external dependencies bundle (compile and test scope) to use normal maven dependencies
	- [ ] Configure travis to build project on windows, linux and mac

- [ ] Deploy
	- [ ] Create website on gh-pages branch (builder.vanpeerdevelopment.be) + add website in pom
	- [ ] Think about license, add in pom and feature
	- [ ] Check out https://bintray.com/, http://blog.bintray.com/2014/03/11/hosting-your-eclipse-update-site-p2-on-bintray-com/
	- [ ] Figure out how to deploy
		- [ ] Check out how to modify qualifier (tycho-packaging-plugin, buildnumber-maven-plugin)
		- [ ] Increase development version number (tycho versions plugin)
		- [ ] Create tag branch with release version (tycho versions plugin)
		- [ ] Sign the plugin, feature and update site 
		- [ ] Copy repository to website (latest version , old versions)
	
## Future
- [ ] Add menu contribution in main source menu and context source menu when right clicking on java class