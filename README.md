
SyntaxEditor Code Snippet

# hamrahpay_b4a  Hamrahpay Library for Basic4Android
## کتابخانه همراه پی برای بیسیک فور اندروید  (کتابخانه پیشنهادی)
## ویدئو آموزشی  
[آپارات همراه پی](https://www.aparat.com/v/TBxuV)
<p dir='rtl' align='right'>
در این کتابخانه صفحه ی پرداخت در مرور گوشی باز میشود ( روش پیشنهادی )

</p>
<p dir='rtl' align='right'>
پیشنهاد میگردد پروژه را از گیت هاب دانلود نموده و یک بار به صورت مستقل آن را مطالعه و تست نمایید.
</p>

کتابخانه های مورد نیاز در بیسیک فور اندروید :
* OkHttpUtils2
* JSON
* Network
* Phone
* RandomAccessFile
* Reflection
* RuntimePermission
<p dir='rtl' align='right'>
پرمیژن و تنظیمات Manifest مورد نیاز کتابخانه همراه پی : ( به پروژه اضافه گردد )
</p>

```xml
AddManifestText(<uses-permission android:name="android.permission.READ_PHONE_STATE" />)

AddActivityText(YOUR_ACTIVITY,
<intent-filter>
    <action android:name="android.intent.action.VIEW"/>
    <category android:name="android.intent.category.DEFAULT"/>
    <category android:name="android.intent.category.BROWSABLE"/>
    <data android:host="your_b4a_app_unique_id" android:scheme="hamrahpay"/>
</intent-filter> 
)
```
<p dir='rtl' align='right'>
YOUR_ACTIVITY را با نام اکتیویتی خود جایگزین نمایید . مثل Main
</p>

<p dir='rtl' align='right'>
عبارت
</p>

**your_b4a_app_unique_id**
<p dir='rtl' align='right'>
را با یک عبارت دلخواه و کاملا یکتا جایگزین کنید.
در نظر داشته باشید که فقط و فقط میتوانید از حروف انگلیسی، اعداد و خط فاصله استفاده نمایید و استفاده از کارکترهایی مانند فاصله و علائم دیگر مجاز نیست
</p>

## اضافه کردن کلاس همراه پی  
<p dir='rtl' align='right'>
فایل های زیر  را به پروژه ی خود اضافه نمایید و طبق راهنمای زیر عمل کنید

* Hamrahpay.bas
* Lastpurachase.bas
* LastpurachaseInfo.bas
* StateManager.bas
</p>

## کد نویسی دکمه پرداخت  
در اکتیویتی که دکمه پرداخت وجود دارد توابع زیر را اضافه نمایید

```VBA
Sub Process_Globals
	Dim HP As Hamrahpay
End Sub

Sub 
	Dim product_sku As String
	Private rp As RuntimePermissions
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Private pay_btn As Button
	Activity.LoadLayout("paybtn")
End Sub

Sub Activity_Resume
	If Not(HP.IsInitialized) Then HP.Initialize("your_b4a_app_unique_id",Me)
	HP.HamrahPayVerification(Activity.GetStartingIntent)
End Sub

Sub JobDone (Job As HttpJob)
	HP.JobDone(Job)
End Sub
```
<p dir='rtl' align='right'>
فراموش نکنید که your_b4a_app_unique_id را دقیقا مانند عبارت انتخاب شده ی بالا برای این برنامه وارد نمایید . در صورتی که این مقدار مانند مقدار بالا نباشد و یا در برنامه های شما تکراری باشد عملیات پرداخت موفق نخواهد بود.
(این مقدار باید در هر برنامه یکتا باشد)

حال توابع مورد نیاز برای پرداخت را بررسی میکنیم
</p>

```VBA
Sub pay_btn_Click ' کد های دکمه پرداخت
	'------------------- begin of payment codes ----------------------------
	If rp.Check(rp.PERMISSION_READ_PHONE_STATE)=True Then
		product_sku="hp_55202faf1ddd8901148214" ' کد محصول خود را جایگزین نمایید
		HP.pay_request(product_sku)
	Else
		rp.CheckAndRequest(rp.PERMISSION_READ_PHONE_STATE)
	End If
	'------------------ end of payment codes -------------------------------
End Sub
'------------------------------------------------------------------------------
Sub	onPaymentSucceed(paycode As String,sku As String)
	
	'کد های فعال سازی برنامه خود را در این قسمت بنویسید
	' write your activate code here
	HP.MakePayed(product_sku)
	ToastMessageShow("نرم افزار شما به نسخه طلایی ارتقاع پیدا کرد." & product_sku,True)
End Sub
'-----------------------------------------------------------------------
' -------------------Permission request result ---------------------------
Sub Activity_PermissionResult (Permission As String, Result As Boolean)
	If Permission = rp.PERMISSION_READ_PHONE_STATE And Result=True Then
		HP.pay_request(product_sku)
	Else if Permission=rp.PERMISSION_READ_PHONE_STATE And Result=False Then
		ToastMessageShow("لطفا برای ادامه ی روند پرداخت سطح دسترسی لازم را به برنامه بدهید",True)
	End If
End Sub
```
* onPaymentSucceed
<p dir='rtl' align='right'>
این تابع زمانی Call میشود که پرداخت موفقیت آمیز بوده است . شما در این بخش میتوانید کدهای فعال سازی را نوشته و یا هر عملیاتی که بعد از پرداخت موفق باید انحاام شود
</p>

* Activity_PermissionResult
<p dir='rtl' align='right'>
زمانی که کاربر دسترسی لازم را به کتابخانه بدهد این تابع Call میشود
</p>

* HP.pay_request
<p dir='rtl' align='right'>
عملیات پرداخت را برای یک شناسه کالا شروع میکند
</p>


<p dir='rtl' align='right'>
فراموش نکنید که دو تابع onPaymentSucceed و Activity_PermissionResult باید در اکتیویتی که دکمه پرداخت شما است اضافه شود.
</p>

## دریافت اطلاعات آخرین خرید مشتری  
<p dir='rtl' align='right'>
برای پرداخت های اشتراکی که کاربر باید طی دوره های زمانی مبلغی راپرداخت نماید میتوانید اطلاعات  آخرین پرداخت مشتری را به دست آورده و نسبت به آن تصمیم گیری کنید که چه زمانی نیاز به پرداخت مجدد است
از قطعه کد زیر میتوانید این اطلاعات را به دست آورید
</p>

```VBA
' کد دکمه دریافت اطلاعات
Sub lastpurchase_btn_Click
	product_sku="hp_55202faf1ddd8901148214" ' کد محصول خود را جایگزین نمایید
	HP.RetriveLastPurchaseInfo(product_sku,Me)
End Sub

' پس از دریافت اطلاعات آخرین خرید این متد صدا زده میشود که حاوی وضعیت و اطلاعات آن است
' ----------------------------------------------------------------------
Sub	onGetLastPurchaseInfoSucceed(lastPurchase As LastPurchaseInfo)
	If lastPurchase.error=False Then
		Dim daysAgo As Int =  lastPurchase.DaysAgo ' number of days ago of last purchase
		Dim purchaseDate As String = lastPurchase.date ' last purchase date
		Dim current_date As String =lastPurchase.CurrentDate ' current date
		Dim purchaseUnixTimeStamp As String = lastPurchase.unixTimestamp ' current date in unix timestamp format
		Dim reserve_id As String = lastPurchase.ReserveID ' reserve id of last purchase
		ToastMessageShow("Days Ago: "&daysAgo&" Reserve ID: "&reserve_id,True)
	Else
		ToastMessageShow(lastPurchase.message,True)
	End If
End Sub
```
* onGetLastPurchaseInfoSucceed
<p dir='rtl' align='right'>
زمانی که شما دکمه درخواست دریافت اطلاعات آخرین پرداخت برای یک شناسه کالا را میزنید درخواست به همراه پی ارسال میشود و زمانی که پاسخ دریافت شد این تابع Call  میشود 
در این تابع میتوانید تصمیم بگیرید که کاربر مجددا پرداخت کند یا خیر
</p>
### پشتیبانی  
[![](https://hamrahpay.com/assets/home/theme/img/logo-red.png)](https://hamrahpay.com)

 هرگونه سوالی در رابطه با این کتابخانه را از بخش تیکت ها در پنل خود در سایت ما مطرح نمایید.
