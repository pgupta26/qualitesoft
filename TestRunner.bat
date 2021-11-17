cd C:\Users\SONY\git\qualitesoft

set Project=%1

echo %Project%

set XmlFile=%2

echo %XmlFile%.xml

java -cp .\lib\*;.\bin org.testng.TestNG .\xml-config-files\%Project%\%XmlFile%.xml

pause
