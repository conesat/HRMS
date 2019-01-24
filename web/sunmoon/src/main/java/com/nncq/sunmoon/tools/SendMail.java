package com.nncq.sunmoon.tools;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;
import java.util.Properties;
//ocqxlefcjdwiigdj
public class SendMail {
	// 发件人的邮箱地址和密码
	public static String sendEmailAccount = "1092501244@qq.com";
	// 如果有授权码，此处填写授权码
	public static String sendEmailPassword = "rebifpwrmqykicjf";
	// 发件人邮箱的 SMTP 服务器地址, 可以登录web邮箱查询
	public static String sendEmailSMTPHost = "smtp.qq.com";
	// 收件人邮箱地址
	public static String receiveMailAccount = "";

	public static void sendMail(String mail, String msg,String title) throws Exception {
		receiveMailAccount = mail;
		Properties prop = new Properties();
		// 开启debug调试，以便在控制台查看
		prop.setProperty("mail.debug", "true"); 
		// 设置邮件服务器主机名
		prop.setProperty("mail.host", "smtp.qq.com");
		// 发送服务器需要身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 发送邮件协议名称
		prop.setProperty("mail.transport.protocol", "smtp");

		// 开启SSL加密，否则会失败
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		// 创建session
		Session session = Session.getInstance(prop);
		// 通过session得到transport对象
		Transport ts = session.getTransport();
		// 连接邮件服务器：邮箱类型，帐号，授权码代替密码（更安全）
		ts.connect("smtp.qq.com",sendEmailAccount, sendEmailPassword);
		// 创建邮件
		Message message = createSimpleMail(session,msg,title);
		// 发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	/**
	 * 创建一封简单邮件
	 */
	public static MimeMessage createSimpleMail(Session session,String msg,String title)
			throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(sendEmailAccount));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount));
		// 邮件的标题
		message.setSubject("来自公司邮件："+title);
		// 邮件的文本内容
		message.setContent(msg, "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;

	}
}
