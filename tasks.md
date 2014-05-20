##Tasks

- [x] Create GitHub Repository
- [x] Create Eclipse plug-in projects
- [x] Transform to tycho build
- [ ] Check out how to setup target platform in tycho build instead of p2 repository to make build platform independent
- [x] Setup travis-ci

##Reminders

- [ ] Check whether target platforms are only required for applications/products

- [ ] Separate plugin projects for ui, core, jdt + dependencies between plugins
- [ ] Find out how to name packages (internal vs exposed)

- [ ] How to use travis to make a release (maybe ftp, vogella - tycho): increase development version, create tag branch with release version, build tag branch and sign and publish on site
- [ ] Sign the plugin, feature and update site
- [ ] Check out how to modify the qualifier to for instance the git commit timestamp (vogella - tycho)
- [ ] Use tycho versions plugin to create new SNAPSHOT or RELEASE version
- [ ] Automatically create tag on git

- [ ] Setup website to host plug-in + make it available at builder.vanpeerdevelopment.be