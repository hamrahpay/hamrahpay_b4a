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
public static String _last_purchase_url = "";
public static String _pay_url = "";
public static anywheresoftware.b4a.samples.httputils2.httpjob _httputils = null;
public static String _device_id = "";
public static String _pay_code = "";
public static String _product_sku = "";
public static String _status = "";
public static boolean _error = false;
public static boolean _pay_status = false;
public static Object _parent_activity = null;
public static String _lib_vers = "";
public static String _lib_name = "";
public static b4a.hamrahpay.lastpurchaseinfo _last_purchase_info = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.payment_activity _payment_activity = null;
public b4a.hamrahpay.statemanager _statemanager = null;
public static String  _activate_app(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 241;BA.debugLine="Sub activate_app()";
 //BA.debugLineNum = 245;BA.debugLine="MakePayed(product_sku)";
_makepayed(_ba,_product_sku);
 //BA.debugLineNum = 246;BA.debugLine="ToastMessageShow(\"نرم افزار شما به نسخه طلایی ارت";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد."+_product_sku),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 247;BA.debugLine="End Sub";
return "";
}
public static String  _getdeviceid(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
String _id = "";
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
int _api = 0;
anywheresoftware.b4a.phone.Phone.PhoneId _pid = null;
 //BA.debugLineNum = 36;BA.debugLine="Sub GetDeviceId As String";
 //BA.debugLineNum = 37;BA.debugLine="Dim P As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 38;BA.debugLine="Dim id As String";
_id = "";
 //BA.debugLineNum = 39;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 40;BA.debugLine="Dim Api As Int";
_api = 0;
 //BA.debugLineNum = 41;BA.debugLine="Dim pID As PhoneId";
_pid = new anywheresoftware.b4a.phone.Phone.PhoneId();
 //BA.debugLineNum = 43;BA.debugLine="id = pID.GetDeviceId";
_id = _pid.GetDeviceId();
 //BA.debugLineNum = 44;BA.debugLine="Api = r.GetStaticField(\"android.os.Build$VERSIO";
_api = (int)(BA.ObjectToNumber(_r.GetStaticField("android.os.Build$VERSION","SDK_INT")));
 //BA.debugLineNum = 45;BA.debugLine="If id==Null Then";
if (_id== null) { 
 //BA.debugLineNum = 46;BA.debugLine="If Api < 9 Then";
if (_api<9) { 
 //BA.debugLineNum = 48;BA.debugLine="id= P.GetSettings(\"android_id\")";
_id = _p.GetSettings("android_id");
 }else {
 //BA.debugLineNum = 52;BA.debugLine="id= r.GetStaticField(\"android.os.Build\", \"S";
_id = BA.ObjectToString(_r.GetStaticField("android.os.Build","SERIAL"));
 //BA.debugLineNum = 53;BA.debugLine="If id.ToLowerCase = \"unknown\" Then";
if ((_id.toLowerCase()).equals("unknown")) { 
 //BA.debugLineNum = 54;BA.debugLine="id= P.GetSettings(\"android_id\")";
_id = _p.GetSettings("android_id");
 };
 //BA.debugLineNum = 57;BA.debugLine="If id.ToLowerCase = \"9774d56d682e549c\" Or id =";
if ((_id.toLowerCase()).equals("9774d56d682e549c") || _id== null) { 
_id = _p.GetSettings("android_id");};
 };
 };
 //BA.debugLineNum = 61;BA.debugLine="Return id";
if (true) return _id;
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static b4a.hamrahpay.lastpurchaseinfo  _getlastpurchase(anywheresoftware.b4a.BA _ba) throws Exception{
 //BA.debugLineNum = 208;BA.debugLine="Public Sub getlastPurchase() As LastPurchaseInfo";
 //BA.debugLineNum = 209;BA.debugLine="Return last_purchase_info";
if (true) return _last_purchase_info;
 //BA.debugLineNum = 210;BA.debugLine="End Sub";
return null;
}
public static boolean  _isconnected(anywheresoftware.b4a.BA _ba) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper _server = null;
 //BA.debugLineNum = 84;BA.debugLine="Sub IsConnected As Boolean";
 //BA.debugLineNum = 85;BA.debugLine="Dim P As Phone,server As ServerSocket";
_p = new anywheresoftware.b4a.phone.Phone();
_server = new anywheresoftware.b4a.objects.SocketWrapper.ServerSocketWrapper();
 //BA.debugLineNum = 86;BA.debugLine="Try";
try { //BA.debugLineNum = 87;BA.debugLine="server.Initialize(0, \"\")";
_server.Initialize((_ba.processBA == null ? _ba : _ba.processBA),(int) (0),"");
 //BA.debugLineNum = 88;BA.debugLine="If server.GetMyIP = \"127.0.0.1\" Then";
if ((_server.GetMyIP()).equals("127.0.0.1")) { 
 //BA.debugLineNum = 89;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 92;BA.debugLine="If Not(P.GetDataState.EqualsIgnoreCase(\"CON";
if (anywheresoftware.b4a.keywords.Common.Not(_p.GetDataState().equalsIgnoreCase("CONNECTED")) && (_server.GetMyWifiIP()).equals("127.0.0.1")) { 
 //BA.debugLineNum = 93;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 96;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e12) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e12); //BA.debugLineNum = 98;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 100;BA.debugLine="End Sub";
return false;
}
public static boolean  _ispayed(anywheresoftware.b4a.BA _ba,String _sku) throws Exception{
String _pay_hash = "";
String _key_code = "";
 //BA.debugLineNum = 71;BA.debugLine="Sub	isPayed(sku As String) As Boolean";
 //BA.debugLineNum = 72;BA.debugLine="Dim pay_hash As String";
_pay_hash = "";
 //BA.debugLineNum = 73;BA.debugLine="Dim	key_code As String";
_key_code = "";
 //BA.debugLineNum = 74;BA.debugLine="key_code = \"premium_key_\"&sku&GetDeviceId";
_key_code = "premium_key_"+_sku+_getdeviceid(_ba);
 //BA.debugLineNum = 76;BA.debugLine="pay_hash = StateManager.GetSetting2(sku,\"\")";
_pay_hash = mostCurrent._statemanager._getsetting2(_ba,_sku,"");
 //BA.debugLineNum = 77;BA.debugLine="If pay_hash= key_code Then";
if ((_pay_hash).equals(_key_code)) { 
 //BA.debugLineNum = 78;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 80;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return false;
}
public static String  _jobdone(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
anywheresoftware.b4a.objects.collections.JSONParser _json = null;
anywheresoftware.b4a.objects.collections.Map _resultmap = null;
String _req_result = "";
 //BA.debugLineNum = 214;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 215;BA.debugLine="Dim JSON As JSONParser";
_json = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 216;BA.debugLine="Dim ResultMap As Map";
_resultmap = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 218;BA.debugLine="Dim req_result As String";
_req_result = "";
 //BA.debugLineNum = 220;BA.debugLine="If Job.Success = True Then";
if (_job._success==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 221;BA.debugLine="req_result = Job.GetString";
_req_result = _job._getstring();
 //BA.debugLineNum = 222;BA.debugLine="JSON.Initialize(req_result)";
_json.Initialize(_req_result);
 //BA.debugLineNum = 223;BA.debugLine="ResultMap= JSON.NextObject";
_resultmap = _json.NextObject();
 //BA.debugLineNum = 224;BA.debugLine="Select Job.JobName";
switch (BA.switchObjectToInt(_job._jobname,"Pay_Request","Pay_Verify","Last_Purchase")) {
case 0: {
 //BA.debugLineNum = 226;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 227;BA.debugLine="payment(ResultMap)";
_payment(_ba,_resultmap);
 break; }
case 1: {
 //BA.debugLineNum = 229;BA.debugLine="verify(ResultMap)";
_verify(_ba,_resultmap);
 break; }
case 2: {
 //BA.debugLineNum = 231;BA.debugLine="setLastPurchaseIfo(ResultMap)";
_setlastpurchaseifo(_ba,_resultmap);
 break; }
}
;
 }else {
 //BA.debugLineNum = 234;BA.debugLine="Log(\"Error: \" & Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.Log("Error: "+_job._errormessage);
 //BA.debugLineNum = 235;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMess";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage),anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 237;BA.debugLine="Job.Release";
_job._release();
 //BA.debugLineNum = 238;BA.debugLine="End Sub";
return "";
}
public static String  _makepayed(anywheresoftware.b4a.BA _ba,String _sku) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub	MakePayed(sku As String)";
 //BA.debugLineNum = 66;BA.debugLine="StateManager.SetSetting(sku,\"premium_key_\"&sku&Ge";
mostCurrent._statemanager._setsetting(_ba,_sku,"premium_key_"+_sku+_getdeviceid(_ba));
 //BA.debugLineNum = 67;BA.debugLine="StateManager.SaveSettings";
mostCurrent._statemanager._savesettings(_ba);
 //BA.debugLineNum = 68;BA.debugLine="End Sub";
return "";
}
public static String  _pay_request(anywheresoftware.b4a.BA _ba,String _sku,Object _m_activity) throws Exception{
String _post_param = "";
String _package_name = "";
 //BA.debugLineNum = 151;BA.debugLine="Sub pay_request(sku As String,m_activity As Object";
 //BA.debugLineNum = 152;BA.debugLine="If IsConnected=False Then";
if (_isconnected(_ba)==anywheresoftware.b4a.keywords.Common.False) { 
 //BA.debugLineNum = 153;BA.debugLine="ToastMessageShow(\"دستگاه شما به اینترنت متصل نمی";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("دستگاه شما به اینترنت متصل نمیباشد . لطفا از صحت اتصال به اینترنت اطمینان حاصل فرمایید."),anywheresoftware.b4a.keywords.Common.True);
 }else {
 //BA.debugLineNum = 155;BA.debugLine="parent_activity = m_activity";
_parent_activity = _m_activity;
 //BA.debugLineNum = 156;BA.debugLine="pay_request_url = \"https://hamrahpay.com/rest-ap";
_pay_request_url = "https://hamrahpay.com/rest-api/pay-request";
 //BA.debugLineNum = 157;BA.debugLine="product_sku = sku";
_product_sku = _sku;
 //BA.debugLineNum = 158;BA.debugLine="Dim post_param As String";
_post_param = "";
 //BA.debugLineNum = 159;BA.debugLine="Dim package_name As String";
_package_name = "";
 //BA.debugLineNum = 160;BA.debugLine="package_name = Application.PackageName";
_package_name = anywheresoftware.b4a.keywords.Common.Application.getPackageName();
 //BA.debugLineNum = 161;BA.debugLine="post_param =  \"sku=\"&sku&\"&device_id=\"&GetDevice";
_post_param = "sku="+_sku+"&device_id="+_getdeviceid(_ba)+"&verification_type="+_verification_type+"library_version="+_lib_vers+"library_name="+_lib_name+"package_id="+_package_name;
 //BA.debugLineNum = 162;BA.debugLine="HttpUtils.Initialize(\"Pay_Request\",parent_activi";
_httputils._initialize((_ba.processBA == null ? _ba : _ba.processBA),"Pay_Request",_parent_activity);
 //BA.debugLineNum = 163;BA.debugLine="HttpUtils.PostString(pay_request_url, post_param";
_httputils._poststring(_pay_request_url,_post_param);
 //BA.debugLineNum = 165;BA.debugLine="ProgressDialogShow2(\"لطفا صبور باشید ، در حال بر";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(_ba,BA.ObjectToCharSequence("لطفا صبور باشید ، در حال بر قراری ارتباط با سرور..."),anywheresoftware.b4a.keywords.Common.False);
 };
 //BA.debugLineNum = 169;BA.debugLine="End Sub";
return "";
}
public static String  _payment(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _res_map) throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Private Sub payment(res_map As Map)";
 //BA.debugLineNum = 125;BA.debugLine="pay_url = \"https://hamrahpay.com/cart/app/pay_v2/";
_pay_url = "https://hamrahpay.com/cart/app/pay_v2/";
 //BA.debugLineNum = 126;BA.debugLine="status = res_map.Get(\"status\")";
_status = BA.ObjectToString(_res_map.Get((Object)("status")));
 //BA.debugLineNum = 127;BA.debugLine="error = res_map.Get(\"error\")";
_error = BA.ObjectToBoolean(_res_map.Get((Object)("error")));
 //BA.debugLineNum = 128;BA.debugLine="If (error=False) Then";
if ((_error==anywheresoftware.b4a.keywords.Common.False)) { 
 //BA.debugLineNum = 129;BA.debugLine="If status=\"SELLER_BLOCKED\" Or status=\"TRY_AGAIN\"";
if ((_status).equals("SELLER_BLOCKED") || (_status).equals("TRY_AGAIN") || (_status).equals("BAD_PARAMETERS")) { 
 //BA.debugLineNum = 130;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 }else if((_status).equals("READY_TO_PAY")) { 
 //BA.debugLineNum = 132;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
_pay_code = BA.ObjectToString(_res_map.Get((Object)("pay_code")));
 //BA.debugLineNum = 133;BA.debugLine="pay_url = pay_url&pay_code";
_pay_url = _pay_url+_pay_code;
 //BA.debugLineNum = 134;BA.debugLine="StartActivity(payment_activity)";
anywheresoftware.b4a.keywords.Common.StartActivity((_ba.processBA == null ? _ba : _ba.processBA),(Object)(mostCurrent._payment_activity.getObject()));
 }else if((_status).equals("BEFORE_PAID")) { 
 //BA.debugLineNum = 137;BA.debugLine="pay_code = res_map.Get(\"pay_code\")";
_pay_code = BA.ObjectToString(_res_map.Get((Object)("pay_code")));
 //BA.debugLineNum = 138;BA.debugLine="verify_payment(pay_code,product_sku)";
_verify_payment(_ba,_pay_code,_product_sku);
 //BA.debugLineNum = 139;BA.debugLine="If pay_status=True Then";
if (_pay_status==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 140;BA.debugLine="activate_app";
_activate_app(_ba);
 };
 }else {
 //BA.debugLineNum = 143;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 };
 }else {
 //BA.debugLineNum = 146;BA.debugLine="ToastMessageShow(res_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_res_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 147;BA.debugLine="pay_code=\"\"";
_pay_code = "";
 };
 //BA.debugLineNum = 149;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Dim	verification_type As String";
_verification_type = "";
 //BA.debugLineNum = 10;BA.debugLine="verification_type =\"device_verification\"";
_verification_type = "device_verification";
 //BA.debugLineNum = 12;BA.debugLine="Dim pay_request_url As String";
_pay_request_url = "";
 //BA.debugLineNum = 13;BA.debugLine="Dim	pay_verify_url As String";
_pay_verify_url = "";
 //BA.debugLineNum = 14;BA.debugLine="Dim last_purchase_url As String";
_last_purchase_url = "";
 //BA.debugLineNum = 15;BA.debugLine="Dim pay_url As String";
_pay_url = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim HttpUtils As HttpJob";
_httputils = new anywheresoftware.b4a.samples.httputils2.httpjob();
 //BA.debugLineNum = 18;BA.debugLine="Dim device_id As String";
_device_id = "";
 //BA.debugLineNum = 19;BA.debugLine="Dim pay_code As String";
_pay_code = "";
 //BA.debugLineNum = 20;BA.debugLine="Dim product_sku As String";
_product_sku = "";
 //BA.debugLineNum = 21;BA.debugLine="Dim status	As String";
_status = "";
 //BA.debugLineNum = 22;BA.debugLine="Dim error As Boolean";
_error = false;
 //BA.debugLineNum = 23;BA.debugLine="Dim pay_status As Boolean";
_pay_status = false;
 //BA.debugLineNum = 24;BA.debugLine="Dim	parent_activity As Object";
_parent_activity = new Object();
 //BA.debugLineNum = 25;BA.debugLine="Dim lib_vers As String";
_lib_vers = "";
 //BA.debugLineNum = 26;BA.debugLine="Dim lib_name As String";
_lib_name = "";
 //BA.debugLineNum = 27;BA.debugLine="pay_status= False";
_pay_status = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 28;BA.debugLine="error=False";
_error = anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 29;BA.debugLine="product_sku=\"\"";
_product_sku = "";
 //BA.debugLineNum = 30;BA.debugLine="lib_vers = 3";
_lib_vers = BA.NumberToString(3);
 //BA.debugLineNum = 31;BA.debugLine="lib_name = \"B4A\"";
_lib_name = "B4A";
 //BA.debugLineNum = 32;BA.debugLine="Dim last_purchase_info As LastPurchaseInfo";
_last_purchase_info = new b4a.hamrahpay.lastpurchaseinfo();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _retrivelastpurchaseinfo(anywheresoftware.b4a.BA _ba,String _psku,Object _m_activity) throws Exception{
 //BA.debugLineNum = 187;BA.debugLine="Public Sub RetriveLastPurchaseInfo(pSku As String,";
 //BA.debugLineNum = 188;BA.debugLine="parent_activity = m_activity";
_parent_activity = _m_activity;
 //BA.debugLineNum = 189;BA.debugLine="last_purchase_url = \"https://hamrahpay.com/rest-a";
_last_purchase_url = "https://hamrahpay.com/rest-api/trans-info";
 //BA.debugLineNum = 190;BA.debugLine="HttpUtils.Initialize(\"Last_Purchase\",parent_activ";
_httputils._initialize((_ba.processBA == null ? _ba : _ba.processBA),"Last_Purchase",_parent_activity);
 //BA.debugLineNum = 191;BA.debugLine="HttpUtils.PostString(last_purchase_url, \"sku=\"&pS";
_httputils._poststring(_last_purchase_url,"sku="+_psku+"&device_id="+_getdeviceid(_ba));
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return "";
}
public static String  _setlastpurchaseifo(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _res_map) throws Exception{
 //BA.debugLineNum = 194;BA.debugLine="Private Sub setLastPurchaseIfo(res_map As Map)";
 //BA.debugLineNum = 196;BA.debugLine="last_purchase_info.error= res_map.Get(\"error\")";
_last_purchase_info._error = BA.ObjectToBoolean(_res_map.Get((Object)("error")));
 //BA.debugLineNum = 197;BA.debugLine="last_purchase_info.message = res_map.Get(\"message";
_last_purchase_info._message = BA.ObjectToString(_res_map.Get((Object)("message")));
 //BA.debugLineNum = 199;BA.debugLine="If(res_map.ContainsKey(\"days_ago\")) Then";
if ((_res_map.ContainsKey((Object)("days_ago")))) { 
 //BA.debugLineNum = 200;BA.debugLine="last_purchase_info.current_date = res_map.Get(\"cu";
_last_purchase_info._current_date = BA.ObjectToString(_res_map.Get((Object)("current_date")));
 //BA.debugLineNum = 201;BA.debugLine="last_purchase_info.days_ago = res_map.Get(\"days_a";
_last_purchase_info._days_ago = (int)(BA.ObjectToNumber(_res_map.Get((Object)("days_ago"))));
 //BA.debugLineNum = 202;BA.debugLine="last_purchase_info.date = res_map.Get(\"date\")";
_last_purchase_info._date = BA.ObjectToString(_res_map.Get((Object)("date")));
 //BA.debugLineNum = 203;BA.debugLine="last_purchase_info.reserve_id = res_map.Get(\"rese";
_last_purchase_info._reserve_id = BA.ObjectToString(_res_map.Get((Object)("reserve_id")));
 //BA.debugLineNum = 204;BA.debugLine="last_purchase_info.unixTimestamp = res_map.Get(\"d";
_last_purchase_info._unixtimestamp = BA.ObjectToString(_res_map.Get((Object)("date_unix_timestamp")));
 };
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public static String  _verify(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.Map _verify_map) throws Exception{
 //BA.debugLineNum = 102;BA.debugLine="Private Sub verify(verify_map As Map)";
 //BA.debugLineNum = 103;BA.debugLine="status = verify_map.Get(\"status\")";
_status = BA.ObjectToString(_verify_map.Get((Object)("status")));
 //BA.debugLineNum = 104;BA.debugLine="error = verify_map.Get(\"error\")";
_error = BA.ObjectToBoolean(_verify_map.Get((Object)("error")));
 //BA.debugLineNum = 106;BA.debugLine="If error=True Then";
if (_error==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(verify_map.Get(\"message\"),True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(_verify_map.Get((Object)("message"))),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="pay_status= False";
_pay_status = anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 110;BA.debugLine="If status=\"SUCCESSFUL_PAYMENT\" Then";
if ((_status).equals("SUCCESSFUL_PAYMENT")) { 
 //BA.debugLineNum = 111;BA.debugLine="pay_status= True";
_pay_status = anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 113;BA.debugLine="pay_status= False";
_pay_status = anywheresoftware.b4a.keywords.Common.False;
 };
 };
 //BA.debugLineNum = 116;BA.debugLine="If (pay_status=True) Then";
if ((_pay_status==anywheresoftware.b4a.keywords.Common.True)) { 
 //BA.debugLineNum = 117;BA.debugLine="activate_app";
_activate_app(_ba);
 };
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return "";
}
public static String  _verify_payment(anywheresoftware.b4a.BA _ba,String _pay_code_param,String _sku) throws Exception{
String _device_model = "";
String _device_manufacturer = "";
String _sdk_version = "";
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 171;BA.debugLine="Sub verify_payment(pay_code_param As String,sku As";
 //BA.debugLineNum = 172;BA.debugLine="Dim	device_model As String";
_device_model = "";
 //BA.debugLineNum = 173;BA.debugLine="Dim device_manufacturer As String";
_device_manufacturer = "";
 //BA.debugLineNum = 174;BA.debugLine="Dim sdk_version As String";
_sdk_version = "";
 //BA.debugLineNum = 175;BA.debugLine="Dim	p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 177;BA.debugLine="device_model = p.Model";
_device_model = _p.getModel();
 //BA.debugLineNum = 178;BA.debugLine="device_manufacturer = p.Manufacturer";
_device_manufacturer = _p.getManufacturer();
 //BA.debugLineNum = 179;BA.debugLine="sdk_version = p.SdkVersion";
_sdk_version = BA.NumberToString(_p.getSdkVersion());
 //BA.debugLineNum = 181;BA.debugLine="pay_verify_url = \"https://hamrahpay.com/rest-api/";
_pay_verify_url = "https://hamrahpay.com/rest-api/verify-payment";
 //BA.debugLineNum = 182;BA.debugLine="HttpUtils.Initialize(\"Pay_Verify\",parent_activity";
_httputils._initialize((_ba.processBA == null ? _ba : _ba.processBA),"Pay_Verify",_parent_activity);
 //BA.debugLineNum = 183;BA.debugLine="HttpUtils.PostString(pay_verify_url, \"pay_code=\"&";
_httputils._poststring(_pay_verify_url,"pay_code="+_pay_code_param+"&sku="+_sku+"&device_model="+_device_model+"&device_manufacturer="+_device_manufacturer+"&sdk_version="+_sdk_version);
 //BA.debugLineNum = 185;BA.debugLine="End Sub";
return "";
}
}
