var LODOP;
function check() {
    try{
        LODOP =getLodop();
        if (LODOP.VERSION) {
            if (LODOP.CVERSION)
                alert("当前有C-Lodop云打印可用!\n C-Lodop版本:"+LODOP.CVERSION+"(内含Lodop"+LODOP.VERSION+")");
            else
                alert("本机已成功安装了Lodop控件！\n 版本号:"+LODOP.VERSION);

        };
    }catch(err){
    }
}
function view1() {
        LODOP=getLodop();
    LODOP.PRINT_INITA(0,0,1600,1100,"");
    LODOP.SET_SHOW_MODE("BKIMG_WIDTH","420.16mm");
    LODOP.SET_SHOW_MODE("BKIMG_HEIGHT","289.98mm");
    LODOP.ADD_PRINT_TEXT(196,1010,400,34,"名称");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(277,1014,400,34,"住所");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(357,1018,400,34,"法人代表");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(436,1019,400,34,"公司类型");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(518,1021,400,34,"资质等级");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(739,368,400,34,"证书编号");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(740,1095,360,34,"发证机关");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(871,1007,400,34,"2017年99月99日");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(813,1067,80,34,"2017");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(810,1178,40,34,"99");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.ADD_PRINT_TEXT(815,1301,40,34,"99");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",18);
    LODOP.PREVIEW();
}
function view2() {
        LODOP=getLodop();
    LODOP.PRINT_INITA(0,0,1400,982,"");
    LODOP.SET_SHOW_MODE("BKIMG_WIDTH","370.15mm");
    LODOP.SET_SHOW_MODE("BKIMG_HEIGHT","260.09mm");
    LODOP.ADD_PRINT_TEXT(85,212,380,30,"名称");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(157,214,380,30,"住所");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(229,210,120,30,"法人代表");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(230,492,120,30,"公司类型");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(303,210,120,30,"注册资本");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(302,489,120,30,"实收资本");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(375,352,260,30,"营业执照注册号");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(452,421,200,30,"经营业务时间");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(522,209,380,30,"证书编号");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(715,411,207,30,"发证机关");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(770,396,52,30,"2017");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(768,467,30,30,"99");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(767,522,30,30,"99");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(841,213,380,30,"2017年99月99日");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.ADD_PRINT_TEXT(106,781,528,781,"备注\r\n备注\r\n备注\r\n备注\r\n备注\r\n...(省略)");
    LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
    LODOP.PREVIEW();

}