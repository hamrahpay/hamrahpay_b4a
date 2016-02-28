package b4a.hamrahpay;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class hamrahpay {
private static hamrahpay mostCurrent = new hamrahpay();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static String _verification_type = "";
public static String _pay_request_url = "";
public static String _pay_verify_url = "";
public static String _pay_url = "";
public static anywheresoftware.b4a.samples.httputils2.httpjob _httputils = null;
public static String _device_id = "";
public static String _pay_code = "";
public static String _product_sku = "";
public static String _status = "";
public static boolean _error = false;
public static boolean _pay_status = false;
public static Object _parent_activity = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.payment_activity _payment_activity = null;
public b4a.hamrahpay.statemanager _statemanager = null;
public static String  _jobdone(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("jobdone"))
	return (String) Debug.delegate(null, "jobdone", new Object[] {_ba,_job});
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _map1 = null;
anywheresoftware.b4a.objects.collections.Map _res = null;
String _req_result = "";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="Dim Map1 As Map";
_map1 = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim res As Map";
_res = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="Dim req_result As String";
_req_result = "";
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Pay_Request","Pay_Verify")) {
case 0: {
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1245194;
 //BA.debugLineNum = 1245194;BA.debugLine="req_result = Job.GetString";
_req_result = _job._getstring();
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="JSON.Initialize(req_result)";
_json.Initialize(_req_result);
RDebugUtils.currentLine=1245196;
 //BA.debugLineNum = 1245196;BA.debugLine="Map1 = JSON.NextObject";
_map1 = _json.NextObject();
RDebugUtils.currentLine=1245198;
 //BA.debugLineNum = 1245198;BA.debugLine="payment(Map1)";
_payment(_ba,_map1);
 break; }
case 1: {
RDebugUtils.currentLine=1245200;
 //BA.debugLineNum = 1245200;BA.debugLine="req_result = Job.GetString";
_req_result = _job._getstring();
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="JSON.Initialize(req_result)";
_json.Initialize(_req_result);
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="Map1 = JSON.NextObject";
_map1 = _json.NextObject();
RDebugUtils.currentLine=1245203;
 //BA.debugLineNum = 1245203;BA.debugLine="verify(Map1)";
_verify(_ba,_map1);
 break; }
}
;
 }else {
RDebugUtils.currentLine=1245207;
 //BA.debugLineNum = 1245207;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
RDebugUtils.currentLine=1245208;
 //BA.debugLineNum = 1245208;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMess";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("Error: "+_job._errormessage,anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1245210;
 //BA.debugLineNum = 1245210;BA.debugLine="Job.Release";
_job._release();
RDebugUtils.currentLine=1245211;
 //BA.debugLineNum = 1245211;BA.debugLine="End Sub";
return "";
}
public static boolean  _isconnected(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("isconnected"))
	return (Boolean) Debug.delegate(null, "isconnected", new Object[] {_ba});
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _server = null;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub IsConnected As Boolean";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim P As Phone,server As ServerSocket";
_p = new anywheresoftware.b4a.phone.Phone();
_server = new anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper();
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="Try";
try {RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="server.Initialize(0, \"\")";
_server.Initialize((_ba.processBA == null ? _ba : _ba.processBA),(int) (0),"");
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="If server.GetMyIP = \"127.0.0.1\" Then";
if ((_server.GetMyIP()).equals("127.0.0.1")) { 
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="If Not(P.GetDataState.EqualsIgnoreCase(\"CON";
if (anywheresoftware.b4a.keywords.Common.Not(_p.GetDataState().equalsIgnoreCase("CONNECTED")) && (_server.GetMyWifiIP()).equals("127.0.0.1")) { 
RDebugUtils.currentLine=917513;
 //BA.debugLineNum = 917513;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=917516;
 //BA.debugLineNum = 917516;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e80) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e80);RDebugUtils.currentLine=917518;
 //BA.debugLineNum = 917518;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=917520;
 //BA.debugLineNum = 917520;BA.debugLine="End Sub";
return false;
}
public static String  _pay_request(anywheresoftware.b4a.BA _ba,String _sku,Object _m_activity) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("pay_request"))
	return (String) Debug.delegate(null, "pay_request", new Object[] {_ba,_sku,_m_activity});
String _post_param = "";
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub pay_request(sku As String,m_activity As Object";
RDebugUtils.currentLine=1114113;
 //BA.debugLineNum = 1114113;BA.debugLine="parent_activity = m_activity";
_parent_activity = _m_activity;
RDebugUtils.currentLine=1114114;
 //BA.debugLineNum = 1114114;BA.debugLine="pay_request_url = \"https://hamrahpay.com/rest-api";
_pay_request_url = "https://hamrahpay.com/rest-api/pay-request";
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="product_sku = sku";
_product_sku = _sku;
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Dim post_param As String";
_post_param = "";
RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="post_param =  \"sku=\"&sku&\"&device_id=\"&GetDeviceI";
_post_param = "sku="+_sku+"&device_id="+_getdeviceid(_ba)+"&email="+_getprimaryemail(_ba);
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="HttpUtils.Initialize(\"Pay_Request\",parent_activit";
_httputils._initialize((_ba.processBA == null ? _ba : _ba.processBA),"Pay_Request",_parent_activity);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="HttpUtils.PostString(pay_request_url, post_param)";
_httputils._poststring(_pay_request_url,_post_param);
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="End Sub";
return "";
}
public static boolean  _ispayed(anywheresoftware.b4a.BA _ba,String _sku) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("ispayed"))
	return (Boolean) Debug.delegate(null, "ispayed", new Object[] {_ba,_sku});
