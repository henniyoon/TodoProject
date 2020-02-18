/**
 * AJAX로 데이터 전송 (JSON)
 * @param path 전송할 URL
 * @param json JSON 데이터
 * @param method GET or POST
 */

function setItem(id, typeId)
{
    $.ajax({
        url: '/api/rest/v1/todo/update/type/' + id,
        type: "post",
        data: { "typeId" : typeId },
        dataType: 'json',
            success: function(data, textStatus, jqXHR)
            {
                //data - response from server
//            	window.location.reload();
            	var c = $('#progress' + data.todoId);
            	c.circleProgress('value', data.progressWidth);
            	c.attr("percent", data.progressWidth);
            	
            	// deadline 뷰
            	if(data.progressWidth == 1.0) {
            		$('#done' + data.todoId).attr("style", "");
            		$('#doing' + data.todoId).attr("style", "display:none");
            	}
            	else {
            		$('#done' + data.todoId).attr("style", "display:none");
            		$('#doing' + data.todoId).attr("style", "");
            		if(data.deadline == null) {
            			$("#no_deadline" + data.todoId).attr("style", "");
            			$("#deadline", data.todoId).attr("style", "display:none");
            		} else {
            			$("#no_deadline" + data.todoId).attr("style", "display:none");
            			$("#deadline", data.todoId).attr("style", "");
            		}
            	}
            	
            	// checkbox 뷰
            	$.each(data.todoListItems, function(index, value) {
            		var check = $("#todoListCheck" + data.todoListItems[index].todoListId);
                	var list = $("#todoList" + data.todoListItems[index].todoListId);
                	check.attr("checked", data.todoListItems[index].todoDone);
                	
                	if(data.todoListItems[index].todoDone == true) 
                		list.attr("style", "text-decoration: line-through");
                	else 
                		list.attr("style", "");
            	})
            	
            	
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert(errorThrown + " " + textStatus);
            }
        });
}

$(".todoList").change(function()
    {
        if($(this).is(":checked"))
            setItem($(this).attr("value"), 1);
        else
            setItem($(this).attr("value"), 0);
    });
