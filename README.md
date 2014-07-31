builder [![Build Status](https://travis-ci.org/vanpeerdevelopment/builder.svg?branch=master)](https://travis-ci.org/vanpeerdevelopment/builder)
=======

The builder eclipse plug-in helps Java developers in writing builders. The plugin will generate all the code for the builder based upon a selected class.

assumptions
-----------
- Exactly one type exists in the compilation unit for which the builder needs to be generated. Otherwise a JdtReadExcepion will be thrown in the method getOnlyType in ReadableCompilationUnit.