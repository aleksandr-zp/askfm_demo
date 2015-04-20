java -jar .\lib\selenium-server-standalone-2.45.0.jar -role node -hub http://localhost:4444/grid/register -port 5556 -"Dwebdriver.chrome.driver"=".\lib\chromedriver.exe" -browser "browserName=chrome,maxInstances=1,platform=WINDOWS" -browser "browserName=firefox,maxInstances=1,platform=WINDOWS"

