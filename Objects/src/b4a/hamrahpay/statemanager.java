package b4a.hamrahpay;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class statemanager {
private static statemanager mostCurrent = new statemanager();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.collections.Map _states = null;
public static int _listposition = 0;
public static String _statesfilename = "";
public static String _settingsfilename = "";
public static anywheresoftware.b4a.objects.collections.Map _settings = null;
public anywheresoftware.b4a.samples.httputils2.httputils2service _httputils2service = null;
public b4a.hamrahpay.main _main = null;
public b4a.hamrahpay.hamrahpay _hamrahpay = null;
public b4a.hamrahpay.payment_activity _payment_activity = null;
public static String  _getsetting2(anywheresoftware.b4a.BA _ba,String _key,String _defaultvalue) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getsetting2"))
	return (String) Debug.delegate(null, "getsetting2", new Object[] {_ba,_key,_defaultvalue});
String _v = "";
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Public Sub GetSetting2(Key As String, DefaultValue";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="Return DefaultValue";
if (true) return _defaultvalue;
 };
 };
RDebugUtils.currentLine=1966089;
 //BA.debugLineNum = 1966089;BA.debugLine="Dim v As String";
_v = "";
RDebugUtils.currentLine=1966090;
 //BA.debugLineNum = 1966090;BA.debugLine="v = settings.GetDefault(Key.ToLowerCase, DefaultV";
_v = BA.ObjectToString(_settings.GetDefault((Object)(_key.toLowerCase()),(Object)(_defaultvalue)));
RDebugUtils.currentLine=1966091;
 //BA.debugLineNum = 1966091;BA.debugLine="Return v";
if (true) return _v;
RDebugUtils.currentLine=1966092;
 //BA.debugLineNum = 1966092;BA.debugLine="End Sub";
return "";
}
public static String  _setsetting(anywheresoftware.b4a.BA _ba,String _key,String _value) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("setsetting"))
	return (String) Debug.delegate(null, "setsetting", new Object[] {_ba,_key,_value});
RDebugUtils.currentLine=2097152;
 //BA.debugLineNum = 2097152;BA.debugLine="Public Sub SetSetting(Key As String, Value As Stri";
RDebugUtils.currentLine=2097153;
 //BA.debugLineNum = 2097153;BA.debugLine="If settings.IsInitialized = False Then";
if (_settings.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2097155;
 //BA.debugLineNum = 2097155;BA.debugLine="If File.Exists(File.DirInternal, settingsFileNam";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename)) { 
RDebugUtils.currentLine=2097156;
 //BA.debugLineNum = 2097156;BA.debugLine="settings = File.ReadMap(File.DirInternal, setti";
_settings = anywheresoftware.b4a.keywords.Common.File.ReadMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename);
 }else {
RDebugUtils.currentLine=2097158;
 //BA.debugLineNum = 2097158;BA.debugLine="settings.Initialize";
_settings.Initialize();
 };
 };
RDebugUtils.currentLine=2097161;
 //BA.debugLineNum = 2097161;BA.debugLine="settings.Put(Key.ToLowerCase, Value)";
_settings.Put((Object)(_key.toLowerCase()),(Object)(_value));
RDebugUtils.currentLine=2097162;
 //BA.debugLineNum = 2097162;BA.debugLine="End Sub";
return "";
}
public static String  _savesettings(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savesettings"))
	return (String) Debug.delegate(null, "savesettings", new Object[] {_ba});
RDebugUtils.currentLine=2162688;
 //BA.debugLineNum = 2162688;BA.debugLine="Public Sub SaveSettings";
RDebugUtils.currentLine=2162689;
 //BA.debugLineNum = 2162689;BA.debugLine="If settings.IsInitialized Then";
if (_settings.IsInitialized()) { 
RDebugUtils.currentLine=2162690;
 //BA.debugLineNum = 2162690;BA.debugLine="File.WriteMap(File.DirInternal, settingsFileName";
anywheresoftware.b4a.keywords.Common.File.WriteMap(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_settingsfilename,_settings);
 };
RDebugUtils.currentLine=2162692;
 //BA.debugLineNum = 2162692;BA.debugLine="End Sub";
return "";
}
public static Object[]  _getnextitem(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getnextitem"))
	return (Object[]) Debug.delegate(null, "getnextitem", new Object[] {_ba,_list1});
RDebugUtils.currentLine=2555904;
 //BA.debugLineNum = 2555904;BA.debugLine="Private Sub getNextItem(list1 As List) As Object()";
RDebugUtils.currentLine=2555905;
 //BA.debugLineNum = 2555905;BA.debugLine="listPosition = listPosition + 1";
_listposition = (int) (_listposition+1);
RDebugUtils.currentLine=2555906;
 //BA.debugLineNum = 2555906;BA.debugLine="Return list1.Get(listPosition)";
if (true) return (Object[])(_list1.Get(_listposition));
RDebugUtils.currentLine=2555907;
 //BA.debugLineNum = 2555907;BA.debugLine="End Sub";
return null;
}
public static String  _getsetting(anywheresoftware.b4a.BA _ba,String _key) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("getsetting"))
	return (String) Debug.delegate(null, "getsetting", new Object[] {_ba,_key});
