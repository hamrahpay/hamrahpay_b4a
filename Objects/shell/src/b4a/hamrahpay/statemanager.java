
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

public class statemanager implements IRemote{
	public static statemanager mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public statemanager() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
public boolean isSingleton() {
		return true;
	}
     private static PCBA pcBA = new PCBA(null, statemanager.class);
    static {
		mostCurrent = new statemanager();
        remoteMe = RemoteObject.declareNull("b4a.hamrahpay.statemanager");
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("statemanager"), "b4a.hamrahpay.statemanager");
        RDebug.INSTANCE.eventTargets.put(new DeviceClass("b4a.hamrahpay.statemanager"), new java.lang.ref.WeakReference<PCBA> (pcBA));
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
public static RemoteObject _states = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _listposition = RemoteObject.createImmutable(0);
public static RemoteObject _statesfilename = RemoteObject.createImmutable("");
public static RemoteObject _settingsfilename = RemoteObject.createImmutable("");
public static RemoteObject _settings = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.hamrahpay.main _main = null;
public static b4a.hamrahpay.hamrahpay _hamrahpay = null;
public static b4a.hamrahpay.payment_activity _payment_activity = null;
  public Object[] GetGlobals() {
		return new Object[] {"hamrahpay",Debug.moduleToString(b4a.hamrahpay.hamrahpay.class),"HttpUtils2Service",statemanager.mostCurrent._httputils2service,"listPosition",statemanager._listposition,"Main",Debug.moduleToString(b4a.hamrahpay.main.class),"payment_activity",Debug.moduleToString(b4a.hamrahpay.payment_activity.class),"settings",statemanager._settings,"settingsFileName",statemanager._settingsfilename,"states",statemanager._states,"statesFileName",statemanager._statesfilename};
}
}