set Project=%1
set XmlFile=%2
set Recording=%3
set JENKINS_HOME=%4
set BUILD_NUMBER=%5
set JOB_NAME=%6

cd %JENKINS_HOME%\workspace\%JOB_NAME%

RMDIR .\screen-shots /S /Q

java -cp .\lib\*;.\bin org.testng.TestNG .\xml-config-files\%Project%\%XmlFile%.xml -DisRecording=%Recording%

jar -cfM screen-shots.zip screen-shots

Xcopy screen-shots.zip %JENKINS_HOME%\jobs\QS_Automation\builds\%BUILD_NUMBER%

pause
