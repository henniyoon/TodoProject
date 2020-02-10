/**
 * AJAX로 데이터 전송 (JSON)
 * @param path 전송할 URL
 * @param json JSON 데이터
 * @param method GET or POST
 */
function sendType(path, json, method)
{
    method = method || "post";
    
    $.ajax({
        url: path,
        type: method,
        data: json,
            success: function(data, textStatus, jqXHR)
            {
                //data - response from server
            	window.location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert(errorThrown + " " + textStatus);
            }
        });
}

function setItem(id, typeId)
{
    sendType('/api/rest/v1/todo/update/type/' + id, { "typeId" : typeId });
    
}

$(".todoList").change(function()
    {
        if($(this).is(":checked"))
            setItem($(this).attr("value"), 1);
        else
            setItem($(this).attr("value"), 0);
    });