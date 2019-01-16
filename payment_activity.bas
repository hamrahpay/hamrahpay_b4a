B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=5.5
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region
' www.Hamrahpay
' HamrahPay Official library for basic4android developers
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private browser As WebView

	Dim WebChromeClient As DefaultWebChromeClient
	Dim WebClient As DefaultWebViewClient
	Dim sett As WebViewExtras
	
	Dim LastLoadedUrl As String
	Private url_label As Label
	Private protocol_icon As Label
	Private page_title As Label
	Private web_progressbar As ProgressBar
End Sub

Sub Activity_Create(FirstTime As Boolean)
End Sub

Sub Activity_Resume
	
	Activity.LoadLayout("pay_activity")
	
	url_label.Color=Colors.White
	url_label.TextColor=Colors.Black
	protocol_icon.Color =Colors.White
	
	browser.JavaScriptEnabled = True
	browser.ZoomEnabled=False

	WebChromeClient.Initialize("WebChromeClient")
	WebClient.Initialize("WebClient")
	
	
	sett.Initialize(browser)
	sett.GetSettings.SetDOMStorageEnabled(True)
	
	sett.SetWebViewClient(WebClient)
	sett.SetWebChromeClient(WebChromeClient)
	
	sett.LoadUrl(hamrahpay.pay_url)

	
	ProgressDialogShow2("لطفا صبور باشید...",False)

End Sub

' On Destroy
Sub Activity_Pause (UserClosed As Boolean)
	Dim pay_status As Boolean
	If UserClosed=True Then
		hamrahpay.verify_payment(hamrahpay.pay_code,hamrahpay.product_sku)	
	End If
End Sub

Sub WebClient_PageFinished (Url As String)
	ProgressDialogHide
	sett.Visible = False
	sett.Visible=True
	page_title.Text = sett.GetTitle
	web_progressbar.Progress=100
	web_progressbar.Visible=False
End Sub

Sub WebClient_OverrideUrl (Url As String) As Boolean
	url_label.Text = Url
	If Url.ToLowerCase.Contains("exit_page") Then
		Activity_Pause(True)
	End If
	web_progressbar.Progress=50
	Return False
End Sub


Sub WebClient_UpdateVisitedHistory(Url As String, IsReload As Boolean)
	url_label.Text = Url

	If Url.ToLowerCase.Contains("exit_page") Then
		Activity_Pause(True)
	End If
End Sub

'Sub WebClient_ReceivedSslError (SslErrorHandler1 As SslErrorHandler, SslError1 As SslError)
'	SslErrorHandler1.Proceed
'End Sub
Sub sett_ProgressChanged(NewProgress As Int)
	'   NewProgress is Current page loading progress, represented by an integer between 0 and 100.
	Log("WebView1 loading progress: "&NewProgress&"%")
End Sub

Sub JobDone (Job As HttpJob)
	hamrahpay.JobDone(Job)
End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean

	If KeyCode = KeyCodes.KEYCODE_BACK Then
		If url_label.Text.Contains("shaparak.ir") Then
		If Msgbox2("شما در صفحه بانک هستید. آیا تمایل به لغو خرید و خروج این صفحه دارید؟", "", "بله", "", "خیر", Null) = DialogResponse.POSITIVE Then
			ToastMessageShow("خروج از صفحه ی پراداخت انجام گردید.",True)
			ExitApplication 'App is exiting
		Else
			Return True
		End If
		End If
	End If

End Sub

Sub url_label_Click
	Msgbox(url_label.Text,"آدرس صفحه پرداخت")
End Sub