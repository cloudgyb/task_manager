var curr_index = 0;
			var list = $("#list").children();
			var buttons = $("#buttons").children("span");
			buttons.eq(curr_index).css("background","blue");
			buttons.eq(curr_index).css("background","white");
			list.eq(curr_index).animate({top:"-"+curr_index*400+"px",left:"700px"},2000);
			list.eq(curr_index).css({top:"-"+curr_index*400+"px",left:"-700px"});
			curr_index = curr_index+1;
			if(curr_index>3){ curr_index=0;}
			list.eq(curr_index).css({top:"-"+curr_index*400+"px",left:"-700px"});
			buttons.eq(curr_index).css("background","blue");
			list.eq(curr_index).animate({top:"-"+curr_index*400+"px",left:"0px"},2000);
			setInterval(function(){
					buttons.eq(curr_index).css("background","white");
					list.eq(curr_index).animate({top:"-"+curr_index*400+"px",left:"700px"},2000);

					list.eq(curr_index).css({top:"-"+curr_index*400+"px",left:"-700px"});
					curr_index = curr_index+1;
					if(curr_index>3){ curr_index=0;}
					list.eq(curr_index).css({top:"-"+curr_index*400+"px",left:"-700px"});
					buttons.eq(curr_index).css("background","blue");
					list.eq(curr_index).animate({top:"-"+curr_index*400+"px",left:"0px"},2000);
				},1900);
