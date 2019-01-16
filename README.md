# hamrahpay_b4a
Hamrahpay Library for Basic4Android
## کتابخانه همراه پی برای بیسیک فور اندروید

## ویدئو آموزشی

[آپارات همراه پی](http://www.aparat.com/hamrahpay)


کتابخانه های مورد نیاز در بیسیک فور اندروید :
* OkHttpUtils2
* JSON
* Network
* Phone
* RandomAccessFile
* Reflection
* WebViewExtras2     - [Download](http://b4a.martinpearman.co.uk/webviewextras/)
* RuntimePermission

پرمیژن مورد نیاز کتابخانه همراه پی :
```xml
AddManifestText(<uses-permission android:name="android.permission.READ_PHONE_STATE" />)
```

## کد نویسی دکمه پرداخت

```basic
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim product_sku As String
	Private rp As RuntimePermissions
End Sub

Sub PayBtn_Click
	product_sku = "hp_55202faf1ddd8901148214" ' این کد را به شناسه کالای خود تغییر دهید
	'------------------- begin of payment codes ----------------------------
	If rp.Check(rp.PERMISSION_READ_PHONE_STATE)=True Then
		product_sku="hp_55202faf1ddd8901148214" ' کد محصول خود را جایگزین نمایید
		hamrahpay.pay_request(product_sku,Me)
	Else
		rp.CheckAndRequest(rp.PERMISSION_READ_PHONE_STATE)
	End If
	'------------------ end of payment codes -------------------------------
End Sub
' -------------------Permission request result ---------------------------
Sub Activity_PermissionResult (Permission As String, Result As Boolean)
	If Permission = rp.PERMISSION_READ_PHONE_STATE And Result=True Then
		hamrahpay.pay_request(product_sku,Me)
	Else if Permission=rp.PERMISSION_READ_PHONE_STATE And Result=False Then
		ToastMessageShow("لطفا برای ادامه ی کار سطح دسترسی لازم را به برنامه بدهید",True)
	End If
End Sub

Sub JobDone (Job As HttpJob)
	hamrahpay.JobDone(Job)
End Sub
```

## دریافت اطلاعات آخرین خرید مشتری
برای پرداخت های اشتراکی که کاربر باید طی دوره های زمانی مبلغی راپرداخت نماید میتوانید اطلاعات  آخرین پرداخت مشتری را به دست آورده و نسبت به آن تصمیم گیری کنید که چه زمانی نیاز به پرداخت مجدد است
از قطعه کد زیر میتوانید این اطلاعات را به دست آورید
```basic
' کد دکمه دریافت اطلاعات
Sub lastpurchase_btn_Click
	product_sku="hp_55202faf1ddd8901148214" ' کد محصول خود را جایگزین نمایید
	hamrahpay.RetriveLastPurchaseInfo(product_sku,Me)
End Sub
' پس از دریافت اطلاعات آخرین خرید این متد صدا زده میشود که حاوی وضعیت و اطلاعات آن است
Sub LastPurchaseData(lastPurchase As LastPurchaseInfo)
	If lastPurchase.error=False Then
		Dim daysAgo As Int =  lastPurchase.DaysAgo
		Dim purchaseDate As String = lastPurchase.date
		Dim current_date As String =lastPurchase.CurrentDate
		Dim purchaseUnixTimeStamp As String = lastPurchase.unixTimestamp
		Dim reserve_id As String = lastPurchase.ReserveID
		ToastMessageShow("Days Ago: "&daysAgo&" Reserve ID: "&reserve_id,True)
		Else
		ToastMessageShow(lastPurchase.message,True)
	End If
End Sub
' ----------------------------------------------------------------------
Sub JobDone (Job As HttpJob)
	hamrahpay.JobDone(Job)
	If Job.Success And Job.JobName="Last_Purchase" Then
		LastPurchaseData(hamrahpay.getlastPurchase())
	End If
End Sub

```
### پشتیبانی

[![](https://hamrahpay.com/assets/home/theme/img/logo-red.png)](https://hamrahpay.com)

 هرگونه سوالی در رابطه با این کتابخانه را از بخش تیکت ها در پنل خود در سایت ما مطرح نمایید.
 
