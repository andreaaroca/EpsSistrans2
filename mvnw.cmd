@ECHO OFF
SET BASE_DIR=%~dp0
SET WRAPPER_DIR=%BASE_DIR%\.mvn\wrapper
SET JAR=%WRAPPER_DIR%\maven-wrapper.jar
IF NOT EXIST "%JAR%" (
  ECHO Downloading Maven Wrapper JAR...
  mkdir "%WRAPPER_DIR%"
  powershell -Command "Invoke-WebRequest -Uri https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.5.6/maven-wrapper-0.5.6.jar -OutFile '%JAR%'"
)
java -jar "%JAR%" %*
