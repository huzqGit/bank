
jQuery(document).ready(function() {
    $('.page-container form').submit(function(){
        var username = $(this).find('.userId').val();
        var password = $(this).find('.password').val();
        if(username == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '27px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.userId').focus();
            });
            return false;
        }
        if(password == '') {
            $(this).find('.error').fadeOut('fast', function(){
                $(this).css('top', '96px');
            });
            $(this).find('.error').fadeIn('fast', function(){
                $(this).parent().find('.password').focus();
            });
            return false;
        }
    });
    $('.page-container form .password').keypress(function(event){
    	  if(event.keyCode == "13")    
          {
    		  $('.page-container form').submit();
          }
    });
    $('.page-container form .userId, .page-container form .password').keyup(function(){
        $(this).parent().find('.error').fadeOut('fast');
    });

});
