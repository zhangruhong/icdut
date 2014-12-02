package com.vtars.Utils.Thread;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import sun.misc.BASE64Encoder;

import com.vtars.outsale.Bean.userbean;

public class SendActiveEmailThread extends Thread
{

    private userbean user;

    public SendActiveEmailThread(userbean user)
    {
        this.user = user;
    }

    @Override
    public void run()
    {
        // 发送邮件
       
            try
            {
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");// 发送使用的协议
                props.setProperty("mail.host", "smtp.163.com");// 发送服务器的主机地址
                props.setProperty("mail.smtp.auth", "true");// 请求身份验证
                Session session = Session.getDefaultInstance(props);
//            session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("zhangvtars@163.com"));
                message.setRecipients(Message.RecipientType.TO, user.getEmail());
                message.setSubject("激活：来自成都理工校园助手的账户激活邮件！");

                MimeBodyPart part = new MimeBodyPart();
                part.setContent(
                        "这是一封来自成都理工校园助手的账户激活邮件！<br/>"
                                + "请点击以下链接<a href='http://localhost:8080/outsale/Home/activecheckstudyid.jsp?activeid="
                                + (new BASE64Encoder()).encodeBuffer(user
                                        .getStudyid().getBytes("UTF-8"))
                                + "'>http://localhost:8080/outsale/Home/activecheckstudyid.jsp?activeid="
                                + (new BASE64Encoder()).encodeBuffer(user
                                        .getStudyid().getBytes("UTF-8"))
                                + "</a>激活您的账户<br/>"
                                + "或者拷贝以上链接到您的地址栏中。<br/>Vtars.com 您的成都理工校园助手<br/>"
                                + "本邮件由系统自动发出，请不要直接回复", "text/html;charset=UTF-8");

                MimeMultipart mpart = new MimeMultipart();
                mpart.addBodyPart(part);
                message.setContent(mpart);
                message.saveChanges();

                Transport ts = session.getTransport();
                ts.connect("zhangvtars", "zhangruhong");
                ts.sendMessage(message, message.getAllRecipients());
                ts.close();
            } catch (AddressException e)
            {
                
                e.printStackTrace();
            } catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            } catch (NoSuchProviderException e)
            {
                e.printStackTrace();
            } catch (MessagingException e)
            {
                e.printStackTrace();
            }
       

    }
}
