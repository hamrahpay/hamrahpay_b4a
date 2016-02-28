package b4a.hamrahpay;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class payment_activity_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,24);
if (RapidSub.canDelegate("activity_create")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 24;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,56);
if (RapidSub.canDelegate("activity_pause")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","activity_pause", _userclosed);
RemoteObject _pay_status = RemoteObject.createImmutable(false);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 56;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="Dim pay_status As Boolean";
Debug.ShouldStop(16777216);
_pay_status = RemoteObject.createImmutable(false);Debug.locals.put("pay_status", _pay_status);
 BA.debugLineNum = 58;BA.debugLine="If UserClosed=True Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_userclosed,payment_activity.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 59;BA.debugLine="hamrahpay.verify_payment(hamrahpay.pay_code,hamr";
Debug.ShouldStop(67108864);
payment_activity.mostCurrent._hamrahpay.runVoidMethod ("_verify_payment",payment_activity.mostCurrent.activityBA,(Object)(payment_activity.mostCurrent._hamrahpay._pay_code),(Object)(payment_activity.mostCurrent._hamrahpay._product_sku));
 };
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","activity_resume");
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="addressbar.Initialize(\"addressbar\")";
Debug.ShouldStop(268435456);
payment_activity.mostCurrent._addressbar.runVoidMethod ("Initialize",payment_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("addressbar")));
 BA.debugLineNum = 32;BA.debugLine="browser.Initialize(\"browser\")";
Debug.ShouldStop(-2147483648);
payment_activity.mostCurrent._browser.runVoidMethod ("Initialize",payment_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("browser")));
 BA.debugLineNum = 33;BA.debugLine="browser.JavaScriptEnabled = True";
Debug.ShouldStop(1);
payment_activity.mostCurrent._browser.runMethod(true,"setJavaScriptEnabled",payment_activity.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 35;BA.debugLine="WebChromeClient.Initialize(\"WebChromeClient\")";
Debug.ShouldStop(4);
payment_activity.mostCurrent._webchromeclient.runVoidMethod ("Initialize",payment_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("WebChromeClient")));
 BA.debugLineNum = 36;BA.debugLine="WebClient.Initialize(\"WebClient\")";
Debug.ShouldStop(8);
payment_activity.mostCurrent._webclient.runVoidMethod ("Initialize",payment_activity.mostCurrent.activityBA,(Object)(RemoteObject.createImmutable("WebClient")));
 BA.debugLineNum = 38;BA.debugLine="sett.Initialize(browser)";
Debug.ShouldStop(32);
payment_activity.mostCurrent._sett.runVoidMethod ("Initialize",(Object)((payment_activity.mostCurrent._browser.getObject())));
 BA.debugLineNum = 39;BA.debugLine="sett.GetSettings.SetDOMStorageEnabled(True)";
Debug.ShouldStop(64);
payment_activity.mostCurrent._sett.runMethod(false,"GetSettings").runVoidMethod ("SetDOMStorageEnabled",(Object)(payment_activity.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 42;BA.debugLine="sett.SetWebChromeClient(WebChromeClient)";
Debug.ShouldStop(512);
payment_activity.mostCurrent._sett.runVoidMethod ("SetWebChromeClient",(Object)((payment_activity.mostCurrent._webchromeclient.getObject())));
 BA.debugLineNum = 45;BA.debugLine="Activity.AddView(sett, 0, 4%y, 100%x, 100%y)";
Debug.ShouldStop(4096);
payment_activity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((payment_activity.mostCurrent._sett.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(payment_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 4)),payment_activity.mostCurrent.activityBA)),(Object)(payment_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),payment_activity.mostCurrent.activityBA)),(Object)(payment_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 100)),payment_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 46;BA.debugLine="sett.LoadUrl(hamrahpay.pay_url)";
Debug.ShouldStop(8192);
payment_activity.mostCurrent._sett.runVoidMethod ("LoadUrl",(Object)(payment_activity.mostCurrent._hamrahpay._pay_url));
 BA.debugLineNum = 47;BA.debugLine="addressbar.Text=hamrahpay.pay_url";
Debug.ShouldStop(16384);
payment_activity.mostCurrent._addressbar.runMethod(true,"setText",(payment_activity.mostCurrent._hamrahpay._pay_url));
 BA.debugLineNum = 48;BA.debugLine="addressbar.Color=Colors.LightGray";
Debug.ShouldStop(32768);
payment_activity.mostCurrent._addressbar.runVoidMethod ("setColor",payment_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"LightGray"));
 BA.debugLineNum = 49;BA.debugLine="addressbar.TextColor=Colors.Black";
Debug.ShouldStop(65536);
payment_activity.mostCurrent._addressbar.runMethod(true,"setTextColor",payment_activity.mostCurrent.__c.getField(false,"Colors").getField(true,"Black"));
 BA.debugLineNum = 52;BA.debugLine="Activity.AddView(addressbar,0,0,100%x,6%y)";
Debug.ShouldStop(524288);
payment_activity.mostCurrent._activity.runVoidMethod ("AddView",(Object)((payment_activity.mostCurrent._addressbar.getObject())),(Object)(BA.numberCast(int.class, 0)),(Object)(BA.numberCast(int.class, 0)),(Object)(payment_activity.mostCurrent.__c.runMethod(true,"PerXToCurrent",(Object)(BA.numberCast(float.class, 100)),payment_activity.mostCurrent.activityBA)),(Object)(payment_activity.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 6)),payment_activity.mostCurrent.activityBA)));
 BA.debugLineNum = 53;BA.debugLine="ProgressDialogShow2(\"لطفا صبور باشید...\",False";
