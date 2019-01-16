B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=8.3
@EndOfDesignText@
Sub Class_Globals
	Dim status,message,unixTimestamp,date,reserve_id,current_date As String
	Dim days_ago As Int
	Dim error As Boolean
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(pStatus As String, pError As Boolean, pMessage As String, pUnixTimestamp As String, pDate As String, pReserve_id As String, pDays_ago As Int, pCurrent_date As String)
	status = pStatus
	error = pError
	message = pMessage
	unixTimestamp = pUnixTimestamp
	date = pDate
	reserve_id = pReserve_id
	days_ago = pDays_ago
	current_date = pCurrent_date
End Sub

Public Sub getStatus() As String
	Return status
End Sub

Public Sub getError() As Boolean
	Return error
End Sub

Public Sub getMessage() As String
	Return message
End Sub

Public Sub getUnixTimestamp() As String
	Return unixTimestamp
End Sub

Public Sub getDate() As String
	Return date
End Sub

Public Sub getReserveID() As String 
	Return reserve_id
End Sub

Public Sub getDaysAgo() As Int
	Return days_ago
End Sub

Public Sub getCurrentDate() As String
	Return current_date
End Sub
