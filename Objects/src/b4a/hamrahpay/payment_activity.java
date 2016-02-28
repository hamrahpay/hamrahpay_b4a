package b4a.hamrahpay;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class payment_activity extends Activity implements B4AActivity{
	public static payment_activity mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.hamrahpay", "b4a.hamrahpay.payment_activity");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (payment_activity).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, true))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.hamrahpay", "b4a.hamrahpay.payment_activity");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.hamrahpay.payment_activity", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (payment_activity) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (payment_activity) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEvent(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return payment_activity.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (payment_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (payment_activity) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.WebViewWrapper _browser = null;
public anywheresoftware.b4a.objects.LabelWrapper _addressbar = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient _webchromeclient = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebViewClient _webclient = null;
public uk.co.martinpearman.b4a.webkit.WebViewExtras _sett = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.hamrahpay _hamrahpay = null;
public b4a.hamrahpay.statemanager _statemanager = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=1507328;
 //BA.debugLineNum = 1507328;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=1507329;
 //BA.debugLineNum = 1507329;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("activity_pause"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_pause", new Object[] {_userclosed});
boolean _pay_status = false;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=1638401;
 //BA.debugLineNum = 1638401;BA.debugLine="Dim pay_status As Boolean";
_pay_status = false;
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="If UserClosed=True Then";
if (_userclosed==anywheresoftware.b4a.keywords.Common.True) { 
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="hamrahpay.verify_payment(hamrahpay.pay_code,hamr";
mostCurrent._hamrahpay._verify_payment(mostCurrent.activityBA,mostCurrent._hamrahpay._pay_code,mostCurrent._hamrahpay._product_sku);
 };
RDebugUtils.currentLine=1638405;
 //BA.debugLineNum = 1638405;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="addressbar.Initialize(\"addressbar\")";
mostCurrent._addressbar.Initialize(mostCurrent.activityBA,"addressbar");
RDebugUtils.currentLine=1572869;
 //BA.debugLineNum = 1572869;BA.debugLine="browser.Initialize(\"browser\")";
mostCurrent._browser.Initialize(mostCurrent.activityBA,"browser");
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="browser.JavaScriptEnabled = True";
mostCurrent._browser.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572872;
 //BA.debugLineNum = 1572872;BA.debugLine="WebChromeClient.Initialize(\"WebChromeClient\")";
mostCurrent._webchromeclient.Initialize(mostCurrent.activityBA,"WebChromeClient");
RDebugUtils.currentLine=1572873;
 //BA.debugLineNum = 1572873;BA.debugLine="WebClient.Initialize(\"WebClient\")";
mostCurrent._webclient.Initialize(mostCurrent.activityBA,"WebClient");
RDebugUtils.currentLine=1572875;
 //BA.debugLineNum = 1572875;BA.debugLine="sett.Initialize(browser)";
mostCurrent._sett.Initialize((android.webkit.WebView)(mostCurrent._browser.getObject()));
RDebugUtils.currentLine=1572876;
 //BA.debugLineNum = 1572876;BA.debugLine="sett.GetSettings.SetDOMStorageEnabled(True)";
