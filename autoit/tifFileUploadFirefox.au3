
; It will wait for 8 seconds to appear File Upload dialog.
; Used Title property of File upload dialog window.

  WinWait("Select file(s) to upload by awstvw0.na.corp.clorox.com","",8)

; Set control focus to File name Input box of File Upload dialog.
; Used Class property of File upload dialog window and Class+Instance property for File name Input box.


;WinFlash("[CLASS:#32770]","", 4, 500)
WinFlash("Select file(s) to upload by awstvw0.na.corp.clorox.com","", 4, 500)



 ControlFocus("Select file(s) to upload by awstvw0.na.corp.clorox.com","","Edit1")

  Sleep(3000)


  ;ControlSetText("[CLASS:#32770]", "", "Edit1", "W:\Data\MediaBin\NI-19873_TEST_Image Asset TIF_AutoTest_U.tif")


  ControlSetText("Select file(s) to upload by awstvw0.na.corp.clorox.com", "", "Edit1",$CmdLine[1])

  Sleep(3000)


  ControlClick("Select file(s) to upload by awstvw0.na.corp.clorox.com", "","Button2");

