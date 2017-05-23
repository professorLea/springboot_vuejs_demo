# SpringVue Starter

> A Spring-Boot Vue.js project

# Installation

This app uses Vue.js, Spring Boot, Git, Npm and Webpack

* [vue](https://vuejs.org/)
* [spring boot](https://spring.io/guides/gs/spring-boot/)
* [webpack](https://webpack.js.org/)
* [git](https://git-scm.com/)

For detailed explanation on how things work, checkout the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

# Folders and Files
* build: Webpack specific folder lets us setup the build environment using files such as running ```npm build [dev|prod]```
   * build.js
   * dev-client.js
   * dev-server.js
   * utils.js
   * webpack.base.conf.js
   * webpack.dev.conf.js
   * webpack.prod.conf.js
* config: Configuration for environments
   * dev.env.js
   * index.js
   * prod.env.js
   * test.env.js
* src: Where are source code lives
* .babelrc: Babel specific used in webpack to turn es2015/es2016 code to ES5 code for older browsers to use
* .gitignore: Specify files in here for git to ignore
* package.json: Frontend dependency manager similar to pom.xml but for managing javascript apps
* pom.xml: Java backend dependency management

## NPM Registry Setup
```
config set registry https://registry.npmjs.org
```

## Build Setup

To run the front-end without the backend service(tomcat):

``` bash
# install frontend dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification - this will produce a dist/ folder.
npm run build [dev|prod]

# run unit tests
npm run unit

# run e2e tests - selenium
npm run e2e

# run all tests
npm test
```

To run spring boot app with built code from the parent(root pom) run:
```
mvn install && mvn --projects backend spring-boot:run
```


To setup run with Intellij:

* Run > Edit Configurations... > hit the plus sign to create a new entry > select maven 
* Name the new entry as ```spring-boot:run```
* Set Working Directory to ```/Users/<yourUserName>/IdeaProjects/app```
* Set Command Line to ```-projects backend spring-boot:run```