mostCurrent._sett.GetSettings().SetDOMStorageEnabled(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=1572879;
 //BA.debugLineNum = 1572879;BA.debugLine="sett.SetWebChromeClient(WebChromeClient)";
mostCurrent._sett.SetWebChromeClient((android.webkit.WebChromeClient)(mostCurrent._webchromeclient.getObject()));
RDebugUtils.currentLine=1572882;
 //BA.debugLineNum = 1572882;BA.debugLine="Activity.AddView(sett, 0, 4%y, 100%x, 100%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._sett.getObject()),(int) (0),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (4),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
RDebugUtils.currentLine=1572883;
 //BA.debugLineNum = 1572883;BA.debugLine="sett.LoadUrl(hamrahpay.pay_url)";
mostCurrent._sett.LoadUrl(mostCurrent._hamrahpay._pay_url);
RDebugUtils.currentLine=1572884;
 //BA.debugLineNum = 1572884;BA.debugLine="addressbar.Text=hamrahpay.pay_url";
mostCurrent._addressbar.setText((Object)(mostCurrent._hamrahpay._pay_url));
RDebugUtils.currentLine=1572885;
 //BA.debugLineNum = 1572885;BA.debugLine="addressbar.Color=Colors.LightGray";
mostCurrent._addressbar.setColor(anywheresoftware.b4a.keywords.Common.Colors.LightGray);
RDebugUtils.currentLine=1572886;
 //BA.debugLineNum = 1572886;BA.debugLine="addressbar.TextColor=Colors.Black";
mostCurrent._addressbar.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
RDebugUtils.currentLine=1572889;
 //BA.debugLineNum = 1572889;BA.debugLine="Activity.AddView(addressbar,0,0,100%x,6%y)";
mostCurrent._activity.AddView((android.view.View)(mostCurrent._addressbar.getObject()),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (6),mostCurrent.activityBA));
RDebugUtils.currentLine=1572890;
 //BA.debugLineNum = 1572890;BA.debugLine="ProgressDialogShow2(\"لطفا صبور باشید...\",False";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,"لطفا صبور باشید...",anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1572891;
 //BA.debugLineNum = 1572891;BA.debugLine="End Sub";
return "";
}
public static boolean  _browser_overrideurl(String _url) throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("browser_overrideurl"))
	return (Boolean) Debug.delegate(mostCurrent.activityBA, "browser_overrideurl", new Object[] {_url});
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub browser_OverrideUrl (Url As String) As Boolean";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="addressbar.Text = Url";
mostCurrent._addressbar.setText((Object)(_url));
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="browser.LoadUrl(Url)";
mostCurrent._browser.LoadUrl(_url);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="If (Url.ToLowerCase.Contains(\"shaparak.ir\") And U";
if ((_url.toLowerCase().contains("shaparak.ir") && _url.toLowerCase().startsWith("https://"))) { 
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="addressbar.Color=Colors.RGB(90,162,43)";
mostCurrent._addressbar.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (90),(int) (162),(int) (43)));
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="addressbar.SetTextColorAnimated(0,Colors.RGB(255";
mostCurrent._addressbar.SetTextColorAnimated((int) (0),anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (255),(int) (255),(int) (255)));
 };
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
if (_url.toLowerCase().contains("exit_page")) { 
RDebugUtils.currentLine=1769482;
 //BA.debugLineNum = 1769482;BA.debugLine="Activity_Pause(True)";
_activity_pause(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1769485;
 //BA.debugLineNum = 1769485;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
if (_url.toLowerCase().contains("exit_page")) { 
RDebugUtils.currentLine=1769486;
 //BA.debugLineNum = 1769486;BA.debugLine="Activity_Pause(True)";
_activity_pause(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1769490;
 //BA.debugLineNum = 1769490;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
RDebugUtils.currentLine=1769491;
 //BA.debugLineNum = 1769491;BA.debugLine="End Sub";
return false;
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("jobdone"))
	return (String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job});
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub JobDone (Job As HttpJob)";
RDebugUtils.currentLine=1835009;
 //BA.debugLineNum = 1835009;BA.debugLine="hamrahpay.JobDone(Job)";
mostCurrent._hamrahpay._jobdone(mostCurrent.activityBA,_job);
RDebugUtils.currentLine=1835010;
 //BA.debugLineNum = 1835010;BA.debugLine="End Sub";
return "";
}
public static String  _webchromeclient_progresschanged(int _newprogress) throws Exception{
RDebugUtils.currentModule="payment_activity";
if (Debug.shouldDelegate("webchromeclient_progresschanged"))
	return (String) Debug.delegate(mostCurrent.activityBA, "webchromeclient_progresschanged", new Object[] {_newprogress});
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub WebChromeClient_ProgressChanged(NewProgress As";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="If NewProgress=100 Then";
if (_newprogress==100) { 
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="sett.Visible = False";
mostCurrent._sett.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="sett.Visible=True";
mostCurrent._sett.setVisible(anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="End Sub";
return "";
}
}