RDebugUtils.currentLine=2031616;
 //BA.debugLineNum = 2031616;BA.debugLine="Public Sub GetSetting(Key As String) As String";
RDebugUtils.currentLine=2031617;
 //BA.debugLineNum = 2031617;BA.debugLine="Return GetSetting2(Key, \"\")";
if (true) return _getsetting2(_ba,_key,"");
RDebugUtils.currentLine=2031618;
 //BA.debugLineNum = 2031618;BA.debugLine="End Sub";
return "";
}
public static String  _innerrestorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("innerrestorestate"))
	return (String) Debug.delegate(null, "innerrestorestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=2490368;
 //BA.debugLineNum = 2490368;BA.debugLine="Private Sub innerRestoreState(v As View, list1 As";
RDebugUtils.currentLine=2490369;
 //BA.debugLineNum = 2490369;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2490370;
 //BA.debugLineNum = 2490370;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=2490371;
 //BA.debugLineNum = 2490371;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=2490372;
 //BA.debugLineNum = 2490372;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=2490373;
 //BA.debugLineNum = 2490373;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490374;
 //BA.debugLineNum = 2490374;BA.debugLine="edit.Text = data(0)";
_edit.setText(_data[(int) (0)]);
RDebugUtils.currentLine=2490375;
 //BA.debugLineNum = 2490375;BA.debugLine="edit.SelectionStart = data(1)";
_edit.setSelectionStart((int)(BA.ObjectToNumber(_data[(int) (1)])));
 }else 
{RDebugUtils.currentLine=2490376;
 //BA.debugLineNum = 2490376;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=2490377;
 //BA.debugLineNum = 2490377;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=2490378;
 //BA.debugLineNum = 2490378;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=2490379;
 //BA.debugLineNum = 2490379;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490380;
 //BA.debugLineNum = 2490380;BA.debugLine="spinner1.SelectedIndex = data(0)";
_spinner1.setSelectedIndex((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=2490381;
 //BA.debugLineNum = 2490381;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=2490382;
 //BA.debugLineNum = 2490382;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=2490383;
 //BA.debugLineNum = 2490383;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=2490384;
 //BA.debugLineNum = 2490384;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490385;
 //BA.debugLineNum = 2490385;BA.debugLine="check.Checked = data(0)";
_check.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=2490386;
 //BA.debugLineNum = 2490386;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=2490387;
 //BA.debugLineNum = 2490387;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=2490388;
 //BA.debugLineNum = 2490388;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=2490389;
 //BA.debugLineNum = 2490389;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490390;
 //BA.debugLineNum = 2490390;BA.debugLine="radio.Checked = data(0)";
_radio.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=2490391;
 //BA.debugLineNum = 2490391;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=2490392;
 //BA.debugLineNum = 2490392;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=2490393;
 //BA.debugLineNum = 2490393;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=2490394;
 //BA.debugLineNum = 2490394;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490395;
 //BA.debugLineNum = 2490395;BA.debugLine="toggle.Checked = data(0)";
_toggle.setChecked(BA.ObjectToBoolean(_data[(int) (0)]));
 }else 
{RDebugUtils.currentLine=2490396;
 //BA.debugLineNum = 2490396;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=2490397;
 //BA.debugLineNum = 2490397;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=2490398;
 //BA.debugLineNum = 2490398;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=2490399;
 //BA.debugLineNum = 2490399;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490400;
 //BA.debugLineNum = 2490400;BA.debugLine="seek.Value = data(0)";
_seek.setValue((int)(BA.ObjectToNumber(_data[(int) (0)])));
 }else 
{RDebugUtils.currentLine=2490401;
 //BA.debugLineNum = 2490401;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=2490402;
 //BA.debugLineNum = 2490402;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=2490403;
 //BA.debugLineNum = 2490403;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=2490404;
 //BA.debugLineNum = 2490404;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490405;
 //BA.debugLineNum = 2490405;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step37 = 1;
final int limit37 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step37 > 0 && _i <= limit37) || (step37 < 0 && _i >= limit37); _i = ((int)(0 + _i + step37)) ) {
RDebugUtils.currentLine=2490406;
 //BA.debugLineNum = 2490406;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=2490408;
 //BA.debugLineNum = 2490408;BA.debugLine="th.CurrentTab = data(0)";
_th.setCurrentTab((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=2490409;
 //BA.debugLineNum = 2490409;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=2490410;
 //BA.debugLineNum = 2490410;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=2490411;
 //BA.debugLineNum = 2490411;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2490412;
 //BA.debugLineNum = 2490412;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=2490413;
 //BA.debugLineNum = 2490413;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step45 = 1;
final int limit45 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step45 > 0 && _i <= limit45) || (step45 < 0 && _i >= limit45); _i = ((int)(0 + _i + step45)) ) {
RDebugUtils.currentLine=2490414;
 //BA.debugLineNum = 2490414;BA.debugLine="innerRestoreState(tabParentPanel.GetView(i), li";
_innerrestorestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=2490416;
 //BA.debugLineNum = 2490416;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=2490417;
 //BA.debugLineNum = 2490417;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=2490418;
 //BA.debugLineNum = 2490418;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=2490419;
 //BA.debugLineNum = 2490419;BA.debugLine="data = getNextItem(list1)";
_data = _getnextitem(_ba,_list1);
RDebugUtils.currentLine=2490420;
 //BA.debugLineNum = 2490420;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=2490421;
 //BA.debugLineNum = 2490421;BA.debugLine="DoEvents";
anywheresoftware.b4a.keywords.Common.DoEvents();
RDebugUtils.currentLine=2490422;
 //BA.debugLineNum = 2490422;BA.debugLine="sv.ScrollPosition = data(0)";
_sv.setScrollPosition((int)(BA.ObjectToNumber(_data[(int) (0)])));
RDebugUtils.currentLine=2490423;
 //BA.debugLineNum = 2490423;BA.debugLine="innerRestoreState(sv.Panel, list1)";
_innerrestorestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=2490424;
 //BA.debugLineNum = 2490424;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=2490425;
 //BA.debugLineNum = 2490425;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2490426;
 //BA.debugLineNum = 2490426;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=2490427;
 //BA.debugLineNum = 2490427;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step59 = 1;
final int limit59 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step59 > 0 && _i <= limit59) || (step59 < 0 && _i >= limit59); _i = ((int)(0 + _i + step59)) ) {
RDebugUtils.currentLine=2490428;
 //BA.debugLineNum = 2490428;BA.debugLine="innerRestoreState(panel1.GetView(i), list1)";
_innerrestorestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}};
RDebugUtils.currentLine=2490431;
 //BA.debugLineNum = 2490431;BA.debugLine="End Sub";
