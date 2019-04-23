package com.yiwei.ywt.sys.weixin.service.impl;

/**
 * @description:
 * @author: czy
 * @date: 2019-04-21 12:18
 * @version: 1.0.0
 */
public class WeixinServiceimpl {

    public static final String appid = "" ;//应用ID==登陆微信公众号后台-开发-基本配置
    public static final String mch_id = "" ;// 微信支付商户号==登陆微信支付后台，即可看到
    public static final String nonce_str = ""; //随机字符串==随机字符串，不长于32位（参考算法https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3）
    public static final String sign = ""; //=签名==官方给的签名算法。https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3。
    public static final String body = ""; //商品描述==商品或支付单简要描述（中文可能会遇到毫无头绪的签名错误）
    public static final String out_trade_no = ""; //商户订单号==商户系统内部的订单号,32个字符内、可包含字母（参考：https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_2）
    public static final String total_fee = "" ; //总金额==订单总金额，单位为分
    public static final String spbill_create_ip = ""; //终端ip
    public static final String notify_url = "" ; //通知地址==接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
    public static final String trade_type = "" ; //交易类型==取值如下：JSAPI，NATIVE，APP。我们这里使用的JSAPI
    public static final String scene_info = "" ;









}
