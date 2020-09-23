$(function () {
    //下拉菜单
    $('.dropdown-toggle').dropdown()

    //点击删除按钮删除相应数据
    //找到按钮 点击时间
    $("button[data-delete]").click(function () {
        //this.找到对应 id
        let id = $(this).data('delete');
        $.ajax({
            url: `/book/${id}`,
            type: 'DELETE',
            success: () => window.location.reload()
        })
    })
})