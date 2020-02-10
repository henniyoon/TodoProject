/**
 * AJAX로 데이터 전송 (JSON)
 * @param path 전송할 URL
 * @param json JSON 데이터
 * @param method GET or POST
 */
function sendAJAX(path, json, method)
{
    method = method || "post";
    
    $.ajax({
        url: path,
        type: method,
        data: json,
            success: function(data, textStatus, jqXHR)
            {
                //data - response from server
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert(errorThrown + " " + textStatus);
            }
        });
}