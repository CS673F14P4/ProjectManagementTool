/*$(document).ready(function() {
    $('.tabs .tab-links a').on('click', function(e)  {
        var currentAttrValue = $(this).attr('href');
 
        // Show/Hide Tabs
        $('.tabs ' + currentAttrValue).show().siblings().hide();
 
        // Change/remove current tab to active
        $(this).parent('li').addClass('active').siblings().removeClass('active');
        $(currentAttrValue).addClass('active').siblings().removeClass('active');
 
        e.preventDefault();
   }); 
  $(link2).on('click', function() {
  	$(tab2).addClass('active').siblings().removeClass('active');
  });
}); */
var counter = 0;
window.showt1 = function() {
	document.getElementById("t1link").style.background = '#c9c9c9';
	document.getElementById("tab1").style.display = 'block';
	document.getElementById("t2link").style.background = '#7FB5DA';
	document.getElementById("t3link").style.background = '#7FB5DA';
	document.getElementById("t4link").style.background = '#7FB5DA';
	
	document.getElementById("tab2").style.display = 'none';
	document.getElementById("tab3").style.display = 'none';
	document.getElementById("tab4").style.display = 'none';
	
}
window.showt2 = function() {
	document.getElementById("t1link").style.background = '#7FB5DA';
	document.getElementById("t2link").style.background = '#c9c9c9';
	document.getElementById("t3link").style.background = '#7FB5DA';
	document.getElementById("t4link").style.background = '#7FB5DA';
	document.getElementById("tab1").style.display = 'none';
	document.getElementById("tab2").style.display = 'block';
	document.getElementById("tab3").style.display = 'none';
	document.getElementById("tab4").style.display = 'none';
	
}
window.showt3 = function() {
	document.getElementById("t1link").style.background = '#7FB5DA';
	document.getElementById("t2link").style.background = '#7FB5DA';
	document.getElementById("t3link").style.background = '#c9c9c9';
	document.getElementById("t4link").style.background = '#7FB5DA';
	document.getElementById("tab1").style.display = 'none';
	document.getElementById("tab2").style.display = 'none';
	document.getElementById("tab3").style.display = 'block';
	document.getElementById("tab4").style.display = 'none';
	
}
window.showt4 = function() {
	document.getElementById("t1link").style.background = '#7FB5DA';
	document.getElementById("t2link").style.background = '#7FB5DA';
	document.getElementById("t3link").style.background = '#7FB5DA';
	document.getElementById("t4link").style.background = '#c9c9c9';
	document.getElementById("tab1").style.display = 'none';
	document.getElementById("tab2").style.display = 'none';
	document.getElementById("tab3").style.display = 'none';
	document.getElementById("tab4").style.display = 'block';
	
}
window.pmform = function() {
	//document.getElementById("pmform").method = "post";
	counter = counter+1;
	var pmstory = document.getElementById("pmtxt").value;
	var pmdate = document.getElementById("pmdate").value;
	for(var x=0; x<counter; x++)
	document.getElementById("display").innerHTML = '<td><a href="createTask.html">' + pmstory + '</a></td><td class="pmtd">Due:' + pmdate + "</td></tr>";
	document.getElementById("display").style.display = "block";
	document.getElementById("pmform").reset(); 
}
