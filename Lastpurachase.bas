B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
Sub Class_Globals
	Private deviceID,sku As String
	Dim job As HttpJob
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(pSku As String,pDeviceID As String)
	deviceID=pDeviceID
	sku = pSku
End Sub

