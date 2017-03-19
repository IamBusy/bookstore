var mode='add';
var UserList=[];
var curUid=0;

$(document).ready(function(){
    getUsers();

    $("#add").on('click',function(){
        mode='add';
    });

    $("#addUserButton").on('click',function(){
        var account=$("#account").val();
        var pwd=$("#pwd").val();
        var name=$("#name").val();
        if(account==''||pwd==''||name=='')
        {
            alert("请填写完整信息！");
            return ;
        }
        if(mode=='add')
        {

            $.ajax({
                url:URL_REQUEST+'users',
                type:"POST",
                dataType:'json',
                data:{
                    phone:account,
                    password:pwd,
                    userName:name
                },
                success:function(data)
                {
                    console.log(data);
                    C_prompt('添加成功！');
                    $("#addUser").modal("hide");
                    window.location.href="user.jsp";
                }
            });
        }
        else if(mode=='edit')
        {

            $.ajax({
                url:URL_REQUEST+'users/'+curUid,
                type:"PUT",
                dataType:'json',
                data:JSON.stringify({
                    phone:account,
                    password:pwd,
                    userName:name
                }),
                success:function(data)
                {
                    C_prompt('修改成功！');
                    $("#addUser").modal("hide");
                    window.location.href="user.jsp";
                }
            });
        }

    });

    $("#usersArea").on('click','.update',function(){
        mode='edit';
        $("#account").val('');
        $("#pwd").val('');
        $("#name").val('');
        $("#addUser").modal("show");
        var uid=$(this).attr('uid');

        for(var i=0;i<UserList.length;i++)
        {
            if(UserList[i].id==uid)
            {
                $("#account").val(UserList[i].phone);
                $("#pwd").val(UserList[i].password);
                $("#name").val(UserList[i].userName);
                curUid=UserList[i].id;
                $("#addUser").modal("show");
                return ;
            }
        }
        C_prompt("ERROR");
    });


    $("#usersArea").on('click','.operation',function(){
        if(!confirm("您确定要删除该用户吗?")) return ;
        var uid=$(this).attr('uid');
        var self=$(this);
        $.ajax({
            url:URL_REQUEST+'users/'+uid,
            type:"DELETE",
            dataType:'json',
            data:{uid:uid},
            success:function(data)
            {
                self.closest('tr').hide();
            }
        });
    });
});

var getUsers=function()
{
    $.ajax({
        url:URL_REQUEST+'users',
        dataType:'json',
        success:function(data)
        {
            console.log(data);
            UserList=data;
            dealData((data));
        }
    });
}

var dealData=function(data)
{
    var len=data.length;
    for(var i=0;i<len;i++)
    {
        var tr=$("<tr/>");
        tr.html("<td>"+data[i].id+"</td>"+"<td>"+data[i].phone+"</td>"+"<td>"+data[i].userName+"</td>"+"<td><input type=\"button\" class=\"btn btn-primary operation\" value=\"Delete!\" uid=\""+data[i].id+"\">" +
            "<input type=\"button\" class=\"btn btn-info update\" value=\"Update!\" uid=\""+data[i].id+"\"></td>");
        tr.appendTo("#usersArea")
    }
}


/*var geneTable=function(data){
 var tr=$("<tr/>");
 var oid="<td>"+data[0].oid+"</td>";
 var time="<td>"+data[0].time+"</td>";
 var books="";
 var nums="";
 var price=0;
 var sprice="";
 for(var i=0;i<data.length;i++)
 {
 books+="<tr><td>"+data[i].title+"</td></tr>";
 nums+="<tr><td>"+data[i].num+"</td></tr>";
 sprice+="<tr><td>"+data[i].price+"</td></tr>";
 price+=(data[i].num*data[i].price);
 }
 price="<td>￥"+price+"</td>";
 sprice="<td><table>"+sprice+"</table></td>";
 books="<td><table>"+books+"</table></td>";
 nums="<td><table>"+nums+"</table></td>";
 $("<tr>"+oid+price+books+nums+sprice+time+"</tr>").appendTo("#ordersArea");
 }*/