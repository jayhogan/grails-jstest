class JstestGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.1 > *"
    def dependsOn = [:]
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "JSTest Plugin"
    def author = "Jay Hogan"
    def authorEmail = "seeker136@gmail.com"
    def description = 'Execute Javascript unit tests written in Jasmine, QUnit or YUI Test using PhantomJS.'
//    def documentation = "http://grails.org/plugin/grails-jstest"
    def license = "APACHE"
    def issueManagement = [ system: "GitHub", url: "https://github.com/jayhogan/grails-jstest/issues" ]
    def scm = [ url: "https://github.com/jayhogan/grails-jstest" ]
}
