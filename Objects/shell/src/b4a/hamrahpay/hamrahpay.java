
package b4a.hamrahpay;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class hamrahpay implements IRemote{
	public static hamrahpay mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public hamrahpay() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, hamrahpay.class);
    static {
		mostCurrent = new hamrahpay();
        remoteMe = RemoteObject.declareNull("b4a.hamrahpay.hamrahpay");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("hamrahpay"), "b4a.hamrahpay.hamrahpay");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.hamrahpay.hamrahpay"), new java.lang.ref.WeakReference<PCBA> (pcBA));
	}
   
	public static RemoteObject runMethod(boolean notUsed, String method, Object... args) throws Exception{
		return (RemoteObject) pcBA.raiseEvent(method.substring(1), args);
	}
    public static void runVoidMethod(String method, Object... args) throws Exception{
		runMethod(false, method, args);
	}
	public PCBA create(Object[] args) throws ClassNotFoundException{
        throw new RuntimeException("CREATE is not supported.");
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _verification_type = RemoteObject.createImmutable("");
public static RemoteObject _pay_request_url = RemoteObject.createImmutable("");
public static RemoteObject _pay_verify_url = RemoteObject.createImmutable("");
public static RemoteObject _pay_url = RemoteObject.createImmutable("");
public static RemoteObject _httputils = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httpjob");
public static RemoteObject _device_id = RemoteObject.createImmutable("");
public static RemoteObject _pay_code = RemoteObject.createImmutable("");
public static RemoteObject _product_sku = RemoteObject.createImmutable("");
public static RemoteObject _status = RemoteObject.createImmutable("");
public static RemoteObject _error = RemoteObject.createImmutable(false);
public static RemoteObject _pay_status = RemoteObject.createImmutable(false);
public static RemoteObject _parent_activity = RemoteObject.declareNull("Object");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.hamrahpay.main _main = null;
public static b4a.hamrahpay.payment_activity _payment_activity = null;
public static b4a.hamrahpay.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"device_id",hamrahpay._device_id,"error",hamrahpay._error,"HttpUtils",hamrahpay._httputils,"HttpUtils2Service",hamrahpay.mostCurrent._httputils2service,"Main",Debug.moduleToString(b4a.hamrahpay.main.class),"parent_activity",hamrahpay._parent_activity,"pay_code",hamrahpay._pay_code,"pay_request_url",hamrahpay._pay_request_url,"pay_status",hamrahpay._pay_status,"pay_url",hamrahpay._pay_url,"pay_verify_url",hamrahpay._pay_verify_url,"payment_activity",Debug.moduleToString(b4a.hamrahpay.payment_activity.class),"product_sku",hamrahpay._product_sku,"StateManager",Debug.moduleToString(b4a.hamrahpay.statemanager.class),"status",hamrahpay._status,"verification_type",hamrahpay._verification_type};
}
}