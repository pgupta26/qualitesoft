set Project=%1
echo %Project%
set XmlFile=%2
echo %XmlFile%.xml
set Recording=%3
set JENKINS_HOME=%4
set BUILD_NUMBER=%5


RMDIR .\screen-shots /S /Q

java -cp .\lib\*;.\bin org.testng.TestNG .\xml-config-files\%Project%\%XmlFile%.xml -DisRecording=%Recording%

jar -cfM screen-shots.zip screen-shots

Xcopy screen-shots.zip %JENKINS_HOME%\jobs\QS_Automation\builds\%BUILD_NUMBER%

pause