Debug.ShouldStop(1048576);
payment_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogShow2",payment_activity.mostCurrent.activityBA,(Object)(BA.ObjectToString("لطفا صبور باشید...")),(Object)(payment_activity.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 54;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _browser_overrideurl(RemoteObject _url) throws Exception{
try {
		Debug.PushSubsStack("browser_OverrideUrl (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,72);
if (RapidSub.canDelegate("browser_overrideurl")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","browser_overrideurl", _url);
Debug.locals.put("Url", _url);
 BA.debugLineNum = 72;BA.debugLine="Sub browser_OverrideUrl (Url As String) As Boolean";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="addressbar.Text = Url";
Debug.ShouldStop(256);
payment_activity.mostCurrent._addressbar.runMethod(true,"setText",(_url));
 BA.debugLineNum = 74;BA.debugLine="browser.LoadUrl(Url)";
Debug.ShouldStop(512);
payment_activity.mostCurrent._browser.runVoidMethod ("LoadUrl",(Object)(_url));
 BA.debugLineNum = 76;BA.debugLine="If (Url.ToLowerCase.Contains(\"shaparak.ir\") And U";
Debug.ShouldStop(2048);
if ((RemoteObject.solveBoolean(".",_url.runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("shaparak.ir")))) && RemoteObject.solveBoolean(".",_url.runMethod(true,"toLowerCase").runMethod(true,"startsWith",(Object)(RemoteObject.createImmutable("https://")))))) { 
 BA.debugLineNum = 77;BA.debugLine="addressbar.Color=Colors.RGB(90,162,43)";
Debug.ShouldStop(4096);
payment_activity.mostCurrent._addressbar.runVoidMethod ("setColor",payment_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 90)),(Object)(BA.numberCast(int.class, 162)),(Object)(BA.numberCast(int.class, 43))));
 BA.debugLineNum = 78;BA.debugLine="addressbar.SetTextColorAnimated(0,Colors.RGB(255";
Debug.ShouldStop(8192);
payment_activity.mostCurrent._addressbar.runVoidMethod ("SetTextColorAnimated",(Object)(BA.numberCast(int.class, 0)),(Object)(payment_activity.mostCurrent.__c.getField(false,"Colors").runMethod(true,"RGB",(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)),(Object)(BA.numberCast(int.class, 255)))));
 };
 BA.debugLineNum = 81;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
Debug.ShouldStop(65536);
if (_url.runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("exit_page"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 82;BA.debugLine="Activity_Pause(True)";
Debug.ShouldStop(131072);
_activity_pause(payment_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 85;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
Debug.ShouldStop(1048576);
if (_url.runMethod(true,"toLowerCase").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("exit_page"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 86;BA.debugLine="Activity_Pause(True)";
Debug.ShouldStop(2097152);
_activity_pause(payment_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 90;BA.debugLine="Return True";
Debug.ShouldStop(33554432);
if (true) return payment_activity.mostCurrent.__c.getField(true,"True");
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private browser As WebView";
payment_activity.mostCurrent._browser = RemoteObject.createNew ("anywheresoftware.b4a.objects.WebViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private addressbar As Label";
payment_activity.mostCurrent._addressbar = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Dim WebChromeClient As DefaultWebChromeClient";
payment_activity.mostCurrent._webchromeclient = RemoteObject.createNew ("uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient");
 //BA.debugLineNum = 19;BA.debugLine="Dim WebClient As DefaultWebViewClient";
payment_activity.mostCurrent._webclient = RemoteObject.createNew ("uk.co.martinpearman.b4a.webkit.DefaultWebViewClient");
 //BA.debugLineNum = 20;BA.debugLine="Dim sett As WebViewExtras";
payment_activity.mostCurrent._sett = RemoteObject.createNew ("uk.co.martinpearman.b4a.webkit.WebViewExtras");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,94);
if (RapidSub.canDelegate("jobdone")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","jobdone", _job);
Debug.locals.put("Job", _job);
 BA.debugLineNum = 94;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 95;BA.debugLine="hamrahpay.JobDone(Job)";
Debug.ShouldStop(1073741824);
payment_activity.mostCurrent._hamrahpay.runVoidMethod ("_jobdone",payment_activity.mostCurrent.activityBA,(Object)(_job));
 BA.debugLineNum = 96;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _webchromeclient_progresschanged(RemoteObject _newprogress) throws Exception{
try {
		Debug.PushSubsStack("WebChromeClient_ProgressChanged (payment_activity) ","payment_activity",2,payment_activity.mostCurrent.activityBA,payment_activity.mostCurrent,64);
if (RapidSub.canDelegate("webchromeclient_progresschanged")) return payment_activity.remoteMe.runUserSub(false, "payment_activity","webchromeclient_progresschanged", _newprogress);
Debug.locals.put("NewProgress", _newprogress);
 BA.debugLineNum = 64;BA.debugLine="Sub WebChromeClient_ProgressChanged(NewProgress As";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 65;BA.debugLine="If NewProgress=100 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("=",_newprogress,BA.numberCast(double.class, 100))) { 
 BA.debugLineNum = 66;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(2);
payment_activity.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 67;BA.debugLine="sett.Visible = False";
Debug.ShouldStop(4);
payment_activity.mostCurrent._sett.runMethod(true,"setVisible",payment_activity.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 68;BA.debugLine="sett.Visible=True";
Debug.ShouldStop(8);
payment_activity.mostCurrent._sett.runMethod(true,"setVisible",payment_activity.mostCurrent.__c.getField(true,"True"));
 };
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
}