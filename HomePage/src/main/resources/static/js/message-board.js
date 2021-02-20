// Message Board page

// Ajax Message Board Form
jQuery(function($) {
	var ajax_message_board_form = $("form.ajax_message_board_form");
	var ajax_message_board_form_success = $(".ajax_message_board_form_success");

	if(ajax_message_board_form.length) {
		// Fields
		var title 	= ajax_message_board_form.find('#title');
		var content = ajax_message_board_form.find('#content');
		var submit	= ajax_message_board_form.find('button[type="submit"]');

		// Ajax Message Board Form
        ajax_message_board_form.submit(function(ev) {
			ev.preventDefault();
			
			var post_fields = {
				title			: title.val(),
				content			: content.val()
			};
			
			var form_errors = 0;
			
			// Check Content
			if(post_fields.content.length == 0) {
				form_errors++;
				content.addClass('error').focus();
			}
			else {
				content.removeClass('error');
			}
			
			// Check Title
			if(post_fields.title.length == 0) {
				form_errors++;
				title.addClass('error').focus();
			}
			else {
				title.removeClass('error');
			}

			if(form_errors == 0) {
				submit.fadeTo(500, 0.3);
				
				$.post('/MessageBoardService/publish', post_fields, function(resp) {
					resp = parseInt(resp, 10);
					if(resp == 1) {
                        ajax_message_board_form_success.slideDown(500);
						submit.slideUp(500);
					}
					else if(resp == -1) {
						alert('An error occurred and your message can not be send, try again later!');
						submit.fadeTo(500, 1);
					}
				});
			}
		});
	}
});

function valid_email(email) {
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   return reg.test(email);
}