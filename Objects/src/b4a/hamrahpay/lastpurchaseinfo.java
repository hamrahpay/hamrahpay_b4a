package b4a.hamrahpay;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class lastpurchaseinfo extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "b4a.hamrahpay.lastpurchaseinfo");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", b4a.hamrahpay.lastpurchaseinfo.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _status = "";
public String _message = "";
public String _unixtimestamp = "";
public String _date = "";
public String _reserve_id = "";
public String _current_date = "";
public int _days_ago = 0;
public boolean _error = false;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.hamrahpay _hamrahpay = null;
public b4a.hamrahpay.payment_activity _payment_activity = null;
public b4a.hamrahpay.statemanager _statemanager = null;
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 1;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 2;BA.debugLine="Dim status,message,unixTimestamp,date,reserve_id,";
_status = "";
_message = "";
_unixtimestamp = "";
_date = "";
_reserve_id = "";
_current_date = "";
 //BA.debugLineNum = 3;BA.debugLine="Dim days_ago As Int";
_days_ago = 0;
 //BA.debugLineNum = 4;BA.debugLine="Dim error As Boolean";
_error = false;
 //BA.debugLineNum = 5;BA.debugLine="End Sub";
return "";
}
public String  _getcurrentdate() throws Exception{
 //BA.debugLineNum = 47;BA.debugLine="Public Sub getCurrentDate() As String";
 //BA.debugLineNum = 48;BA.debugLine="Return current_date";
if (true) return _current_date;
 //BA.debugLineNum = 49;BA.debugLine="End Sub";
return "";
}
public String  _getdate() throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Public Sub getDate() As String";
 //BA.debugLineNum = 36;BA.debugLine="Return date";
if (true) return _date;
 //BA.debugLineNum = 37;BA.debugLine="End Sub";
return "";
}
public int  _getdaysago() throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Public Sub getDaysAgo() As Int";
 //BA.debugLineNum = 44;BA.debugLine="Return days_ago";
if (true) return _days_ago;
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return 0;
}
public boolean  _geterror() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Public Sub getError() As Boolean";
 //BA.debugLineNum = 24;BA.debugLine="Return error";
if (true) return _error;
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return false;
}
public String  _getmessage() throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Public Sub getMessage() As String";
 //BA.debugLineNum = 28;BA.debugLine="Return message";
if (true) return _message;
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public String  _getreserveid() throws Exception{
 //BA.debugLineNum = 39;BA.debugLine="Public Sub getReserveID() As String";
 //BA.debugLineNum = 40;BA.debugLine="Return reserve_id";
if (true) return _reserve_id;
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public String  _getstatus() throws Exception{
 //BA.debugLineNum = 19;BA.debugLine="Public Sub getStatus() As String";
 //BA.debugLineNum = 20;BA.debugLine="Return status";
if (true) return _status;
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public String  _getunixtimestamp() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Public Sub getUnixTimestamp() As String";
 //BA.debugLineNum = 32;BA.debugLine="Return unixTimestamp";
if (true) return _unixtimestamp;
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _pstatus,boolean _perror,String _pmessage,String _punixtimestamp,String _pdate,String _preserve_id,int _pdays_ago,String _pcurrent_date) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 8;BA.debugLine="Public Sub Initialize(pStatus As String, pError As";
 //BA.debugLineNum = 9;BA.debugLine="status = pStatus";
_status = _pstatus;
 //BA.debugLineNum = 10;BA.debugLine="error = pError";
_error = _perror;
 //BA.debugLineNum = 11;BA.debugLine="message = pMessage";
_message = _pmessage;
 //BA.debugLineNum = 12;BA.debugLine="unixTimestamp = pUnixTimestamp";
_unixtimestamp = _punixtimestamp;
 //BA.debugLineNum = 13;BA.debugLine="date = pDate";
_date = _pdate;
 //BA.debugLineNum = 14;BA.debugLine="reserve_id = pReserve_id";
_reserve_id = _preserve_id;
 //BA.debugLineNum = 15;BA.debugLine="days_ago = pDays_ago";
_days_ago = _pdays_ago;
 //BA.debugLineNum = 16;BA.debugLine="current_date = pCurrent_date";
_current_date = _pcurrent_date;
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
