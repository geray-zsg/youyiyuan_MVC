package com.y3.util;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;

public class EmailUtil {
	public int sendEmail(String emailaddress) {
		try {
			Random random = new Random();
			int code = random.nextInt(9000) + 1000;
			HtmlEmail email = new HtmlEmail();// 不用更改
			email.setHostName("smtp.qq.com");// 需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);// 收件地址

			email.setFrom("1690014753@qq.com", "MageShop管理员");// 此处填邮箱地址和用户名,用户名可以任意填写

			email.setAuthentication("1690014753@qq.com", "bzqaboqcccmyfdeb");// 此处填写邮箱地址和客户端授权码

			email.setSubject("MegaShop");// 此处填写邮件名，邮件名可任意填写
			email.setMsg("尊敬的用户您好,您本次注册的验证码是:" + code);// 此处填写邮件内容

			email.send();
			return code;
		} catch (Exception e) {
			return 0;
		}
	}
}