return "";
}
public static String  _innersavestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ConcreteViewWrapper _v,anywheresoftware.b4a.objects.collections.List _list1) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("innersavestate"))
	return (String) Debug.delegate(null, "innersavestate", new Object[] {_ba,_v,_list1});
Object[] _data = null;
anywheresoftware.b4a.objects.EditTextWrapper _edit = null;
anywheresoftware.b4a.objects.SpinnerWrapper _spinner1 = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper _check = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper _radio = null;
anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper _toggle = null;
anywheresoftware.b4a.objects.SeekBarWrapper _seek = null;
anywheresoftware.b4a.objects.TabHostWrapper _th = null;
int _i = 0;
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
anywheresoftware.b4a.objects.PanelWrapper _tabparentpanel = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _sv = null;
anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
RDebugUtils.currentLine=2424832;
 //BA.debugLineNum = 2424832;BA.debugLine="Private Sub innerSaveState(v As View, list1 As Lis";
RDebugUtils.currentLine=2424833;
 //BA.debugLineNum = 2424833;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2424834;
 //BA.debugLineNum = 2424834;BA.debugLine="If v Is EditText Then";
if (_v.getObjectOrNull() instanceof android.widget.EditText) { 
RDebugUtils.currentLine=2424835;
 //BA.debugLineNum = 2424835;BA.debugLine="Dim edit As EditText";
_edit = new anywheresoftware.b4a.objects.EditTextWrapper();
RDebugUtils.currentLine=2424836;
 //BA.debugLineNum = 2424836;BA.debugLine="edit = v";
_edit.setObject((android.widget.EditText)(_v.getObject()));
RDebugUtils.currentLine=2424837;
 //BA.debugLineNum = 2424837;BA.debugLine="data = Array As Object(edit.Text, edit.Selection";
_data = new Object[]{(Object)(_edit.getText()),(Object)(_edit.getSelectionStart())};
 }else 
{RDebugUtils.currentLine=2424838;
 //BA.debugLineNum = 2424838;BA.debugLine="Else If v Is Spinner Then";
if (_v.getObjectOrNull() instanceof anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner) { 
RDebugUtils.currentLine=2424839;
 //BA.debugLineNum = 2424839;BA.debugLine="Dim spinner1 As Spinner";
_spinner1 = new anywheresoftware.b4a.objects.SpinnerWrapper();
RDebugUtils.currentLine=2424840;
 //BA.debugLineNum = 2424840;BA.debugLine="spinner1 = v";
_spinner1.setObject((anywheresoftware.b4a.objects.SpinnerWrapper.B4ASpinner)(_v.getObject()));
RDebugUtils.currentLine=2424841;
 //BA.debugLineNum = 2424841;BA.debugLine="data = Array As Object(spinner1.SelectedIndex)";
_data = new Object[]{(Object)(_spinner1.getSelectedIndex())};
 }else 
{RDebugUtils.currentLine=2424842;
 //BA.debugLineNum = 2424842;BA.debugLine="Else If v Is CheckBox Then";
if (_v.getObjectOrNull() instanceof android.widget.CheckBox) { 
RDebugUtils.currentLine=2424843;
 //BA.debugLineNum = 2424843;BA.debugLine="Dim check As CheckBox";
_check = new anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper();
RDebugUtils.currentLine=2424844;
 //BA.debugLineNum = 2424844;BA.debugLine="check = v";
_check.setObject((android.widget.CheckBox)(_v.getObject()));
RDebugUtils.currentLine=2424845;
 //BA.debugLineNum = 2424845;BA.debugLine="data = Array As Object(check.Checked)";
_data = new Object[]{(Object)(_check.getChecked())};
 }else 
{RDebugUtils.currentLine=2424846;
 //BA.debugLineNum = 2424846;BA.debugLine="Else If v Is RadioButton Then";
if (_v.getObjectOrNull() instanceof android.widget.RadioButton) { 
RDebugUtils.currentLine=2424847;
 //BA.debugLineNum = 2424847;BA.debugLine="Dim radio As RadioButton";
_radio = new anywheresoftware.b4a.objects.CompoundButtonWrapper.RadioButtonWrapper();
RDebugUtils.currentLine=2424848;
 //BA.debugLineNum = 2424848;BA.debugLine="radio = v";
_radio.setObject((android.widget.RadioButton)(_v.getObject()));
RDebugUtils.currentLine=2424849;
 //BA.debugLineNum = 2424849;BA.debugLine="data = Array As Object(radio.Checked)";
_data = new Object[]{(Object)(_radio.getChecked())};
 }else 
{RDebugUtils.currentLine=2424850;
 //BA.debugLineNum = 2424850;BA.debugLine="Else If v Is ToggleButton Then";
if (_v.getObjectOrNull() instanceof android.widget.ToggleButton) { 
RDebugUtils.currentLine=2424851;
 //BA.debugLineNum = 2424851;BA.debugLine="Dim toggle As ToggleButton";
_toggle = new anywheresoftware.b4a.objects.CompoundButtonWrapper.ToggleButtonWrapper();
RDebugUtils.currentLine=2424852;
 //BA.debugLineNum = 2424852;BA.debugLine="toggle = v";
_toggle.setObject((android.widget.ToggleButton)(_v.getObject()));
RDebugUtils.currentLine=2424853;
 //BA.debugLineNum = 2424853;BA.debugLine="data = Array As Object(toggle.Checked)";
_data = new Object[]{(Object)(_toggle.getChecked())};
 }else 
{RDebugUtils.currentLine=2424854;
 //BA.debugLineNum = 2424854;BA.debugLine="Else If v Is SeekBar Then";
if (_v.getObjectOrNull() instanceof android.widget.SeekBar) { 
RDebugUtils.currentLine=2424855;
 //BA.debugLineNum = 2424855;BA.debugLine="Dim seek As SeekBar";
_seek = new anywheresoftware.b4a.objects.SeekBarWrapper();
RDebugUtils.currentLine=2424856;
 //BA.debugLineNum = 2424856;BA.debugLine="seek = v";
_seek.setObject((android.widget.SeekBar)(_v.getObject()));
RDebugUtils.currentLine=2424857;
 //BA.debugLineNum = 2424857;BA.debugLine="data = Array As Object(seek.Value)";
_data = new Object[]{(Object)(_seek.getValue())};
 }else 
{RDebugUtils.currentLine=2424858;
 //BA.debugLineNum = 2424858;BA.debugLine="Else If v Is TabHost Then";
if (_v.getObjectOrNull() instanceof android.widget.TabHost) { 
RDebugUtils.currentLine=2424859;
 //BA.debugLineNum = 2424859;BA.debugLine="Dim th As TabHost";
_th = new anywheresoftware.b4a.objects.TabHostWrapper();
RDebugUtils.currentLine=2424860;
 //BA.debugLineNum = 2424860;BA.debugLine="th = v";
_th.setObject((android.widget.TabHost)(_v.getObject()));
RDebugUtils.currentLine=2424861;
 //BA.debugLineNum = 2424861;BA.debugLine="data = Array As Object(th.CurrentTab)";
_data = new Object[]{(Object)(_th.getCurrentTab())};
RDebugUtils.currentLine=2424862;
 //BA.debugLineNum = 2424862;BA.debugLine="For i = 0 To th.TabCount - 1";
{
final int step30 = 1;
final int limit30 = (int) (_th.getTabCount()-1);
for (_i = (int) (0) ; (step30 > 0 && _i <= limit30) || (step30 < 0 && _i >= limit30); _i = ((int)(0 + _i + step30)) ) {
RDebugUtils.currentLine=2424863;
 //BA.debugLineNum = 2424863;BA.debugLine="th.CurrentTab = i";
_th.setCurrentTab(_i);
 }
};
RDebugUtils.currentLine=2424865;
 //BA.debugLineNum = 2424865;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=2424866;
 //BA.debugLineNum = 2424866;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2424867;
 //BA.debugLineNum = 2424867;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
RDebugUtils.currentLine=2424868;
 //BA.debugLineNum = 2424868;BA.debugLine="r.Target = th";
_r.Target = (Object)(_th.getObject());
RDebugUtils.currentLine=2424869;
 //BA.debugLineNum = 2424869;BA.debugLine="Dim tabParentPanel As Panel";
_tabparentpanel = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2424870;
 //BA.debugLineNum = 2424870;BA.debugLine="tabParentPanel = r.RunMethod(\"getTabContentView\"";
_tabparentpanel.setObject((android.view.ViewGroup)(_r.RunMethod("getTabContentView")));
RDebugUtils.currentLine=2424871;
 //BA.debugLineNum = 2424871;BA.debugLine="For i = 0 To tabParentPanel.NumberOfViews - 1";
{
final int step39 = 1;
final int limit39 = (int) (_tabparentpanel.getNumberOfViews()-1);
for (_i = (int) (0) ; (step39 > 0 && _i <= limit39) || (step39 < 0 && _i >= limit39); _i = ((int)(0 + _i + step39)) ) {
RDebugUtils.currentLine=2424872;
 //BA.debugLineNum = 2424872;BA.debugLine="innerSaveState(tabParentPanel.GetView(i), list1";
_innersavestate(_ba,_tabparentpanel.GetView(_i),_list1);
 }
};
 }else 
{RDebugUtils.currentLine=2424874;
 //BA.debugLineNum = 2424874;BA.debugLine="Else If v Is ScrollView Then";
if (_v.getObjectOrNull() instanceof android.widget.ScrollView) { 
RDebugUtils.currentLine=2424875;
 //BA.debugLineNum = 2424875;BA.debugLine="Dim sv As ScrollView";
_sv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
RDebugUtils.currentLine=2424876;
 //BA.debugLineNum = 2424876;BA.debugLine="sv = v";
_sv.setObject((android.widget.ScrollView)(_v.getObject()));
RDebugUtils.currentLine=2424877;
 //BA.debugLineNum = 2424877;BA.debugLine="data = Array As Object(sv.ScrollPosition)";
_data = new Object[]{(Object)(_sv.getScrollPosition())};
RDebugUtils.currentLine=2424878;
 //BA.debugLineNum = 2424878;BA.debugLine="list1.Add(data)";
_list1.Add((Object)(_data));
RDebugUtils.currentLine=2424879;
 //BA.debugLineNum = 2424879;BA.debugLine="Dim data() As Object";
_data = new Object[(int) (0)];
{
int d0 = _data.length;
for (int i0 = 0;i0 < d0;i0++) {
_data[i0] = new Object();
}
}
;
RDebugUtils.currentLine=2424880;
 //BA.debugLineNum = 2424880;BA.debugLine="innerSaveState(sv.Panel, list1)";
_innersavestate(_ba,(anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(_sv.getPanel().getObject())),_list1);
 }else 
{RDebugUtils.currentLine=2424881;
 //BA.debugLineNum = 2424881;BA.debugLine="Else If v Is Panel Then";
if (_v.getObjectOrNull() instanceof android.view.ViewGroup) { 
RDebugUtils.currentLine=2424882;
 //BA.debugLineNum = 2424882;BA.debugLine="Dim panel1 As Panel";
_panel1 = new anywheresoftware.b4a.objects.PanelWrapper();
RDebugUtils.currentLine=2424883;
 //BA.debugLineNum = 2424883;BA.debugLine="panel1 = v";
_panel1.setObject((android.view.ViewGroup)(_v.getObject()));
RDebugUtils.currentLine=2424884;
 //BA.debugLineNum = 2424884;BA.debugLine="For i = 0 To panel1.NumberOfViews - 1";
{
final int step52 = 1;
final int limit52 = (int) (_panel1.getNumberOfViews()-1);
for (_i = (int) (0) ; (step52 > 0 && _i <= limit52) || (step52 < 0 && _i >= limit52); _i = ((int)(0 + _i + step52)) ) {
RDebugUtils.currentLine=2424885;
 //BA.debugLineNum = 2424885;BA.debugLine="innerSaveState(panel1.GetView(i), list1)";
_innersavestate(_ba,_panel1.GetView(_i),_list1);
 }
};
 }}}}}}}}};
