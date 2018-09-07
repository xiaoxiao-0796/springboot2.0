package com.xiaofei.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description：
 * @Ahthor: xiaofei
 * @Date: Create in 上午11:16 2018/9/7
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    /**
     * 简单邮件
     */
    @Test
    public void test1(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("17091913660@163.com");
        message.setTo("17091913660@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }


    /**
     * 用free marker模版发邮件
     * @throws Exception
     */
    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("17091913660@163.com");
        helper.setTo("17091913660@163.com");
        helper.setSubject("主题：模板邮件");

        Map<String, Object> model = new HashMap<>();
        model.put("username", "didi");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(freeMarkerConfigurer.getConfiguration().getTemplate("template.html"), model);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
    }


    /**
     * 发送html
     * @param title
     * @param content
     * @param from
     * @param to
     * @return
     */
    public String sendHtmlMail(String title,String content,String from,String[] to){
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);
        try {
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(title);
            StringBuilder sb = new StringBuilder();
            sb.append("<html><head></head>");
            sb.append("<body><h1>spring 邮件测试</h1><p>hello ! spring mail</p>");
            sb.append("<span style='color:red'>test</span></html>");
            mimeMessageHelper.setText(sb.toString(),true);
            mailSender.send(mimeMailMessage);
            System.out.println("邮件发送成功");
            return "邮件发送成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 发送图片
     * @param title
     * @param content
     * @param from
     * @param to
     * @return
     */
    public String sendAttachedImageMail(String title,String content,String from,String[] to){
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(title);
            StringBuilder sb = new StringBuilder();
            sb.append("<html><head></head>");
            sb.append("<body><h1>spring 邮件测试</h1><p>hello ! spring mail</p>");
            sb.append("<span style=\"color:red\">test</span>");
            sb.append("<img src=\"cid:imageId\"/>");
            sb.append("</html>");
            mimeMessageHelper.setText(sb.toString(),true);
            FileSystemResource img = new FileSystemResource(new File("E:/1.png"));
            mimeMessageHelper.addInline("imageId",img);
            mailSender.send(mimeMailMessage);
            System.out.println("邮件发送成功");
            return "邮件发送成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 发送附件
     * @param title
     * @param content
     * @param from
     * @param to
     * @return
     */
    public String sendAttendedFileMail(String title,String content,String from,String[] to){
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(title);
            StringBuilder sb = new StringBuilder();
            sb.append("<html><head></head>");
            sb.append("<body><h1>spring 邮件测试</h1><p>hello ! spring mail</p>");
            sb.append("<span style=\"color:red\">test</span>");
            sb.append("<img src=\"cid:imageId\"/>");
            sb.append("</html>");
            mimeMessageHelper.setText(sb.toString(),true);
            FileSystemResource img = new FileSystemResource(new File("E:/1.png"));
            mimeMessageHelper.addInline("imageId",img);
            mimeMessageHelper.addAttachment("imageId.png",img);
            mailSender.send(mimeMailMessage);
            System.out.println("邮件发送成功");
            return "邮件发送成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
