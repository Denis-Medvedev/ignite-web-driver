$( document ).ready(function() {
    function process(result) {
        $('#progressBar').hide();
        var temp = jQuery.parseJSON( result );
        if (temp) {
            $("#resultCode").html(temp.code);
            $("#resultText").html(temp.text);
            $("#resultField").html(temp.total);
        }
    };
    $("#clearCache").click(function(){
        $('#progressBar').show();
        $('#resultTitle').html('Clear status:')
        $.ajax({url: "calculation?mode=clear", success: process});
    });
    $("#fillCache").click(function(){
        $('#progressBar').show();
        $('#resultTitle').html('Fill status:')
        $.ajax({url: "calculation?mode=fill", success: process});
    });
    $("#checkCache").click(function(){
        $('#progressBar').show();
        $('#resultTitle').html('Check status:')
        $.ajax({url: "calculation?mode=check", success: process});
    });
    $("#calcTotal").click(function(){
        $('#progressBar').show();
        $('#resultTitle').html('Calc status:')
        $.ajax({url: "calculation?mode=calc", success: process});
    });
});