RDebugUtils.currentLine=2424888;
 //BA.debugLineNum = 2424888;BA.debugLine="If data.Length > 0 Then list1.Add(data)";
if (_data.length>0) { 
_list1.Add((Object)(_data));};
RDebugUtils.currentLine=2424889;
 //BA.debugLineNum = 2424889;BA.debugLine="End Sub";
return "";
}
public static String  _loadstatefile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("loadstatefile"))
	return (String) Debug.delegate(null, "loadstatefile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=2686976;
 //BA.debugLineNum = 2686976;BA.debugLine="Private Sub loadStateFile";
RDebugUtils.currentLine=2686978;
 //BA.debugLineNum = 2686978;BA.debugLine="If states.IsInitialized Then Return";
if (_states.IsInitialized()) { 
if (true) return "";};
RDebugUtils.currentLine=2686979;
 //BA.debugLineNum = 2686979;BA.debugLine="If File.Exists(File.DirInternal, statesFileName)";
if (anywheresoftware.b4a.keywords.Common.File.Exists(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename)) { 
RDebugUtils.currentLine=2686980;
 //BA.debugLineNum = 2686980;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=2686981;
 //BA.debugLineNum = 2686981;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2686982;
 //BA.debugLineNum = 2686982;BA.debugLine="states = raf.ReadObject(0)";
_states.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_raf.ReadObject((long) (0))));
RDebugUtils.currentLine=2686983;
 //BA.debugLineNum = 2686983;BA.debugLine="raf.Close";
