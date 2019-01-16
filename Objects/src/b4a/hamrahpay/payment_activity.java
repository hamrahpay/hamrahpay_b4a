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
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "b4a.hamrahpay", "b4a.hamrahpay.payment_activity");
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
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
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
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
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
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
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
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
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
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (payment_activity) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
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
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.WebViewWrapper _browser = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient _webchromeclient = null;
public uk.co.martinpearman.b4a.webkit.DefaultWebViewClient _webclient = null;
public uk.co.martinpearman.b4a.webkit.WebViewExtras _sett = null;
public static String _lastloadedurl = "";
public anywheresoftware.b4a.objects.LabelWrapper _url_label = null;
public anywheresoftware.b4a.objects.LabelWrapper _protocol_icon = null;
public anywheresoftware.b4a.objects.LabelWrapper _page_title = null;
public anywheresoftware.b4a.objects.ProgressBarWrapper _web_progressbar = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.hamrahpay _hamrahpay = null;
public b4a.hamrahpay.statemanager _statemanager = null;

public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 29;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 107;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 109;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 110;BA.debugLine="If url_label.Text.Contains(\"shaparak.ir\") Then";
if (mostCurrent._url_label.getText().contains("shaparak.ir")) { 
 //BA.debugLineNum = 111;BA.debugLine="If Msgbox2(\"شما در صفحه بانک هستید. آیا تمایل به";
if (anywheresoftware.b4a.keywords.Common.Msgbox2(BA.ObjectToCharSequence("شما در صفحه بانک هستید. آیا تمایل به لغو خرید و خروج این صفحه دارید؟"),BA.ObjectToCharSequence(""),"بله","","خیر",(android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null),mostCurrent.activityBA)==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
 //BA.debugLineNum = 112;BA.debugLine="ToastMessageShow(\"خروج از صفحه ی پراداخت انجام";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("خروج از صفحه ی پراداخت انجام گردید."),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 113;BA.debugLine="ExitApplication 'App is exiting";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 }else {
 //BA.debugLineNum = 115;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 };
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
boolean _pay_status = false;
 //BA.debugLineNum = 61;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 62;BA.debugLine="Dim pay_status As Boolean";
_pay_status = false;
 //BA.debugLineNum = 63;BA.debugLine="If UserClosed=True Then";
if (_userclosed==anywheresoftware.b4a.keywords.Common.True) { 
 //BA.debugLineNum = 64;BA.debugLine="hamrahpay.verify_payment(hamrahpay.pay_code,hamr";
mostCurrent._hamrahpay._verify_payment(mostCurrent.activityBA,mostCurrent._hamrahpay._pay_code,mostCurrent._hamrahpay._product_sku);
 };
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"pay_activity\")";
mostCurrent._activity.LoadLayout("pay_activity",mostCurrent.activityBA);
 //BA.debugLineNum = 36;BA.debugLine="url_label.Color=Colors.White";
mostCurrent._url_label.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 37;BA.debugLine="url_label.TextColor=Colors.Black";
mostCurrent._url_label.setTextColor(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 38;BA.debugLine="protocol_icon.Color =Colors.White";
mostCurrent._protocol_icon.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 40;BA.debugLine="browser.JavaScriptEnabled = True";
mostCurrent._browser.setJavaScriptEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 41;BA.debugLine="browser.ZoomEnabled=False";
mostCurrent._browser.setZoomEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 43;BA.debugLine="WebChromeClient.Initialize(\"WebChromeClient\")";
mostCurrent._webchromeclient.Initialize(mostCurrent.activityBA,"WebChromeClient");
 //BA.debugLineNum = 44;BA.debugLine="WebClient.Initialize(\"WebClient\")";
mostCurrent._webclient.Initialize(mostCurrent.activityBA,"WebClient");
 //BA.debugLineNum = 47;BA.debugLine="sett.Initialize(browser)";
mostCurrent._sett.Initialize((android.webkit.WebView)(mostCurrent._browser.getObject()));
 //BA.debugLineNum = 48;BA.debugLine="sett.GetSettings.SetDOMStorageEnabled(True)";
mostCurrent._sett.GetSettings().SetDOMStorageEnabled(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 50;BA.debugLine="sett.SetWebViewClient(WebClient)";
mostCurrent._sett.SetWebViewClient((android.webkit.WebViewClient)(mostCurrent._webclient.getObject()));
 //BA.debugLineNum = 51;BA.debugLine="sett.SetWebChromeClient(WebChromeClient)";
mostCurrent._sett.SetWebChromeClient((android.webkit.WebChromeClient)(mostCurrent._webchromeclient.getObject()));
 //BA.debugLineNum = 53;BA.debugLine="sett.LoadUrl(hamrahpay.pay_url)";
mostCurrent._sett.LoadUrl(mostCurrent._hamrahpay._pay_url);
 //BA.debugLineNum = 56;BA.debugLine="ProgressDialogShow2(\"لطفا صبور باشید...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("لطفا صبور باشید..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 58;BA.debugLine="End Sub";
return "";
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private browser As WebView";
mostCurrent._browser = new anywheresoftware.b4a.objects.WebViewWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Dim WebChromeClient As DefaultWebChromeClient";
mostCurrent._webchromeclient = new uk.co.martinpearman.b4a.webkit.DefaultWebChromeClient();
 //BA.debugLineNum = 19;BA.debugLine="Dim WebClient As DefaultWebViewClient";
mostCurrent._webclient = new uk.co.martinpearman.b4a.webkit.DefaultWebViewClient();
 //BA.debugLineNum = 20;BA.debugLine="Dim sett As WebViewExtras";
mostCurrent._sett = new uk.co.martinpearman.b4a.webkit.WebViewExtras();
 //BA.debugLineNum = 22;BA.debugLine="Dim LastLoadedUrl As String";
mostCurrent._lastloadedurl = "";
 //BA.debugLineNum = 23;BA.debugLine="Private url_label As Label";
mostCurrent._url_label = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private protocol_icon As Label";
mostCurrent._protocol_icon = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 25;BA.debugLine="Private page_title As Label";
mostCurrent._page_title = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 26;BA.debugLine="Private web_progressbar As ProgressBar";
mostCurrent._web_progressbar = new anywheresoftware.b4a.objects.ProgressBarWrapper();
 //BA.debugLineNum = 27;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(anywheresoftware.b4a.samples.httputils2.httpjob _job) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Sub JobDone (Job As HttpJob)";
 //BA.debugLineNum = 104;BA.debugLine="hamrahpay.JobDone(Job)";
mostCurrent._hamrahpay._jobdone(mostCurrent.activityBA,_job);
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return "";
}
public static String  _sett_progresschanged(int _newprogress) throws Exception{
 //BA.debugLineNum = 98;BA.debugLine="Sub sett_ProgressChanged(NewProgress As Int)";
 //BA.debugLineNum = 100;BA.debugLine="Log(\"WebView1 loading progress: \"&NewProgress&\"%\"";
anywheresoftware.b4a.keywords.Common.Log("WebView1 loading progress: "+BA.NumberToString(_newprogress)+"%");
 //BA.debugLineNum = 101;BA.debugLine="End Sub";
return "";
}
public static String  _url_label_click() throws Exception{
 //BA.debugLineNum = 122;BA.debugLine="Sub url_label_Click";
 //BA.debugLineNum = 123;BA.debugLine="Msgbox(url_label.Text,\"آدرس صفحه پرداخت\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence(mostCurrent._url_label.getText()),BA.ObjectToCharSequence("آدرس صفحه پرداخت"),mostCurrent.activityBA);
 //BA.debugLineNum = 124;BA.debugLine="End Sub";
return "";
}
public static boolean  _webclient_overrideurl(String _url) throws Exception{
 //BA.debugLineNum = 77;BA.debugLine="Sub WebClient_OverrideUrl (Url As String) As Boole";
 //BA.debugLineNum = 78;BA.debugLine="url_label.Text = Url";
mostCurrent._url_label.setText(BA.ObjectToCharSequence(_url));
 //BA.debugLineNum = 79;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
if (_url.toLowerCase().contains("exit_page")) { 
 //BA.debugLineNum = 80;BA.debugLine="Activity_Pause(True)";
_activity_pause(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 82;BA.debugLine="web_progressbar.Progress=50";
mostCurrent._web_progressbar.setProgress((int) (50));
 //BA.debugLineNum = 83;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return false;
}
public static String  _webclient_pagefinished(String _url) throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub WebClient_PageFinished (Url As String)";
 //BA.debugLineNum = 69;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 70;BA.debugLine="sett.Visible = False";
mostCurrent._sett.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 71;BA.debugLine="sett.Visible=True";
mostCurrent._sett.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 72;BA.debugLine="page_title.Text = sett.GetTitle";
mostCurrent._page_title.setText(BA.ObjectToCharSequence(mostCurrent._sett.GetTitle()));
 //BA.debugLineNum = 73;BA.debugLine="web_progressbar.Progress=100";
mostCurrent._web_progressbar.setProgress((int) (100));
 //BA.debugLineNum = 74;BA.debugLine="web_progressbar.Visible=False";
mostCurrent._web_progressbar.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _webclient_updatevisitedhistory(String _url,boolean _isreload) throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub WebClient_UpdateVisitedHistory(Url As String,";
 //BA.debugLineNum = 88;BA.debugLine="url_label.Text = Url";
mostCurrent._url_label.setText(BA.ObjectToCharSequence(_url));
 //BA.debugLineNum = 90;BA.debugLine="If Url.ToLowerCase.Contains(\"exit_page\") Then";
if (_url.toLowerCase().contains("exit_page")) { 
 //BA.debugLineNum = 91;BA.debugLine="Activity_Pause(True)";
_activity_pause(anywheresoftware.b4a.keywords.Common.True);
 };
 //BA.debugLineNum = 93;BA.debugLine="End Sub";
return "";
}
}
