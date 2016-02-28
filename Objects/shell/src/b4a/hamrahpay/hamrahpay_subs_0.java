package b4a.hamrahpay;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class hamrahpay_subs_0 {


public static RemoteObject  _activate_app(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("activate_app (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,223);
if (RapidSub.canDelegate("activate_app")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","activate_app", _ba);
;
 BA.debugLineNum = 223;BA.debugLine="Sub activate_app()";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 227;BA.debugLine="MakePayed(product_sku)";
Debug.ShouldStop(4);
_makepayed(_ba,hamrahpay._product_sku);
 BA.debugLineNum = 228;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ارت";
Debug.ShouldStop(8);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."),hamrahpay._product_sku)),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 229;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _getdeviceid(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetDeviceId (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,49);
if (RapidSub.canDelegate("getdeviceid")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","getdeviceid", _ba);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _id = RemoteObject.createImmutable("");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _api = RemoteObject.createImmutable(0);
RemoteObject _pid = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone.PhoneId");
;
 BA.debugLineNum = 49;BA.debugLine="Sub GetDeviceId As String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="Dim P As Phone";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("P", _p);
 BA.debugLineNum = 51;BA.debugLine="Dim id As String";
Debug.ShouldStop(262144);
_id = RemoteObject.createImmutable("");Debug.locals.put("id", _id);
 BA.debugLineNum = 52;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(524288);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 53;BA.debugLine="Dim Api As Int";
Debug.ShouldStop(1048576);
_api = RemoteObject.createImmutable(0);Debug.locals.put("Api", _api);
 BA.debugLineNum = 54;BA.debugLine="Dim pID As PhoneId";
Debug.ShouldStop(2097152);
_pid = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone.PhoneId");Debug.locals.put("pID", _pid);
 BA.debugLineNum = 56;BA.debugLine="id = pID.GetDeviceId";
Debug.ShouldStop(8388608);
_id = _pid.runMethod(true,"GetDeviceId");Debug.locals.put("id", _id);
 BA.debugLineNum = 57;BA.debugLine="Api = r.GetStaticField(\"android.os.Build$VERSIO";
Debug.ShouldStop(16777216);
_api = BA.numberCast(int.class, _r.runMethod(false,"GetStaticField",(Object)(BA.ObjectToString("android.os.Build$VERSION")),(Object)(RemoteObject.createImmutable("SDK_INT"))));Debug.locals.put("Api", _api);
 BA.debugLineNum = 58;BA.debugLine="If id==Null Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("n",_id)) { 
 BA.debugLineNum = 59;BA.debugLine="If Api < 9 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("<",_api,BA.numberCast(double.class, 9))) { 
 BA.debugLineNum = 61;BA.debugLine="id= P.GetSettings(\"android_id\")";
Debug.ShouldStop(268435456);
_id = _p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id")));Debug.locals.put("id", _id);
 }else {
 BA.debugLineNum = 65;BA.debugLine="id= r.GetStaticField(\"android.os.Build\", \"S";
Debug.ShouldStop(1);
_id = BA.ObjectToString(_r.runMethod(false,"GetStaticField",(Object)(BA.ObjectToString("android.os.Build")),(Object)(RemoteObject.createImmutable("SERIAL"))));Debug.locals.put("id", _id);
 BA.debugLineNum = 66;BA.debugLine="If id.ToLowerCase = \"unknown\" Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",_id.runMethod(true,"toLowerCase"),BA.ObjectToString("unknown"))) { 
 BA.debugLineNum = 67;BA.debugLine="id= P.GetSettings(\"android_id\")";
Debug.ShouldStop(4);
_id = _p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id")));Debug.locals.put("id", _id);
 };
 BA.debugLineNum = 70;BA.debugLine="If id.ToLowerCase = \"9774d56d682e549c\" Or id =";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_id.runMethod(true,"toLowerCase"),BA.ObjectToString("9774d56d682e549c")) || RemoteObject.solveBoolean("n",_id)) { 
_id = _p.runMethod(true,"GetSettings",(Object)(RemoteObject.createImmutable("android_id")));Debug.locals.put("id", _id);};
 };
 };
 BA.debugLineNum = 74;BA.debugLine="Return id";