_raf.Close();
 };
RDebugUtils.currentLine=2686985;
 //BA.debugLineNum = 2686985;BA.debugLine="End Sub";
return "";
}
public static String  _resetstate(anywheresoftware.b4a.BA _ba,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("resetstate"))
	return (String) Debug.delegate(null, "resetstate", new Object[] {_ba,_activityname});
RDebugUtils.currentLine=2228224;
 //BA.debugLineNum = 2228224;BA.debugLine="Public Sub ResetState(ActivityName As String)";
RDebugUtils.currentLine=2228225;
 //BA.debugLineNum = 2228225;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=2228226;
 //BA.debugLineNum = 2228226;BA.debugLine="If states.IsInitialized Then";
if (_states.IsInitialized()) { 
RDebugUtils.currentLine=2228227;
 //BA.debugLineNum = 2228227;BA.debugLine="states.Remove(ActivityName.ToLowerCase)";
_states.Remove((Object)(_activityname.toLowerCase()));
RDebugUtils.currentLine=2228228;
 //BA.debugLineNum = 2228228;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
 };
RDebugUtils.currentLine=2228230;
 //BA.debugLineNum = 2228230;BA.debugLine="End Sub";
return "";
}
public static String  _writestatetofile(anywheresoftware.b4a.BA _ba) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("writestatetofile"))
	return (String) Debug.delegate(null, "writestatetofile", new Object[] {_ba});