String _pay_hash = "";
String _key_code = "";
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub	isPayed(sku As String) As Boolean";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="Dim pay_hash As String";
_pay_hash = "";
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="Dim	key_code As String";
_key_code = "";
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="key_code = \"premium_key_\"&sku&GetDeviceId";
_key_code = "premium_key_"+_sku+_getdeviceid(_ba);
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="pay_hash = StateManager.GetSetting2(sku,\"\")";
_pay_hash = mostCurrent._statemanager._getsetting2(_ba,_sku,"");
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="If pay_hash= key_code Then";
if ((_pay_hash).equals(_key_code)) { 
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=851977;
 //BA.debugLineNum = 851977;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="End Sub";
return false;
}
public static String  _activate_app(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("activate_app"))
	return (String) Debug.delegate(null, "activate_app", new Object[] {_ba});
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub activate_app()";
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="MakePayed(product_sku)";
_makepayed(_ba,_product_sku);
RDebugUtils.currentLine=1310725;
 //BA.debugLineNum = 1310725;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ارت";
anywheresoftware.b4a.keywords.Common.ToastMessageShow("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."+_product_sku,anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1310726;
 //BA.debugLineNum = 1310726;BA.debugLine="End Sub";
return "";
}
public static String  _makepayed(anywheresoftware.b4a.BA _ba,String _sku) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("makepayed"))
	return (String) Debug.delegate(null, "makepayed", new Object[] {_ba,_sku});
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub	MakePayed(sku As String)";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="StateManager.SetSetting(sku,\"premium_key_\"&sku&Ge";
mostCurrent._statemanager._setsetting(_ba,_sku,"premium_key_"+_sku+_getdeviceid(_ba));
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(_ba);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="End Sub";
return "";
}
public static String  _getdeviceid(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("getdeviceid"))
	return (String) Debug.delegate(null, "getdeviceid", new Object[] {_ba});
anywheresoftware.b4a.phone.Phone _p = null;
String _id = "";
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
int _api = 0;
anywheresoftware.b4a.phone.Phone.PhoneId _pid = null;
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub GetDeviceId As String";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="Dim P As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="Dim id As String";
_id = "";
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=720900;
 //BA.debugLineNum = 720900;BA.debugLine="Dim Api As Int";
_api = 0;
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="Dim pID As PhoneId";
_pid = new anywheresoftware.b4a.phone.Phone.PhoneId();
RDebugUtils.currentLine=720903;
 //BA.debugLineNum = 720903;BA.debugLine="id = pID.GetDeviceId";
_id = _pid.GetDeviceId();
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="Api = r.GetStaticField(\"android.os.Build$VERSIO";
_api = (int)(BA.ObjectToNumber(_r.GetStaticField("android.os.Build$VERSION","SDK_INT")));
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="If id==Null Then";
if (_id== null) { 
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="If Api < 9 Then";
if (_api<9) { 
RDebugUtils.currentLine=720908;
 //BA.debugLineNum = 720908;BA.debugLine="id= P.GetSettings(\"android_id\")";
_id = _p.GetSettings("android_id");
 }else {
RDebugUtils.currentLine=720912;
 //BA.debugLineNum = 720912;BA.debugLine="id= r.GetStaticField(\"android.os.Build\", \"S";
_id = BA.ObjectToString(_r.GetStaticField("android.os.Build","SERIAL"));
RDebugUtils.currentLine=720913;
 //BA.debugLineNum = 720913;BA.debugLine="If id.ToLowerCase = \"unknown\" Then";
if ((_id.toLowerCase()).equals("unknown")) { 
RDebugUtils.currentLine=720914;
 //BA.debugLineNum = 720914;BA.debugLine="id= P.GetSettings(\"android_id\")";
_id = _p.GetSettings("android_id");
 };
RDebugUtils.currentLine=720917;
 //BA.debugLineNum = 720917;BA.debugLine="If id.ToLowerCase = \"9774d56d682e549c\" Or id =";
if ((_id.toLowerCase()).equals("9774d56d682e549c") || _id== null) { 
_id = _p.GetSettings("android_id");};
 };
 };
