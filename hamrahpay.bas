B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=StaticCode
Version=5.5
@EndOfDesignText@
' www.Hamrahpay
' HamrahPay Official library for basic4android developers
' Code module
' Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim	verification_type As String
	'verification_type ="email_verification"
	verification_type ="device_verification"
	
	Dim pay_request_url As String 
	Dim	pay_verify_url As String
	Dim last_purchase_url As String
	Dim pay_url As String
	
	Dim HttpUtils As HttpJob
	Dim device_id As String
	Dim pay_code As String
	Dim product_sku As String
	Dim status	As String
	Dim error As Boolean
	Dim pay_status As Boolean
	Dim	parent_activity As Object
	Dim lib_vers As String
	Dim lib_name As String
	pay_status= False
	error=False
	product_sku=""
	lib_vers = 3
	lib_name = "B4A"
	Dim last_purchase_info As LastPurchaseInfo
End Sub

'This method returns unique id from each device
Sub GetDeviceId As String
Dim P As Phone
Dim id As String
Dim r As Reflector
Dim Api As Int
Dim pID As PhoneId

   id = pID.GetDeviceId
   Api = r.GetStaticField("android.os.Build$VERSION", "SDK_INT")
   If id==Null Then
	   If Api < 9 Then
	      'Old devices
	      id= P.GetSettings("android_id")
		  'id = pID.GetDeviceId
	   Else
	      'New devices
	      id= r.GetStaticField("android.os.Build", "SERIAL")
	      If id.ToLowerCase = "unknown" Then 
		  	id= P.GetSettings("android_id")
	   End If
	   
	   If id.ToLowerCase = "9774d56d682e549c" Or id = Null Then id = P.GetSettings("android_id")
	   End If
   End If
   
   Return id
End Sub
'---------------------------------------------------------
' this method makes an app purchased
Sub	MakePayed(sku As String)
	StateManager.SetSetting(sku,"premium_key_"&sku&GetDeviceId)
	StateManager.SaveSettings
End Sub
'---------------------------------------------------------
' this method checks if an app purchased or not
Sub	isPayed(sku As String) As Boolean
	Dim pay_hash As String
	Dim	key_code As String
	key_code = "premium_key_"&sku&GetDeviceId
	
	pay_hash = StateManager.GetSetting2(sku,"")
	If pay_hash= key_code Then
		Return True
	Else
		Return False
	End If
End Sub
'---------------------------------------------------------
Sub IsConnected As Boolean 
   Dim P As Phone,server As ServerSocket
   Try
       server.Initialize(0, "")
       If server.GetMyIP = "127.0.0.1" Then 
	   		Return False
		End If 
		
       If Not(P.GetDataState.EqualsIgnoreCase("CONNECTED")) And server.GetMyWifiIP = "127.0.0.1" Then 
	   		Return False
	   End If
	   
       Return True
   Catch
      Return False
   End Try
End Sub
'---------------------------------------------------------
Private Sub verify(verify_map As Map) 
	status = verify_map.Get("status")
	error = verify_map.Get("error")
	
	If error=True Then
		ToastMessageShow(verify_map.Get("message"),True)
		pay_status= False
	Else
		If status="SUCCESSFUL_PAYMENT" Then
			pay_status= True
		Else 
			pay_status= False
		End If	
	End If
	If (pay_status=True) Then
		activate_app
	End If
	'ToastMessageShow("status : "&status&" | error : "&error&" pay_status : "&pay_status&" |Debug : "&verify_map.Get("debug_code"),True)
End Sub
'---------------------------------------------------------
Private Sub payment(res_map As Map)
	
	
	pay_url = "https://hamrahpay.com/cart/app/pay_v2/"
	status = res_map.Get("status")
	error = res_map.Get("error")
	If (error=False) Then
		If status="SELLER_BLOCKED" Or status="TRY_AGAIN" Or status="BAD_PARAMETERS" Then
			ToastMessageShow(res_map.Get("message"),True)
		Else If status="READY_TO_PAY" Then
			pay_code = res_map.Get("pay_code")		
			pay_url = pay_url&pay_code
			StartActivity(payment_activity)
		Else If status="BEFORE_PAID" Then								
			' قبلا پرداخت توسط کاربر انجام شده است و برنامه نویس باید نرم افزار خود را فعال نماید
			pay_code = res_map.Get("pay_code")
			verify_payment(pay_code,product_sku)
			If pay_status=True Then
			activate_app
			End If
		Else
			ToastMessageShow(res_map.Get("message"),True)
		End If		
	Else
		ToastMessageShow(res_map.Get("message"),True)
		pay_code=""
	End If