Debug.ShouldStop(512);
if (true) return _id;
 BA.debugLineNum = 75;BA.debugLine="End Sub";
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
public static RemoteObject  _getprimaryemail(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("GetPrimaryEmail (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,30);
if (RapidSub.canDelegate("getprimaryemail")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","getprimaryemail", _ba);
RemoteObject _email_address = RemoteObject.createImmutable("");
RemoteObject _r = RemoteObject.declareNull("anywheresoftware.b4a.agraham.reflection.Reflection");
RemoteObject _accounts = null;
int _i = 0;
;
 BA.debugLineNum = 30;BA.debugLine="Sub	GetPrimaryEmail As String";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 31;BA.debugLine="Dim	email_address As String";
Debug.ShouldStop(1073741824);
_email_address = RemoteObject.createImmutable("");Debug.locals.put("email_address", _email_address);
 BA.debugLineNum = 32;BA.debugLine="email_address=\"\"";
Debug.ShouldStop(-2147483648);
_email_address = BA.ObjectToString("");Debug.locals.put("email_address", _email_address);
 BA.debugLineNum = 33;BA.debugLine="Dim r As Reflector";
Debug.ShouldStop(1);
_r = RemoteObject.createNew ("anywheresoftware.b4a.agraham.reflection.Reflection");Debug.locals.put("r", _r);
 BA.debugLineNum = 34;BA.debugLine="r.Target = r.RunStaticMethod(\"android.accounts";
Debug.ShouldStop(2);
_r.setField ("Target",_r.runMethod(false,"RunStaticMethod",(Object)(BA.ObjectToString("android.accounts.AccountManager")),(Object)(BA.ObjectToString("get")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_r.runMethod(false,"GetContext",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba)))})),(Object)(RemoteObject.createNewArray("String",new int[] {1},new Object[] {RemoteObject.createImmutable("android.content.Context")}))));
 BA.debugLineNum = 36;BA.debugLine="Dim accounts() As Object";
Debug.ShouldStop(8);
_accounts = RemoteObject.createNewArray ("Object", new int[] {0}, new Object[]{});Debug.locals.put("accounts", _accounts);
 BA.debugLineNum = 37;BA.debugLine="accounts = r.RunMethod2(\"getAccountsByType\",\"c";
Debug.ShouldStop(16);
_accounts = (_r.runMethod(false,"RunMethod2",(Object)(BA.ObjectToString("getAccountsByType")),(Object)(BA.ObjectToString("com.google")),(Object)(RemoteObject.createImmutable("java.lang.String"))));Debug.locals.put("accounts", _accounts);
 BA.debugLineNum = 38;BA.debugLine="For i = 0 To accounts.Length - 1";
