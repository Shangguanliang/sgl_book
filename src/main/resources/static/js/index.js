$(function () {
    //下拉菜单
    $('.dropdown-toggle').dropdown()

    //点击修改按钮跳转页面
    $("button[name='update']").click(function () {
        alert("111")
        window.location.href='book/updateBook.html'
    })
})