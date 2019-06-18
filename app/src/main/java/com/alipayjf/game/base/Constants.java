package com.alipayjf.game.base;

public class Constants {

    //测试地址
    //private static final String ADRESS = "http://mqpayadmin.alipayjf.com";
    //测试地址
    private static final String ADRESS = "http://114.55.243.30:8388";


    /*==================================================================================*/

    //获取短信验证码
    public static final String GET_CODE = ADRESS + "/api/user/getValidateCode";
    //注册接口
    public static final String REGIST = ADRESS + "/api/user/register";
    //登录
    public static final String LOGIN = ADRESS + "/api/user/login";
    //图片上传
    public static final String UPLOADIMG = ADRESS + "/pc/common/uploadImg";
    //认证提交信息
    public static final String SAVEUSER = ADRESS + "/api/user/save";
    //获取用户信息
    public static final String GETUSERINFO = ADRESS + "/api/user/getUserInfo";
    //获取充值记录(首页)
    public static final String SELECTPAGE = ADRESS + "/api/order/selectPage/1/10";
    //获取充值记录（个人中心）
    public static final String PERSONSELECTPAGE = ADRESS + "/api/charge/selectPage/1/10";
    //获取体现记录（个人中心）
    public static final String PERSONREFLECTIVIE = ADRESS + "/api/cashOut/selectPage/1/10";
    //修改密码
    public static final String UPDATAPASSORD = ADRESS +"/api/user/updatePassword";
    //填写充值金额
    public static final String SAVEPRICE = ADRESS +"/api/charge/save";
    //查询银行列表
    public static final String GETBANK = ADRESS +"/api/charge/getBank";
    //查询银行具体信息
    public static final String GETBANKCARD = ADRESS +"/api/charge/getBankCard";
    //提现
    public static final String CASHOUT = ADRESS +"/api/user/cashOut";
    //抢单
    public static final String GRABORDER = ADRESS +"/api/user/grabOrder";
    //提现详情
    public static final String SELECTONE = ADRESS +"/api/cashOut/selectOne";
    //再次提现
    public static final String LISTCASHOUT = ADRESS +"/api/user/listCashOut";
    //websocket连接
    public static final String WEBSOCKET = ADRESS + "/websocket/";
    //确认收款
    public static final String SUBMITPRICE = ADRESS + "/api/order/confirm/";
}
