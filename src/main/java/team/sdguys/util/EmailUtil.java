package team.sdguys.util;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 发送邮件的工具类
 * @author sdguys
 */
public class EmailUtil {

    // 发件人邮箱 及 密码(授权码)
    private static String fromEmailAccount = "1285929172@qq.com";
    private static String fromEmailPassword = "hhesyemtfcycgifa";

    // QQ 邮箱的 SMTP服务器 和 端口号(发送邮件使用)
    private static String fromEmailSMTPHost = "smtp.qq.com";
    private static String fromEmailSMTPPort = "465";

    /**
     * 发送指定内容的Email到指定用户
     *
     * @param toMailAccount 指定用户
     * @param mailContext   指定内容(可以使用 HTML5 标签)
     * @throws MessagingException 抛出邮件的相关异常
     */
    public static void sendEmail(String toMailAccount, String mailContext) throws MessagingException, UnsupportedEncodingException {

        // 邮件服务器的相关参数配置
        Properties properties = new Properties();

        // 发送邮件使用的协议
        properties.setProperty("mail.transport.protocol", "smtp");
        // 发件人邮箱的SMTP服务器
        properties.setProperty("mail.smtp.host", fromEmailSMTPHost);
        // 需要请求认证 ?
        properties.setProperty("mail.smtp.auth", "true");

        // QQ邮箱发送邮件需要使用SSL验证方式
        properties.setProperty("mail.smtp.port", fromEmailSMTPPort);
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.socketFactory.port", fromEmailSMTPPort);

        // 根据配置创建会话, 用于与邮件服务器交互
        Session session = Session.getInstance(properties);
        session.setDebug(true);

        // 创建要发送的邮件
        MimeMessage message = createMimeMessage(session, fromEmailAccount, toMailAccount, mailContext);

        // 根据Session获取邮件传输对象
        Transport transport = session.getTransport();
        transport.connect(fromEmailAccount, fromEmailPassword);

        // message.getAllRecipients() 获取所有的收件人
        transport.sendMessage(message, message.getAllRecipients());
    }

    /**
     * 根据收件人,Email内容创建一封Email
     * @param session 用于与邮件服务器交互的Session对象
     * @param fromEmailAccount 发件人邮箱
     * @param toMailAccount 收件人邮箱
     * @param mailContext 邮件内容(可以使用 HTML5 标签)
     * @return 创建好的邮件对象
     * @throws
     */
    public static MimeMessage createMimeMessage(Session session, String fromEmailAccount, String toMailAccount, String mailContext) throws UnsupportedEncodingException, MessagingException {

        // 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 设置邮件的 发件人 收件人 主题 内容 发送时间
        message.setFrom(new InternetAddress(fromEmailAccount,"绿豆芽团队","UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toMailAccount,toMailAccount.toString(),"UTF-8"));
        message.setSubject("绿豆芽网站验证码","UTF-8");
        message.setContent(mailContext,"text/html;charset=UTF-8");
        message.setSentDate(new Date());

        // 保存设置
        message.saveChanges();

        return message;
    }
}
