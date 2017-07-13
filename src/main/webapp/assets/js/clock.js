var aImg = document.getElementsByClassName("timeNum");  /* 获取显示时间的img节点 */
var shockNum = [ -15, 15, -9, 9, -4, 0];                /* 振幅的数组 */
var iNow = [];                                            /* 存储每次需要波动的节点下标 */

/* 初始化电子表 */
time();
/* 设置定时器更新时间（1s） */
var timer = setInterval(function(){
    time();
},1000);
/* 获取时间方法 */
function time(){
    var dateNow = new Date();                /* new一个Date对象 */
    var hours = dateNow.getHours();            /* 时 */
    var minius = dateNow.getMinutes();        /* 分 */
    var seconds = dateNow.getSeconds();        /* 秒 */
    var str = timeStyle(hours)+timeStyle(minius)+timeStyle(seconds); /* 用字符串存储当前时间 */
    /* 通过str初始化时间表 */
    for (var i=0; i<str.length; i++) {
        /* 判断每次是哪个需要波动 */
        if (aImg[i].index != str.charAt(i)) {
            /* 首次循环index值全为undefined，禁止全部波动 */
            if (aImg[i].index != undefined) {
                iNow.push(i);        /* 把需要波动的值加入iNow数组 */
            }
            aImg[i].index = str.charAt(i);  /* 并赋给新的值 */
            aImg[i].setAttribute("src","assets/images/clock/"+str.charAt(i)+".png"); /* 替换数字图片 */
        }
    }
    /* 遍历当前需要震动的数组，并设置震动定时器 */
    for(x in iNow){
        toshocking(iNow[x]);
    }
    /* 每次震动完数组清零 */
    iNow.length = 0;
}

/* 为每一个需要震动的数字设置震动定时器 */
function toshocking(z){
    var n = 0;   /* 波动次数 */
    var timer2 = setInterval(function(){
        aImg[z].style.top = shockNum[n]+"px";
        ++n;
        /* 若波动完设置的振幅数组，清除定时器 */
        if (n==shockNum.length) {
            clearInterval(timer2)
        }
    },20);
}

// 调整时间的样式，个位数前面加“0”
function timeStyle(num){
    if (num < 10) {
        return "0"+num;
    }
    return num+"";
}