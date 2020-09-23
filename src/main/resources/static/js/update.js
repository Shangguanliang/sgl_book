$('form').submit(function () {
    //获取表单内的数据
    const formData = new formData($("#formText")[0])
    $.ajax({
        url:'/book/update',
        type:'POST',
        data:formData,
        processData:false,
        contentType:false,
        success:() => alert('修改成功')
    })
})