package com.thephoenixcollective.user_service.serviceImpl;

import com.thephoenixcollective.user_service.dto.EmailContact;
import com.thephoenixcollective.user_service.dto.EmailResult;
import com.thephoenixcollective.user_service.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl  implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    String attachmentPath = "/Users/dharmendramore/Downloads/Bhakti_Chougule_Angular_Developer_8Yrs.pdf";


    @Override
    public EmailResult sendJobApplication(EmailContact contact){
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);  // true enables multipart
            helper.setTo(contact.getD());
            helper.setSubject(getSubject());
            helper.setText(getBody(contact.getC()),true);
            FileSystemResource file = new FileSystemResource(attachmentPath);
            helper.addAttachment(file.getFilename(), file);  // Add attachment
            mailSender.send(message);
            return new EmailResult(contact.getD(), contact.getC(), true, null);
        } catch (Exception e) {
            return new EmailResult(contact.getD(), contact.getC(), false,
                    e.getMessage() + " | " + e.getClass().getSimpleName());
        }

    }


    private String getSubject() {
        return "Senior FrontEnd Developer (8+ Yrs)";
    }

    private String getBodyForAkanshaJain(String name) {

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +

                "</head>\n" +
                "<body style=\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: #000000; line-height: 1.6;\">\n" +
                "\n" +
                "  <p>Dear " + name + ",</p>\n" +
                "\n" +
                "  <p>\n" +
                "    I hope this email finds you well.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    I am a <strong>Senior Java Backend Developer</strong> with over\n" +
                "    <strong>7.2 years of hands-on experience</strong> in building scalable backend systems using\n" +
                "    Core Java, Spring, Hibernate, Spring Boot, RESTful APIs, and Microservices Architecture.\n" +
                "    I also have practical experience with AWS, Kafka, Docker, Kubernetes, and apply SOLID\n" +
                "    principles to deliver maintainable and high-performance solutions.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    I have served as a <strong>Shadow Team Lead for six months</strong>, contributing to team\n" +
                "    coordination, delivery support, and production readiness. Additionally, I bring strong\n" +
                "    experience in production monitoring, troubleshooting, and performance optimization.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    To focus on further upskilling and professional growth, I opted for an early release and am\n" +
                "    <strong>available to join immediately</strong>. Please find my resume attached for your review.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    I would welcome the opportunity to discuss how my backend expertise can contribute to your\n" +
                "    team’s success.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    Thank you for your time and consideration. I look forward to hearing from you.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    Best regards,<br>\n" +
                "    <strong>Akansha Jain</strong><br>\n" +
                "    \uD83D\uDCDE +91 7987193665\n" +
                "  </p>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

    private String getBody(String name){
        return "String htmlContent =\n" +
                "        \"<!DOCTYPE html>\\n\" +\n" +
                "        \"<html>\\n\" +\n" +
                "        \"<head>\\n\" +\n" +
                "        \"  <meta charset=\\\"UTF-8\\\">\\n\" +\n" +
                "        \"</head>\\n\" +\n" +
                "        \"<body style=\\\"font-family: Arial, Helvetica, sans-serif; font-size: 14px; color: #000000; line-height: 1.6;\\\">\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>Hi \" + name + \",</p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    I hope you’re doing well.\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    I’m a <strong>Senior Angular Frontend Developer</strong> with <strong>8 years of experience</strong>,\\n\" +\n" +
                "        \"    currently working with <strong>LTIMindtree</strong> on enterprise-scale banking applications for\\n\" +\n" +
                "        \"    <strong>ABSA Africa</strong>. My expertise includes <strong>Angular 14–18</strong>, RxJS, NgRx,\\n\" +\n" +
                "        \"    CI/CD pipelines, and performance-driven UI development.\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    I’m actively exploring new opportunities where I can contribute to building high-quality,\\n\" +\n" +
                "        \"    scalable frontend solutions. If there are any suitable openings in your team—or if you could\\n\" +\n" +
                "        \"    point me in the right direction—I’d truly appreciate it.\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    I’ve attached my resume for quick reference.\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    Thanks in advance for your time.\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"  <p>\\n\" +\n" +
                "        \"    Best regards,<br>\\n\" +\n" +
                "        \"    <strong>Bhakti Chougule</strong><br>\\n\" +\n" +
                "        \"    Senior Angular Developer<br>\\n\" +\n" +
                "        \"    \uD83D\uDCE7 <a href=\\\"mailto:c.bhakti93@gmail.com\\\">c.bhakti93@gmail.com</a><br>\\n\" +\n" +
                "        \"    \uD83D\uDD17 <a href=\\\"https://www.linkedin.com/in/bhakti-chougule\\\">LinkedIn Profile</a>\\n\" +\n" +
                "        \"  </p>\\n\" +\n" +
                "        \"\\n\" +\n" +
                "        \"</body>\\n\" +\n" +
                "        \"</html>\";\n";
    }
}
