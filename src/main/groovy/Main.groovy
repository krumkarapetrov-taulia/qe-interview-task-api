def scriptFile = new File('../../test/groovy/requests/ToDoTests.groovy')

if (scriptFile.exists()) {
  def shell = new GroovyShell()
  def result = shell.evaluate(scriptFile)
  println "Test script executed successfully."
} else {
  println "Test script file does not exist."
}