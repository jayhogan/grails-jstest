class GrailsJstestGrailsPlugin {
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

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        // TODO Implement runtime spring config (optional)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
