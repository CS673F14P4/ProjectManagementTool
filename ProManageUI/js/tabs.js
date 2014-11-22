$(document).ready(function() {
	function showonlyone(thechosenone) {
     $('.tab').each(function(index) {
          if ($(this).attr("id") == thechosenone) {
               $(this).show(200);
          }
          else {
               $(this).hide(600);
          }
     });
}
})