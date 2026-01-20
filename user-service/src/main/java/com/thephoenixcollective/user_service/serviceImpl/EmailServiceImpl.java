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

    String attachmentPath = "/Users/dharmendramore/Downloads/Akansha/Resume-Akansha-11-01-2026.pdf";


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
        return "Senior Backend Developer (7+ Yrs) | Immediate Joiner";
    }

    private String getBody(String name) {

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
}
