jQuery(function($){

    $.supersized({

        // 功能
        slide_interval     : 6000,    // 切换间隔
        transition         : 1,    // 0-null, 1-渐消, 2-上滑, 3-右滑, 4-下滑, 5-左滑, 6-右旋, 7-左旋
        transition_speed   : 3000,    // 切换速度
        performance        : 1,    // 0-正常, 1-混合速度/品质, 2-优化图像质量, 3-优化切换速度 // (仅对火狐/IE有效, 对Webkit内核浏览器无效，如苹果浏览器)

        // 大小&位置
        min_width          : 0,    // 允许范围内最小 (以像素为单位)
        min_height         : 0,    // 最小范围内最低 (以像素为单位)
        vertical_center    : 1,    // 背景垂直居中
        horizontal_center  : 1,    // 背景水平居中
        fit_always         : 0,    //图像不会超过浏览器的宽度或高度（忽略最小尺寸）
        fit_portrait       : 1,    // 人像图不会超过浏览器高度
        fit_landscape      : 0,    // 景观图不会超过浏览器宽度

        // 组件
        slide_links        : 'blank',    // Individual links for each slide (Options: false, 'num', 'name', 'blank')
        slides             : [    // 滑动背景图片
                                 //{image : '../../img/background_hk.png'},
                                 //{image : '../../img/background_hk.png'},
                                 {image : '../../568dataInter/img/background_hk.png'}
                             ]

    });

});