Debug.ShouldStop(32);
{
final int step7 = 1;
final int limit7 = RemoteObject.solve(new RemoteObject[] {_accounts.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
for (_i = 0 ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 39;BA.debugLine="r.Target = accounts(i)";
Debug.ShouldStop(64);
_r.setField ("Target",_accounts.getArrayElement(false,BA.numberCast(int.class, _i)));
 BA.debugLineNum = 40;BA.debugLine="email_address = r.GetField(\"name\")";
Debug.ShouldStop(128);
_email_address = BA.ObjectToString(_r.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("name"))));Debug.locals.put("email_address", _email_address);
 BA.debugLineNum = 41;BA.debugLine="Exit";
Debug.ShouldStop(256);
if (true) break;
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 44;BA.debugLine="Return	email_address";
Debug.ShouldStop(2048);
if (true) return _email_address;
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _isconnected(RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("IsConnected (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,98);
if (RapidSub.canDelegate("isconnected")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","isconnected", _ba);
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _server = RemoteObject.declareNull("anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper");
;
 BA.debugLineNum = 98;BA.debugLine="Sub IsConnected As Boolean";
Debug.ShouldStop(2);
 BA.debugLineNum = 99;BA.debugLine="Dim P As Phone,server As ServerSocket";
Debug.ShouldStop(4);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("P", _p);
_server = RemoteObject.createNew ("anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper");Debug.locals.put("server", _server);
 BA.debugLineNum = 100;BA.debugLine="Try";
Debug.ShouldStop(8);
try { BA.debugLineNum = 101;BA.debugLine="server.Initialize(0, \"\")";
Debug.ShouldStop(16);
_server.runVoidMethod ("Initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba),(Object)(BA.numberCast(int.class, 0)),(Object)(RemoteObject.createImmutable("")));
 BA.debugLineNum = 102;BA.debugLine="If server.GetMyIP = \"127.0.0.1\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_server.runMethod(true,"GetMyIP"),BA.ObjectToString("127.0.0.1"))) { 
 BA.debugLineNum = 103;BA.debugLine="Return False";
Debug.ShouldStop(64);
Debug.CheckDeviceExceptions();if (true) return hamrahpay.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 106;BA.debugLine="If Not(P.GetDataState.EqualsIgnoreCase(\"CON";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean(".",hamrahpay.mostCurrent.__c.runMethod(true,"Not",(Object)(_p.runMethod(true,"GetDataState").runMethod(true,"equalsIgnoreCase",(Object)(RemoteObject.createImmutable("CONNECTED")))))) && RemoteObject.solveBoolean("=",_server.runMethod(true,"GetMyWifiIP"),BA.ObjectToString("127.0.0.1"))) { 
 BA.debugLineNum = 107;BA.debugLine="Return False";
Debug.ShouldStop(1024);
Debug.CheckDeviceExceptions();if (true) return hamrahpay.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 110;BA.debugLine="Return True";
Debug.ShouldStop(8192);
Debug.CheckDeviceExceptions();if (true) return hamrahpay.mostCurrent.__c.getField(true,"True");
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e80) {
			BA.rdebugUtils.runVoidMethod("setLastException",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba), e80.toString()); BA.debugLineNum = 112;BA.debugLine="Return False";
Debug.ShouldStop(32768);
if (true) return hamrahpay.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _ispayed(RemoteObject _ba,RemoteObject _sku) throws Exception{
try {
		Debug.PushSubsStack("isPayed (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,84);
if (RapidSub.canDelegate("ispayed")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","ispayed", _ba, _sku);
RemoteObject _pay_hash = RemoteObject.createImmutable("");
RemoteObject _key_code = RemoteObject.createImmutable("");
;
Debug.locals.put("sku", _sku);
 BA.debugLineNum = 84;BA.debugLine="Sub	isPayed(sku As String) As Boolean";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Dim pay_hash As String";
Debug.ShouldStop(1048576);
_pay_hash = RemoteObject.createImmutable("");Debug.locals.put("pay_hash", _pay_hash);
 BA.debugLineNum = 86;BA.debugLine="Dim	key_code As String";
Debug.ShouldStop(2097152);
_key_code = RemoteObject.createImmutable("");Debug.locals.put("key_code", _key_code);
 BA.debugLineNum = 87;BA.debugLine="key_code = \"premium_key_\"&sku&GetDeviceId";
Debug.ShouldStop(4194304);
_key_code = RemoteObject.concat(RemoteObject.createImmutable("premium_key_"),_sku,_getdeviceid(_ba));Debug.locals.put("key_code", _key_code);
 BA.debugLineNum = 89;BA.debugLine="pay_hash = StateManager.GetSetting2(sku,\"\")";
Debug.ShouldStop(16777216);
_pay_hash = hamrahpay.mostCurrent._statemanager.runMethod(true,"_getsetting2",_ba,(Object)(_sku),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("pay_hash", _pay_hash);
 BA.debugLineNum = 90;BA.debugLine="If pay_hash= key_code Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",_pay_hash,_key_code)) { 
 BA.debugLineNum = 91;BA.debugLine="Return True";
Debug.ShouldStop(67108864);
if (true) return hamrahpay.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 93;BA.debugLine="Return False";
Debug.ShouldStop(268435456);
if (true) return hamrahpay.mostCurrent.__c.getField(true,"False");
 };
 BA.debugLineNum = 95;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _ba,RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,193);
if (RapidSub.canDelegate("jobdone")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","jobdone", _ba, _job);
RemoteObject _json = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _map1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _res = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _req_result = RemoteObject.createImmutable("");
;
Debug.locals.put("Job", _job);
 BA.debugLineNum = 193;BA.debugLine="Sub JobDone (Job As HttpJob)";
Debug.ShouldStop(1);
 BA.debugLineNum = 194;BA.debugLine="Dim JSON As JSONParser";
Debug.ShouldStop(2);
_json = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("JSON", _json);
 BA.debugLineNum = 195;BA.debugLine="Dim Map1 As Map";
Debug.ShouldStop(4);
_map1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("Map1", _map1);
 BA.debugLineNum = 196;BA.debugLine="Dim res As Map";
Debug.ShouldStop(8);
_res = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("res", _res);
 BA.debugLineNum = 197;BA.debugLine="Dim req_result As String";
Debug.ShouldStop(16);
_req_result = RemoteObject.createImmutable("");Debug.locals.put("req_result", _req_result);
 BA.debugLineNum = 199;BA.debugLine="If Job.Success = True Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_success"),hamrahpay.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 200;BA.debugLine="Select Job.JobName";
Debug.ShouldStop(128);
switch (BA.switchObjectToInt(_job.getField(true,"_jobname"),BA.ObjectToString("Pay_Request"),BA.ObjectToString("Pay_Verify"))) {
case 0: {
 BA.debugLineNum = 202;BA.debugLine="ProgressDialogHide";
Debug.ShouldStop(512);
hamrahpay.mostCurrent.__c.runVoidMethod ("ProgressDialogHide");
 BA.debugLineNum = 203;BA.debugLine="req_result = Job.GetString";
Debug.ShouldStop(1024);
_req_result = _job.runMethod(true,"_getstring");Debug.locals.put("req_result", _req_result);
 BA.debugLineNum = 204;BA.debugLine="JSON.Initialize(req_result)";
Debug.ShouldStop(2048);
_json.runVoidMethod ("Initialize",(Object)(_req_result));
 BA.debugLineNum = 205;BA.debugLine="Map1 = JSON.NextObject";
Debug.ShouldStop(4096);
_map1 = _json.runMethod(false,"NextObject");Debug.locals.put("Map1", _map1);
 BA.debugLineNum = 207;BA.debugLine="payment(Map1)";
Debug.ShouldStop(16384);
_payment(_ba,_map1);
 break; }
case 1: {
 BA.debugLineNum = 209;BA.debugLine="req_result = Job.GetString";
Debug.ShouldStop(65536);
_req_result = _job.runMethod(true,"_getstring");Debug.locals.put("req_result", _req_result);
 BA.debugLineNum = 210;BA.debugLine="JSON.Initialize(req_result)";
Debug.ShouldStop(131072);
_json.runVoidMethod ("Initialize",(Object)(_req_result));
 BA.debugLineNum = 211;BA.debugLine="Map1 = JSON.NextObject";
Debug.ShouldStop(262144);
_map1 = _json.runMethod(false,"NextObject");Debug.locals.put("Map1", _map1);
 BA.debugLineNum = 212;BA.debugLine="verify(Map1)";
Debug.ShouldStop(524288);
_verify(_ba,_map1);
 break; }
}
;
 }else {
 BA.debugLineNum = 216;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
Debug.ShouldStop(8388608);
hamrahpay.mostCurrent.__c.runVoidMethod ("Log",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))));
 BA.debugLineNum = 217;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMess";
Debug.ShouldStop(16777216);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage"))),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 219;BA.debugLine="Job.Release";
Debug.ShouldStop(67108864);
_job.runVoidMethod ("_release");
 BA.debugLineNum = 220;BA.debugLine="End Sub";
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
public static RemoteObject  _makepayed(RemoteObject _ba,RemoteObject _sku) throws Exception{
try {
		Debug.PushSubsStack("MakePayed (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,78);
if (RapidSub.canDelegate("makepayed")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","makepayed", _ba, _sku);
;
Debug.locals.put("sku", _sku);
 BA.debugLineNum = 78;BA.debugLine="Sub	MakePayed(sku As String)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="StateManager.SetSetting(sku,\"premium_key_\"&sku&Ge";
Debug.ShouldStop(16384);
hamrahpay.mostCurrent._statemanager.runVoidMethod ("_setsetting",_ba,(Object)(_sku),(Object)(RemoteObject.concat(RemoteObject.createImmutable("premium_key_"),_sku,_getdeviceid(_ba))));
 BA.debugLineNum = 80;BA.debugLine="StateManager.SaveSettings";
Debug.ShouldStop(32768);
hamrahpay.mostCurrent._statemanager.runVoidMethod ("_savesettings",_ba);
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _pay_request(RemoteObject _ba,RemoteObject _sku,RemoteObject _m_activity) throws Exception{
try {
		Debug.PushSubsStack("pay_request (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,163);
if (RapidSub.canDelegate("pay_request")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","pay_request", _ba, _sku, _m_activity);
RemoteObject _post_param = RemoteObject.createImmutable("");
;
Debug.locals.put("sku", _sku);
Debug.locals.put("m_activity", _m_activity);
 BA.debugLineNum = 163;BA.debugLine="Sub pay_request(sku As String,m_activity As Object";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="parent_activity = m_activity";
Debug.ShouldStop(8);
hamrahpay._parent_activity = _m_activity;
 BA.debugLineNum = 165;BA.debugLine="pay_request_url = \"https://hamrahpay.com/rest-api";
Debug.ShouldStop(16);
hamrahpay._pay_request_url = BA.ObjectToString("https://hamrahpay.com/rest-api/pay-request");
 BA.debugLineNum = 166;BA.debugLine="product_sku = sku";
Debug.ShouldStop(32);
hamrahpay._product_sku = _sku;
 BA.debugLineNum = 167;BA.debugLine="Dim post_param As String";
Debug.ShouldStop(64);
_post_param = RemoteObject.createImmutable("");Debug.locals.put("post_param", _post_param);
 BA.debugLineNum = 168;BA.debugLine="post_param =  \"sku=\"&sku&\"&device_id=\"&GetDeviceI";
Debug.ShouldStop(128);
_post_param = RemoteObject.concat(RemoteObject.createImmutable("sku="),_sku,RemoteObject.createImmutable("&device_id="),_getdeviceid(_ba),RemoteObject.createImmutable("&email="),_getprimaryemail(_ba));Debug.locals.put("post_param", _post_param);
 BA.debugLineNum = 169;BA.debugLine="HttpUtils.Initialize(\"Pay_Request\",parent_activit";
Debug.ShouldStop(256);
hamrahpay._httputils.runVoidMethod ("_initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba),(Object)(BA.ObjectToString("Pay_Request")),(Object)(hamrahpay._parent_activity));
 BA.debugLineNum = 170;BA.debugLine="HttpUtils.PostString(pay_request_url, post_param)";
Debug.ShouldStop(512);
hamrahpay._httputils.runVoidMethod ("_poststring",(Object)(hamrahpay._pay_request_url),(Object)(_post_param));
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			Debug.ErrorCaught(e);
			throw e;
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _payment(RemoteObject _ba,RemoteObject _res_map) throws Exception{
try {
		Debug.PushSubsStack("payment (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,137);
if (RapidSub.canDelegate("payment")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","payment", _ba, _res_map);
;
Debug.locals.put("res_map", _res_map);
 BA.debugLineNum = 137;BA.debugLine="Private Sub payment(res_map As Map)";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="pay_url = \"https://hamrahpay.com/cart/app/pay_v2/";
Debug.ShouldStop(512);
hamrahpay._pay_url = BA.ObjectToString("https://hamrahpay.com/cart/app/pay_v2/");
 BA.debugLineNum = 139;BA.debugLine="status = res_map.Get(\"status\")";
Debug.ShouldStop(1024);
hamrahpay._status = BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));
 BA.debugLineNum = 140;BA.debugLine="error = res_map.Get(\"error\")";
Debug.ShouldStop(2048);
hamrahpay._error = BA.ObjectToBoolean(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("error")))));
 BA.debugLineNum = 141;BA.debugLine="If (error=False) Then";
Debug.ShouldStop(4096);
if ((RemoteObject.solveBoolean("=",hamrahpay._error,hamrahpay.mostCurrent.__c.getField(true,"False")))) { 
 BA.debugLineNum = 142;BA.debugLine="If status=\"SELLER_BLOCKED\" Or status=\"TRY_AGAIN\"";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("SELLER_BLOCKED")) || RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("TRY_AGAIN")) || RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("BAD_PARAMETERS"))) { 
 BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
Debug.ShouldStop(16384);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message")))))),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 }else 
{ BA.debugLineNum = 144;BA.debugLine="Else If status=\"READY_TO_PAY\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("READY_TO_PAY"))) { 
 BA.debugLineNum = 145;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
Debug.ShouldStop(65536);
hamrahpay._pay_code = BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("pay_code")))));
 BA.debugLineNum = 146;BA.debugLine="pay_url = pay_url&pay_code";
Debug.ShouldStop(131072);
hamrahpay._pay_url = RemoteObject.concat(hamrahpay._pay_url,hamrahpay._pay_code);
 BA.debugLineNum = 147;BA.debugLine="StartActivity(payment_activity)";
Debug.ShouldStop(262144);
hamrahpay.mostCurrent.__c.runVoidMethod ("StartActivity",_ba,(Object)((hamrahpay.mostCurrent._payment_activity.getObject())));
 }else 
{ BA.debugLineNum = 148;BA.debugLine="Else If status=\"BEFORE_PAID\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("BEFORE_PAID"))) { 
 BA.debugLineNum = 150;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
Debug.ShouldStop(2097152);
hamrahpay._pay_code = BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("pay_code")))));
 BA.debugLineNum = 151;BA.debugLine="verify_payment(pay_code,product_sku)";
Debug.ShouldStop(4194304);
_verify_payment(_ba,hamrahpay._pay_code,hamrahpay._product_sku);
 BA.debugLineNum = 152;BA.debugLine="If pay_status=True Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",hamrahpay._pay_status,hamrahpay.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 153;BA.debugLine="activate_app";
Debug.ShouldStop(16777216);
_activate_app(_ba);
 };
 }else {
 BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
Debug.ShouldStop(134217728);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message")))))),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 }}};
 }else {
 BA.debugLineNum = 159;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
Debug.ShouldStop(1073741824);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString(_res_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message")))))),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 160;BA.debugLine="pay_code=\"\"";
Debug.ShouldStop(-2147483648);
hamrahpay._pay_code = BA.ObjectToString("");
 };
 BA.debugLineNum = 162;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim	verification_type As String";
hamrahpay._verification_type = RemoteObject.createImmutable("");
 //BA.debugLineNum = 10;BA.debugLine="verification_type =\"device_verification\"";
hamrahpay._verification_type = BA.ObjectToString("device_verification");
 //BA.debugLineNum = 12;BA.debugLine="Dim pay_request_url As String";
hamrahpay._pay_request_url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 13;BA.debugLine="Dim	pay_verify_url As String";
hamrahpay._pay_verify_url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 14;BA.debugLine="Dim pay_url As String";
hamrahpay._pay_url = RemoteObject.createImmutable("");
 //BA.debugLineNum = 16;BA.debugLine="Dim HttpUtils As HttpJob";
hamrahpay._httputils = RemoteObject.createNew ("anywheresoftware.b4a.samples.httputils2.httpjob");
 //BA.debugLineNum = 17;BA.debugLine="Dim device_id As String";
hamrahpay._device_id = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Dim pay_code As String";
hamrahpay._pay_code = RemoteObject.createImmutable("");
 //BA.debugLineNum = 19;BA.debugLine="Dim product_sku As String";
hamrahpay._product_sku = RemoteObject.createImmutable("");
 //BA.debugLineNum = 20;BA.debugLine="Dim status	As String";
hamrahpay._status = RemoteObject.createImmutable("");
 //BA.debugLineNum = 21;BA.debugLine="Dim error As Boolean";
hamrahpay._error = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 22;BA.debugLine="Dim pay_status As Boolean";
hamrahpay._pay_status = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 23;BA.debugLine="Dim	parent_activity as Object";
hamrahpay._parent_activity = RemoteObject.createNew ("Object");
 //BA.debugLineNum = 24;BA.debugLine="pay_status= False";
hamrahpay._pay_status = hamrahpay.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 25;BA.debugLine="error=False";
hamrahpay._error = hamrahpay.mostCurrent.__c.getField(true,"False");
 //BA.debugLineNum = 26;BA.debugLine="product_sku=\"\";";
hamrahpay._product_sku = BA.ObjectToString("");
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _verify(RemoteObject _ba,RemoteObject _verify_map) throws Exception{
try {
		Debug.PushSubsStack("verify (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,117);
if (RapidSub.canDelegate("verify")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","verify", _ba, _verify_map);
;
Debug.locals.put("verify_map", _verify_map);
 BA.debugLineNum = 117;BA.debugLine="Private Sub verify(verify_map As Map)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="status = verify_map.Get(\"status\")";
Debug.ShouldStop(2097152);
hamrahpay._status = BA.ObjectToString(_verify_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("status")))));
 BA.debugLineNum = 119;BA.debugLine="error = verify_map.Get(\"error\")";
Debug.ShouldStop(4194304);
hamrahpay._error = BA.ObjectToBoolean(_verify_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("error")))));
 BA.debugLineNum = 121;BA.debugLine="If error=True Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",hamrahpay._error,hamrahpay.mostCurrent.__c.getField(true,"True"))) { 
 BA.debugLineNum = 122;BA.debugLine="ToastMessageShow(verify_map.Get(\"message\"),True)";
Debug.ShouldStop(33554432);
hamrahpay.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToString(_verify_map.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("message")))))),(Object)(hamrahpay.mostCurrent.__c.getField(true,"True")));
 BA.debugLineNum = 123;BA.debugLine="pay_status= False";
