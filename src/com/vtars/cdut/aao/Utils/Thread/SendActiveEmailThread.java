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
        // �����ʼ�
       
            try
            {
                Properties props = new Properties();
                props.setProperty("mail.transport.protocol", "smtp");// ����ʹ�õ�Э��
                props.setProperty("mail.host", "smtp.163.com");// ���ͷ�������������ַ
                props.setProperty("mail.smtp.auth", "true");// ���������֤
                Session session = Session.getDefaultInstance(props);
//            session.setDebug(true);
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("zhangvtars@163.com"));
                message.setRecipients(Message.RecipientType.TO, user.getEmail());
                message.setSubject("������Գɶ���У԰���ֵ��˻������ʼ���");

                MimeBodyPart part = new MimeBodyPart();
                part.setContent(
                        "����һ�����Գɶ���У԰���ֵ��˻������ʼ���<br/>"
                                + "������������<a href='http://localhost:8080/outsale/Home/activecheckstudyid.jsp?activeid="
                                + (new BASE64Encoder()).encodeBuffer(user
                                        .getStudyid().getBytes("UTF-8"))
                                + "'>http://localhost:8080/outsale/Home/activecheckstudyid.jsp?activeid="
                                + (new BASE64Encoder()).encodeBuffer(user
                                        .getStudyid().getBytes("UTF-8"))
                                + "</a>���������˻�<br/>"
                                + "���߿����������ӵ����ĵ�ַ���С�<br/>Vtars.com ���ĳɶ���У԰����<br/>"
                                + "���ʼ���ϵͳ�Զ��������벻Ҫֱ�ӻظ�", "text/html;charset=UTF-8");

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