End Sub
'---------------------------------------------------------
Sub pay_request(sku As String,m_activity As Object)
	If IsConnected=False Then
		ToastMessageShow("دستگاه شما به اینترنت متصل نمیباشد . لطفا از صحت اتصال به اینترنت اطمینان حاصل فرمایید.",True)
	Else
		parent_activity = m_activity
		pay_request_url = "https://hamrahpay.com/rest-api/pay-request"
		product_sku = sku
		Dim post_param As String
		Dim package_name As String
		package_name = Application.PackageName
		post_param =  "sku="&sku&"&device_id="&GetDeviceId&"&verification_type="&verification_type&"library_version="&lib_vers&"library_name="&lib_name&"package_id="&package_name
		HttpUtils.Initialize("Pay_Request",parent_activity)
		HttpUtils.PostString(pay_request_url, post_param)
	
		ProgressDialogShow2("لطفا صبور باشید ، در حال بر قراری ارتباط با سرور...",False)
		
	End If
	
End Sub
'---------------------------------------------------------
Sub verify_payment(pay_code_param As String,sku As String)
	Dim	device_model As String
	Dim device_manufacturer As String
	Dim sdk_version As String 
	Dim	p As Phone

	device_model = p.Model 
	device_manufacturer = p.Manufacturer
	sdk_version = p.SdkVersion
	
	pay_verify_url = "https://hamrahpay.com/rest-api/verify-payment"
	HttpUtils.Initialize("Pay_Verify",parent_activity)
	HttpUtils.PostString(pay_verify_url, "pay_code="&pay_code_param&"&sku="&sku&"&device_model="&device_model&"&device_manufacturer="&device_manufacturer&"&sdk_version="&sdk_version&"&library_version="&lib_vers&"&library_name="&lib_name&"&package_id="&package_name)
	'ProgressDialogShow2("در حال بررسی تراکنش...",False)
End Sub
'---------------------------------------------------------
Public Sub RetriveLastPurchaseInfo(pSku As String,m_activity As Object)
	parent_activity = m_activity
	last_purchase_url = "https://hamrahpay.com/rest-api/trans-info"
	HttpUtils.Initialize("Last_Purchase",parent_activity)
	HttpUtils.PostString(last_purchase_url, "sku="&pSku&"&device_id="&GetDeviceId)
End Sub
'---------------------------------------------------------
Private Sub setLastPurchaseIfo(res_map As Map)

	last_purchase_info.error= res_map.Get("error")
	last_purchase_info.message = res_map.Get("message")
	
	If(res_map.ContainsKey("days_ago")) Then
	last_purchase_info.current_date = res_map.Get("current_date")
	last_purchase_info.days_ago = res_map.Get("days_ago")
	last_purchase_info.date = res_map.Get("date")
	last_purchase_info.reserve_id = res_map.Get("reserve_id")
	last_purchase_info.unixTimestamp = res_map.Get("date_unix_timestamp")
	End If
End Sub
'---------------------------------------------------------
Public Sub getlastPurchase() As LastPurchaseInfo
	Return last_purchase_info
End Sub
'---------------------------------------------------------

' this method called when http request is done
Sub JobDone (Job As HttpJob)
	Dim JSON As JSONParser
	Dim ResultMap As Map

	Dim req_result As String
	
	If Job.Success = True Then
		req_result = Job.GetString
		JSON.Initialize(req_result)
		ResultMap= JSON.NextObject
		Select Job.JobName
			Case "Pay_Request"
				ProgressDialogHide
				payment(ResultMap)
			Case "Pay_Verify"	
				verify(ResultMap)
			Case "Last_Purchase"
				setLastPurchaseIfo(ResultMap)
		End Select
	Else
			Log("Error: " & Job.ErrorMessage)
	      	ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
   Job.Release
End Sub


Sub activate_app()

	'کد های فعال سازی برنامه خود را در این قسمت بنویسید
	' write your activate code here
	MakePayed(product_sku)
	ToastMessageShow("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد." & product_sku,True)
End Sub
	