Debug.ShouldStop(67108864);
hamrahpay._pay_status = hamrahpay.mostCurrent.__c.getField(true,"False");
 }else {
 BA.debugLineNum = 125;BA.debugLine="If status=\"SUCCESSFUL_PAYMENT\" Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",hamrahpay._status,BA.ObjectToString("SUCCESSFUL_PAYMENT"))) { 
 BA.debugLineNum = 126;BA.debugLine="pay_status= True";
Debug.ShouldStop(536870912);
hamrahpay._pay_status = hamrahpay.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 128;BA.debugLine="pay_status= False";
Debug.ShouldStop(-2147483648);
hamrahpay._pay_status = hamrahpay.mostCurrent.__c.getField(true,"False");
 };
 };
 BA.debugLineNum = 131;BA.debugLine="If (pay_status=True) Then";
Debug.ShouldStop(4);
if ((RemoteObject.solveBoolean("=",hamrahpay._pay_status,hamrahpay.mostCurrent.__c.getField(true,"True")))) { 
 BA.debugLineNum = 132;BA.debugLine="activate_app";
Debug.ShouldStop(8);
_activate_app(_ba);
 };
 BA.debugLineNum = 135;BA.debugLine="End Sub";
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
public static RemoteObject  _verify_payment(RemoteObject _ba,RemoteObject _pay_code_param,RemoteObject _sku) throws Exception{
try {
		Debug.PushSubsStack("verify_payment (hamrahpay) ","hamrahpay",1,_ba,hamrahpay.mostCurrent,174);
if (RapidSub.canDelegate("verify_payment")) return hamrahpay.remoteMe.runUserSub(false, "hamrahpay","verify_payment", _ba, _pay_code_param, _sku);
RemoteObject _device_model = RemoteObject.createImmutable("");
RemoteObject _device_manufacturer = RemoteObject.createImmutable("");
RemoteObject _sdk_version = RemoteObject.createImmutable("");
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
;
Debug.locals.put("pay_code_param", _pay_code_param);
Debug.locals.put("sku", _sku);
 BA.debugLineNum = 174;BA.debugLine="Sub verify_payment(pay_code_param As String,sku As";
Debug.ShouldStop(8192);
 BA.debugLineNum = 175;BA.debugLine="Dim	device_model As String";
Debug.ShouldStop(16384);
_device_model = RemoteObject.createImmutable("");Debug.locals.put("device_model", _device_model);
 BA.debugLineNum = 176;BA.debugLine="Dim device_manufacturer As String";
Debug.ShouldStop(32768);
_device_manufacturer = RemoteObject.createImmutable("");Debug.locals.put("device_manufacturer", _device_manufacturer);
 BA.debugLineNum = 177;BA.debugLine="Dim sdk_version As String";
Debug.ShouldStop(65536);
_sdk_version = RemoteObject.createImmutable("");Debug.locals.put("sdk_version", _sdk_version);
 BA.debugLineNum = 178;BA.debugLine="Dim	p As Phone";
Debug.ShouldStop(131072);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 180;BA.debugLine="device_model = p.Model";
Debug.ShouldStop(524288);
_device_model = _p.runMethod(true,"getModel");Debug.locals.put("device_model", _device_model);
 BA.debugLineNum = 181;BA.debugLine="device_manufacturer = p.Manufacturer";
Debug.ShouldStop(1048576);
_device_manufacturer = _p.runMethod(true,"getManufacturer");Debug.locals.put("device_manufacturer", _device_manufacturer);
 BA.debugLineNum = 182;BA.debugLine="sdk_version = p.SdkVersion";
Debug.ShouldStop(2097152);
_sdk_version = BA.NumberToString(_p.runMethod(true,"getSdkVersion"));Debug.locals.put("sdk_version", _sdk_version);
 BA.debugLineNum = 184;BA.debugLine="pay_verify_url = \"https://hamrahpay.com/rest-api/";
Debug.ShouldStop(8388608);
hamrahpay._pay_verify_url = BA.ObjectToString("https://hamrahpay.com/rest-api/verify-payment");
 BA.debugLineNum = 185;BA.debugLine="HttpUtils.Initialize(\"Pay_Verify\",parent_activity";
Debug.ShouldStop(16777216);
hamrahpay._httputils.runVoidMethod ("_initialize",BA.rdebugUtils.runMethod(false, "processBAFromBA", _ba),(Object)(BA.ObjectToString("Pay_Verify")),(Object)(hamrahpay._parent_activity));
 BA.debugLineNum = 186;BA.debugLine="HttpUtils.PostString(pay_verify_url, \"pay_code=\"&";
Debug.ShouldStop(33554432);
hamrahpay._httputils.runVoidMethod ("_poststring",(Object)(hamrahpay._pay_verify_url),(Object)(RemoteObject.concat(RemoteObject.createImmutable("pay_code="),_pay_code_param,RemoteObject.createImmutable("&sku="),_sku,RemoteObject.createImmutable("&email="),_getprimaryemail(_ba),RemoteObject.createImmutable("&device_model="),_device_model,RemoteObject.createImmutable("&device_manufacturer="),_device_manufacturer,RemoteObject.createImmutable("&sdk_version="),_sdk_version)));
 BA.debugLineNum = 188;BA.debugLine="End Sub";
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
}