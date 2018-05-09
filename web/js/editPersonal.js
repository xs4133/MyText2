function modify() {
	var o=document.getElementsByClassName("fildtext");
	for(var i=0;i<o.length;i++)
	{
	o[i].removeAttribute('disabled');
	o[i].removeAttribute('readonly');
	}
}
function save() {
	// document.form1.action="/ServleteditPersonalttt";
	document.form1.submit();
}
function shengshi() {
	var o=document.getElementById('province');
	var select=o.value;
	
	var lncity=['沈阳','大连','葫芦岛']
	var jlcity=['吉林','长春','四平']
	if(select=="辽宁省")
	{
		var s2=document.getElementById("city");
		
		s2.innerHTML="";
		for (var i=0;i<lncity.length;i++) {
			s2.innerHTML +="<option value='"+lncity[i]+"'>"+lncity[i]+"</option>";
		}
	}
	if(select=="吉林省")
	{
		var s2=document.getElementById("city");
		s2.innerHTML="";
		for (var i=0;i<jlcity.length;i++) {
			s2.innerHTML +="<option value='"+jlcity[i]+"'>"+jlcity[i]+"</option>";
			
		}
	}
}