anywheresoftware.b4a.randomaccessfile.RandomAccessFile _raf = null;
RDebugUtils.currentLine=2359296;
 //BA.debugLineNum = 2359296;BA.debugLine="Private Sub writeStateToFile";
RDebugUtils.currentLine=2359297;
 //BA.debugLineNum = 2359297;BA.debugLine="Dim raf As RandomAccessFile";
_raf = new anywheresoftware.b4a.randomaccessfile.RandomAccessFile();
RDebugUtils.currentLine=2359298;
 //BA.debugLineNum = 2359298;BA.debugLine="raf.Initialize(File.DirInternal, statesFileName,";
_raf.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),_statesfilename,anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2359299;
 //BA.debugLineNum = 2359299;BA.debugLine="raf.WriteObject(states, True, raf.CurrentPosition";
_raf.WriteObject((Object)(_states.getObject()),anywheresoftware.b4a.keywords.Common.True,_raf.CurrentPosition);
RDebugUtils.currentLine=2359300;
 //BA.debugLineNum = 2359300;BA.debugLine="raf.Close";
_raf.Close();
RDebugUtils.currentLine=2359301;
 //BA.debugLineNum = 2359301;BA.debugLine="End Sub";
return "";
}
public static boolean  _restorestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname,int _validperiodinminutes) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("restorestate"))
	return (Boolean) Debug.delegate(null, "restorestate", new Object[] {_ba,_activity,_activityname,_validperiodinminutes});
