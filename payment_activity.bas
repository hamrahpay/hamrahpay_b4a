Type=Activity
Version=5.5
ModulesStructureVersion=1
B4A=true
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
	Private addressbar As Label
	Dim WebChromeClient As DefaultWebChromeClient
	Dim WebClient As DefaultWebViewClient
	Dim sett As WebViewExtras
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
End Sub

Sub Activity_Resume
	
	addressbar.Initialize("addressbar")
	
	
	browser.Initialize("browser")
	browser.JavaScriptEnabled = True
	
	WebChromeClient.Initialize("WebChromeClient")
	WebClient.Initialize("WebClient")
	
	sett.Initialize(browser)
	sett.GetSettings.SetDOMStorageEnabled(True)
	
	sett.SetWebViewClient(WebClient)
	'sett.SetWebChromeClient(WebChromeClient)
	
	
   	Activity.AddView(sett, 0, 4%y, 100%x, 100%y)
   	sett.LoadUrl(hamrahpay.pay_url)
	addressbar.Text=hamrahpay.pay_url
	addressbar.Color=Colors.LightGray
	addressbar.TextColor=Colors.Black
	
	
	Activity.AddView(addressbar,0,0,100%x,6%y)
   	ProgressDialogShow2("لطفا صبور باشید...",False)
End Sub

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
End Sub

Sub WebClient_OverrideUrl (Url As String) As Boolean
	addressbar.Text = Url
	If Url.ToLowerCase.Contains("exit_page") Then
		Activity_Pause(True)
	End If
End Sub

Sub WebClient_UpdateVisitedHistory(Url As String, IsReload As Boolean)
	addressbar.Text = Url
	If (Url.ToLowerCase.Contains("shaparak.ir") And Url.ToLowerCase.StartsWith("https://")) Then
		addressbar.Color=Colors.RGB(90,162,43)
	End If
	
	If Url.ToLowerCase.Contains("exit_page") Then
		Activity_Pause(True)
	End If
End Sub

'Sub WebClient_ReceivedSslError (SslErrorHandler1 As SslErrorHandler, SslError1 As SslError)
'	SslErrorHandler1.Proceed
'End Sub


Sub JobDone (Job As HttpJob)
	hamrahpay.JobDone(Job)
End Sub
