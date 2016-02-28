package b4a.hamrahpay;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_click() throws Exception{
try {
		Debug.PushSubsStack("Activity_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,49);
if (RapidSub.canDelegate("activity_click")) return main.remoteMe.runUserSub(false, "main","activity_click");
 BA.debugLineNum = 49;BA.debugLine="Sub Activity_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,35);
if (RapidSub.canDelegate("activity_create")) return main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 38;BA.debugLine="Activity.LoadLayout(\"paybtn\")";
Debug.ShouldStop(32);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("paybtn")),main.mostCurrent.activityBA);
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) return main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) return main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 28;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 31;BA.debugLine="Private pay_btn As Button";
main.mostCurrent._pay_btn = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,70);
if (RapidSub.canDelegate("jobdone")) return main.remoteMe.runUserSub(false, "main","jobdone", _job);
Debug.locals.put("Job", _job);
 BA.debugLineNum = 70;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="hamrahpay.JobDone(Job)";
Debug.ShouldStop(64);
main.mostCurrent._hamrahpay.runVoidMethod ("_jobdone",main.mostCurrent.activityBA,(Object)(_job));
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pay_btn_click() throws Exception{
try {
		Debug.PushSubsStack("pay_btn_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,53);
if (RapidSub.canDelegate("pay_btn_click")) return main.remoteMe.runUserSub(false, "main","pay_btn_click");
 BA.debugLineNum = 53;BA.debugLine="Sub pay_btn_Click";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="If hamrahpay.IsConnected=False Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",main.mostCurrent._hamrahpay.runMethod(true,"_isconnected",main.mostCurrent.activityBA),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 55;BA.debugLine="ToastMessageShow(\"دستگاه شما به اینترنت متصل نمی";
Debug.ShouldStop(4194304);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("دستگاه شما به اینترنت متصل نمیباشد . لطفا از صحت اتصال به اینترنت اطمینان حاصل فرمایید.")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 57;BA.debugLine="hamrahpay.pay_request(product_sku,Me)";
Debug.ShouldStop(16777216);
main.mostCurrent._hamrahpay.runVoidMethod ("_pay_request",main.mostCurrent.activityBA,(Object)(main._product_sku),(Object)(main.getObject()));
 };
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pay_status_click() throws Exception{
try {
		Debug.PushSubsStack("pay_status_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("pay_status_click")) return main.remoteMe.runUserSub(false, "main","pay_status_click");
 BA.debugLineNum = 62;BA.debugLine="Sub	pay_status_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="If hamrahpay.isPayed(product_sku)=True Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",main.mostCurrent._hamrahpay.runMethod(true,"_ispayed",main.mostCurrent.activityBA,(Object)(main._product_sku)),main.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 64;BA.debugLine="ToastMessageShow(\"پرداخت انجام شده است\",True)";
Debug.ShouldStop(-2147483648);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("پرداخت انجام شده است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 }else {
 BA.debugLineNum = 66;BA.debugLine="ToastMessageShow(\"پرداختی انجام نشده است\",True)";
Debug.ShouldStop(2);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString("پرداختی انجام نشده است")),(Object)(main.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
hamrahpay_subs_0._process_globals();
payment_activity_subs_0._process_globals();
statemanager_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.hamrahpay.main");
hamrahpay.myClass = BA.getDeviceClass ("b4a.hamrahpay.hamrahpay");
payment_activity.myClass = BA.getDeviceClass ("b4a.hamrahpay.payment_activity");
statemanager.myClass = BA.getDeviceClass ("b4a.hamrahpay.statemanager");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 16;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 20;BA.debugLine="Dim product_sku As String";
main._product_sku = RemoteObject.createImmutable("");
 //BA.debugLineNum = 23;BA.debugLine="product_sku = \"hp_55202faf1ddd8901148214\"";
main._product_sku = BA.ObjectToString("hp_55202faf1ddd8901148214");
 //BA.debugLineNum = 26;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
}