anywheresoftware.b4a.objects.collections.List _list1 = null;
long _time = 0L;
int _i = 0;
RDebugUtils.currentLine=2621440;
 //BA.debugLineNum = 2621440;BA.debugLine="Public Sub RestoreState(Activity As Activity, Acti";
RDebugUtils.currentLine=2621441;
 //BA.debugLineNum = 2621441;BA.debugLine="Try";
try {RDebugUtils.currentLine=2621442;
 //BA.debugLineNum = 2621442;BA.debugLine="loadStateFile";
_loadstatefile(_ba);
RDebugUtils.currentLine=2621443;
 //BA.debugLineNum = 2621443;BA.debugLine="If states.IsInitialized = False Then";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=2621444;
 //BA.debugLineNum = 2621444;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2621446;
 //BA.debugLineNum = 2621446;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2621447;
 //BA.debugLineNum = 2621447;BA.debugLine="list1 = states.Get(ActivityName.ToLowerCase)";
_list1.setObject((java.util.List)(_states.Get((Object)(_activityname.toLowerCase()))));
RDebugUtils.currentLine=2621448;
 //BA.debugLineNum = 2621448;BA.debugLine="If list1.IsInitialized = False Then Return False";
if (_list1.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
if (true) return anywheresoftware.b4a.keywords.Common.False;};
RDebugUtils.currentLine=2621449;
 //BA.debugLineNum = 2621449;BA.debugLine="Dim time As Long";
_time = 0L;
RDebugUtils.currentLine=2621450;
 //BA.debugLineNum = 2621450;BA.debugLine="time = list1.Get(0)";
_time = BA.ObjectToLongNumber(_list1.Get((int) (0)));
RDebugUtils.currentLine=2621451;
 //BA.debugLineNum = 2621451;BA.debugLine="If ValidPeriodInMinutes > 0 And time + ValidPeri";
if (_validperiodinminutes>0 && _time+_validperiodinminutes*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerMinute<anywheresoftware.b4a.keywords.Common.DateTime.getNow()) { 
RDebugUtils.currentLine=2621452;
 //BA.debugLineNum = 2621452;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2621454;
 //BA.debugLineNum = 2621454;BA.debugLine="listPosition = 0";
_listposition = (int) (0);
RDebugUtils.currentLine=2621455;
 //BA.debugLineNum = 2621455;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step15 = 1;
final int limit15 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step15 > 0 && _i <= limit15) || (step15 < 0 && _i >= limit15); _i = ((int)(0 + _i + step15)) ) {
RDebugUtils.currentLine=2621456;
 //BA.debugLineNum = 2621456;BA.debugLine="innerRestoreState(Activity.GetView(i), list1)";
_innerrestorestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=2621458;
 //BA.debugLineNum = 2621458;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 } 
       catch (Exception e208) {
			(_ba.processBA == null ? _ba : _ba.processBA).setLastException(e208);RDebugUtils.currentLine=2621460;
 //BA.debugLineNum = 2621460;BA.debugLine="Log(\"Error loading state.\")";
anywheresoftware.b4a.keywords.Common.Log("Error loading state.");
RDebugUtils.currentLine=2621461;
 //BA.debugLineNum = 2621461;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(_ba).getMessage());
RDebugUtils.currentLine=2621462;
 //BA.debugLineNum = 2621462;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 };
RDebugUtils.currentLine=2621464;
 //BA.debugLineNum = 2621464;BA.debugLine="End Sub";
return false;
}
public static String  _savestate(anywheresoftware.b4a.BA _ba,anywheresoftware.b4a.objects.ActivityWrapper _activity,String _activityname) throws Exception{
RDebugUtils.currentModule="statemanager";
if (Debug.shouldDelegate("savestate"))
	return (String) Debug.delegate(null, "savestate", new Object[] {_ba,_activity,_activityname});
anywheresoftware.b4a.objects.collections.List _list1 = null;
int _i = 0;
RDebugUtils.currentLine=2293760;
 //BA.debugLineNum = 2293760;BA.debugLine="Public Sub SaveState(Activity As Activity, Activit";
RDebugUtils.currentLine=2293761;
 //BA.debugLineNum = 2293761;BA.debugLine="If states.IsInitialized = False Then states.Initi";
if (_states.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_states.Initialize();};
RDebugUtils.currentLine=2293762;
 //BA.debugLineNum = 2293762;BA.debugLine="Dim list1 As List";
_list1 = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=2293763;
 //BA.debugLineNum = 2293763;BA.debugLine="list1.Initialize";
_list1.Initialize();
RDebugUtils.currentLine=2293764;
 //BA.debugLineNum = 2293764;BA.debugLine="list1.Add(DateTime.Now)";
_list1.Add((Object)(anywheresoftware.b4a.keywords.Common.DateTime.getNow()));
RDebugUtils.currentLine=2293765;
 //BA.debugLineNum = 2293765;BA.debugLine="For i = 0 To Activity.NumberOfViews - 1";
{
final int step5 = 1;
final int limit5 = (int) (_activity.getNumberOfViews()-1);
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
RDebugUtils.currentLine=2293766;
 //BA.debugLineNum = 2293766;BA.debugLine="innerSaveState(Activity.GetView(i), list1)";
_innersavestate(_ba,_activity.GetView(_i),_list1);
 }
};
RDebugUtils.currentLine=2293768;
 //BA.debugLineNum = 2293768;BA.debugLine="states.Put(ActivityName.ToLowerCase, list1)";
_states.Put((Object)(_activityname.toLowerCase()),(Object)(_list1.getObject()));
RDebugUtils.currentLine=2293769;
 //BA.debugLineNum = 2293769;BA.debugLine="writeStateToFile";
_writestatetofile(_ba);
RDebugUtils.currentLine=2293770;
 //BA.debugLineNum = 2293770;BA.debugLine="End Sub";
return "";
}
}