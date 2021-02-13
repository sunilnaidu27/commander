Sleep(3000);
ControlFocus("Open","","Edit1");
ControlClick("Open","","Edit1");
ControlSetText("Open","","Edit1",@WorkingDir & "\SampleUploadFiles\image.jpeg");
Sleep(3000);
ControlClick("Open","","Button1");