RDebugUtils.currentLine=720921;
 //BA.debugLineNum = 720921;BA.debugLine="Return id";
if (true) return _id;
RDebugUtils.currentLine=720922;
 //BA.debugLineNum = 720922;BA.debugLine="End Sub";
return "";
}
public static String  _getprimaryemail(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("getprimaryemail"))
	return (String) Debug.delegate(null, "getprimaryemail", new Object[] {_ba});
String _email_address = "";
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
Object[] _accounts = null;
int _i = 0;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub	GetPrimaryEmail As String";
RDebugUtils.currentLine=655361;
 //BA.debugLineNum = 655361;BA.debugLine="Dim	email_address As String";
_email_address = "";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="email_address=\"\"";
_email_address = "";
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="r.Target = r.RunStaticMethod(\"android.accounts";
_r.Target = _r.RunStaticMethod("android.accounts.AccountManager","get",new Object[]{(Object)(_r.GetContext((_ba.processBA == null ? _ba : _ba.processBA)))},new String[]{"android.content.Context"});
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="Dim accounts() As Object";
_accounts = new Object[(int) (0)];
{
int d0 = _accounts.length;
for (int i0 = 0;i0 < d0;i0++) {
_accounts[i0] = new Object();
}
}
;
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="accounts = r.RunMethod2(\"getAccountsByType\",\"c";
_accounts = (Object[])(_r.RunMethod2("getAccountsByType","com.google","java.lang.String"));
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="For i = 0 To accounts.Length - 1";
{
final int step7 = 1;
final int limit7 = (int) (_accounts.length-1);
for (_i = (int) (0) ; (step7 > 0 && _i <= limit7) || (step7 < 0 && _i >= limit7); _i = ((int)(0 + _i + step7)) ) {
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="r.Target = accounts(i)";
_r.Target = _accounts[_i];
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="email_address = r.GetField(\"name\")";
_email_address = BA.ObjectToString(_r.GetField("name"));
RDebugUtils.currentLine=655371;
 //BA.debugLineNum = 655371;BA.debugLine="Exit";
if (true) break;
 }
};
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="Return	email_address";
if (true) return _email_address;
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="End Sub";
return "";
}
public static String  _payment(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _res_map) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("payment"))
	return (String) Debug.delegate(null, "payment", new Object[] {_ba,_res_map});
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Private Sub payment(res_map As Map)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="pay_url = \"https://hamrahpay.com/cart/app/pay_v2/";
_pay_url = "https://hamrahpay.com/cart/app/pay_v2/";
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="status = res_map.Get(\"status\")";
_status = BA.ObjectToString(_res_map.Get((Object)("status")));
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="error = res_map.Get(\"error\")";
_error = BA.ObjectToBoolean(_res_map.Get((Object)("error")));
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="If (error=False) Then";
if ((_error==anywheresoftware.b4a.keywords.Common.False)) { 
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="If status=\"SELLER_BLOCKED\" Or status=\"TRY_AGAIN\"";
if ((_status).equals("SELLER_BLOCKED") || (_status).equals("TRY_AGAIN") || (_status).equals("BAD_PARAMETERS")) { 
RDebugUtils.currentLine=1048582;
 //BA.debugLineNum = 1048582;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToString(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 }else 
{RDebugUtils.currentLine=1048583;
 //BA.debugLineNum = 1048583;BA.debugLine="Else If status=\"READY_TO_PAY\" Then";
if ((_status).equals("READY_TO_PAY")) { 
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
_pay_code = BA.ObjectToString(_res_map.Get((Object)("pay_code")));
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="pay_url = pay_url&pay_code";
_pay_url = _pay_url+_pay_code;
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="StartActivity(payment_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity(_ba,(Object)(mostCurrent._payment_activity.getObject()));
 }else 
{RDebugUtils.currentLine=1048587;
 //BA.debugLineNum = 1048587;BA.debugLine="Else If status=\"BEFORE_PAID\" Then";
if ((_status).equals("BEFORE_PAID")) { 
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
_pay_code = BA.ObjectToString(_res_map.Get((Object)("pay_code")));
RDebugUtils.currentLine=1048590;
 //BA.debugLineNum = 1048590;BA.debugLine="verify_payment(pay_code,product_sku)";
_verify_payment(_ba,_pay_code,_product_sku);
RDebugUtils.currentLine=1048591;
 //BA.debugLineNum = 1048591;BA.debugLine="If pay_status=True Then";
if (_pay_status==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1048592;
 //BA.debugLineNum = 1048592;BA.debugLine="activate_app";
_activate_app(_ba);
 };
 }else {
RDebugUtils.currentLine=1048595;
 //BA.debugLineNum = 1048595;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToString(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 }}};
 }else {
RDebugUtils.currentLine=1048598;
 //BA.debugLineNum = 1048598;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToString(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1048599;
 //BA.debugLineNum = 1048599;BA.debugLine="pay_code=\"\"";
_pay_code = "";
 };
RDebugUtils.currentLine=1048601;
 //BA.debugLineNum = 1048601;BA.debugLine="End Sub";
return "";
}
public static String  _verify(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _verify_map) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("verify"))
	return (String) Debug.delegate(null, "verify", new Object[] {_ba,_verify_map});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Private Sub verify(verify_map As Map)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="status = verify_map.Get(\"status\")";
_status = BA.ObjectToString(_verify_map.Get((Object)("status")));
RDebugUtils.currentLine=983042;
 //BA.debugLineNum = 983042;BA.debugLine="error = verify_map.Get(\"error\")";
_error = BA.ObjectToBoolean(_verify_map.Get((Object)("error")));
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="If error=True Then";
if (_error==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="ToastMessageShow(verify_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToString(_verify_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=983046;
 //BA.debugLineNum = 983046;BA.debugLine="pay_status= False";
_pay_status = anywheresoftware.b4a.keywords.Common.False;
 }else {
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If status=\"SUCCESSFUL_PAYMENT\" Then";
if ((_status).equals("SUCCESSFUL_PAYMENT")) { 
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="pay_status= True";
_pay_status = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=983051;
 //BA.debugLineNum = 983051;BA.debugLine="pay_status= False";
_pay_status = anywheresoftware.b4a.keywords.Common.False;
 };
 };
RDebugUtils.currentLine=983054;
 //BA.debugLineNum = 983054;BA.debugLine="If (pay_status=True) Then";
if ((_pay_status==anywheresoftware.b4a.keywords.Common.True)) { 
RDebugUtils.currentLine=983055;
 //BA.debugLineNum = 983055;BA.debugLine="activate_app";
_activate_app(_ba);
 };
RDebugUtils.currentLine=983058;
 //BA.debugLineNum = 983058;BA.debugLine="End Sub";
return "";
}
public static String  _verify_payment(anywheresoftware.b4a.BA _ba,String _pay_code_param,String _sku) throws Exception{
RDebugUtils.currentModule="hamrahpay";
if (Debug.shouldDelegate("verify_payment"))
	return (String) Debug.delegate(null, "verify_payment", new Object[] {_ba,_pay_code_param,_sku});
String _device_model = "";
String _device_manufacturer = "";
String _sdk_version = "";
anywheresoftware.b4a.phone.Phone _p = null;
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Sub verify_payment(pay_code_param As String,sku As";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="Dim	device_model As String";
_device_model = "";
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="Dim device_manufacturer As String";
_device_manufacturer = "";
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="Dim sdk_version As String";
_sdk_version = "";
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="Dim	p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=1179654;
 //BA.debugLineNum = 1179654;BA.debugLine="device_model = p.Model";
_device_model = _p.getModel();
RDebugUtils.currentLine=1179655;
 //BA.debugLineNum = 1179655;BA.debugLine="device_manufacturer = p.Manufacturer";
_device_manufacturer = _p.getManufacturer();
RDebugUtils.currentLine=1179656;
 //BA.debugLineNum = 1179656;BA.debugLine="sdk_version = p.SdkVersion";
_sdk_version = BA.NumberToString(_p.getSdkVersion());
RDebugUtils.currentLine=1179658;
 //BA.debugLineNum = 1179658;BA.debugLine="pay_verify_url = \"https://hamrahpay.com/rest-api/";
_pay_verify_url = "https://hamrahpay.com/rest-api/verify-payment";
RDebugUtils.currentLine=1179659;
 //BA.debugLineNum = 1179659;BA.debugLine="HttpUtils.Initialize(\"Pay_Verify\",parent_activity";
_httputils._initialize((_ba.processBA == null ? _ba : _ba.processBA),"Pay_Verify",_parent_activity);
RDebugUtils.currentLine=1179660;
 //BA.debugLineNum = 1179660;BA.debugLine="HttpUtils.PostString(pay_verify_url, \"pay_code=\"&";
_httputils._poststring(_pay_verify_url,"pay_code="+_pay_code_param+"&sku="+_sku+"&email="+_getprimaryemail(_ba)+"&device_model="+_device_model+"&device_manufacturer="+_device_manufacturer+"&sdk_version="+_sdk_version);
RDebugUtils.currentLine=1179662;
 //BA.debugLineNum = 1179662;BA.debugLine="End Sub";
return "";
}
}