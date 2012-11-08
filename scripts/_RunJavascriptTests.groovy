def testsDir = "${basedir}/test/js"
def targetDir = "${basedir}/target/test-reports/plain"
def testResourcesDir = "${basedir}/resources/jasmine"

target(runJasmineTests: 'Runs Jasmine Tests') {
    event("StatusUpdate", ["Starting Jasmine test phase"])

    def specsToRun = []
    new File(testsDir).eachFileRecurse {
        if (it.name.endsWith(".html")) {
            specsToRun << it
        }
    }

    def startTime = new Date()
    def failures = 0
    def buildPassed = true
    specsToRun.each { File testFile ->
        println "Running ${testFile.name}..."
        def outputFile = "${targetDir}/TEST-${testFile.name.replace('-', '').replace('.html', '.xml')}"
        ant.exec(outputproperty: "cmdOut", errorproperty: "cmdErr", resultproperty: "cmdExit", failonerror: "false",
                executable: "C:/dev/tools/phantomjs-1.7.0/phantomjs.exe", dir: "${basedir}") {
            arg(line: "${testResourcesDir}/phantomjs-jasmine-runner.js")
            arg(line: "${testFile.canonicalPath}")
        }
        if (ant.project.properties.cmdExit != "0") {
            buildPassed = false
            println "\tFAILED!"
            failures++
        } else {
            println "\tPASSED"
        }
        new File(outputFile).write(ant.project.properties.cmdOut)
    }

    println "-------------------------------------------------------"
    println "Jasmine Tests Completed in ${new Date().time - startTime.time}ms"
    def msg = "Jasmine Tests ${buildPassed ? "PASSED" : "FAILED"} - view reports in ${targetDir}"
    println "-------------------------------------------------------"
    event("StatusFinal", [msg])
    return buildPassed ? 0 : 1
}
