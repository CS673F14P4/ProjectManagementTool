
$(document).ready(function() {

    // load the images based on user's input
    var items = [];

    // clear the current images
    $('#tab1').html('');
    $('#tab1').removeAttr('style');
    //$('#images').cycle("destroy");

    // get user input
                    //var tag = $('#tag').val();

    $.getJSON("http://data.colorado.gov/resource/4ykn-tg5h.json", 
        function(data) {
            $.each(data, function(key, val) {
                
            var elm = $("<input>").attr({
                         "value" : val.agentfirstname
                          });
                         $('#tab1').append(elm);
                    })
                });
                
            })
