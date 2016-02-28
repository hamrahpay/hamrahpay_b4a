
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

public class payment_activity implements IRemote{
	public static payment_activity mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public payment_activity() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("payment_activity"), "b4a.hamrahpay.payment_activity");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, payment_activity.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _browser = RemoteObject.declareNull("anywheresoftware.b4a.objects.WebViewWrapper");
public static RemoteObject _addressbar = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _webchromeclient = RemoteObject.declareNull("uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient");
public static RemoteObject _webclient = RemoteObject.declareNull("uk.co.martinpearman.b4a.webkit.DefaultWebViewClient");
public static RemoteObject _sett = RemoteObject.declareNull("uk.co.martinpearman.b4a.webkit.WebViewExtras");
public static RemoteObject _httputils2service = RemoteObject.declareNull("anywheresoftware.b4a.samples.httputils2.httputils2service");
public static b4a.hamrahpay.main _main = null;
public static b4a.hamrahpay.hamrahpay _hamrahpay = null;
public static b4a.hamrahpay.statemanager _statemanager = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",payment_activity.mostCurrent._activity,"addressbar",payment_activity.mostCurrent._addressbar,"browser",payment_activity.mostCurrent._browser,"hamrahpay",Debug.moduleToString(b4a.hamrahpay.hamrahpay.class),"HttpUtils2Service",payment_activity.mostCurrent._httputils2service,"Main",Debug.moduleToString(b4a.hamrahpay.main.class),"sett",payment_activity.mostCurrent._sett,"StateManager",Debug.moduleToString(b4a.hamrahpay.statemanager.class),"WebChromeClient",payment_activity.mostCurrent._webchromeclient,"WebClient",payment_activity.mostCurrent._webclient};
}
}