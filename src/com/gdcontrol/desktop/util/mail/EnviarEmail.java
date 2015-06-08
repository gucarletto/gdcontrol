package com.gdcontrol.desktop.util.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



public class EnviarEmail extends Thread {
    
    private String mailSMTPServer;
    
    private String mailSMTPServerPort;
    
    private Email email;
    
    public EnviarEmail(Email email) {
        mailSMTPServer = "smtp.gmail.com";
        mailSMTPServerPort = "465";//465
        this.email = email;
    }
    
    public EnviarEmail(String mailSMTPServer, String mailSMTPServerPort, Email email) { //Para outro Servidor
        this.mailSMTPServer = mailSMTPServer;
        this.mailSMTPServerPort = mailSMTPServerPort;
        this.email = email;
    }
    
    public Email getEmail() {
        return email;
    }
    
    public void setEmail(Email email) {
        this.email = email;
    }
    
    public String getMailSMTPServer() {
        return mailSMTPServer;
    }
    
    public void setMailSMTPServer(String mailSMTPServer) {
        this.mailSMTPServer = mailSMTPServer;
    }
    
    public String getMailSMTPServerPort() {
        return mailSMTPServerPort;
    }
    
    public void setMailSMTPServerPort(String mailSMTPServerPort) {
        this.mailSMTPServerPort = mailSMTPServerPort;
    }
    
    @Override
    public void run() {
        sendEmail();
    }
    
    public void sendEmail() {
        Properties props = new Properties();
        
        props.put("mail.transport.protocol", "smtps"); //define protocolo de envio como SMTP
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailSMTPServer); //server SMTP do GMAIL
        props.put("mail.smtp.auth", "true"); //ativa autenticacao
        props.put("mail.smtp.user", email.getDe()[0]); //usuario ou seja, a conta que esta enviando o email (tem que ser do GMAIL)
        props.put("mail.debug", "true");
        props.put("mail.smtp.port", mailSMTPServerPort); //porta
        props.put("mail.smtp.socketFactory.port", mailSMTPServerPort); //mesma porta para o socket
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
		

        //Cria um autenticador que sera usado a seguir
        SimpleAuth auth = new SimpleAuth(email.getDe()[0], email.getDe()[1]);//Usuario e senha de quem esta enviando

        //Session - objeto que ira realizar a conexão com o servidor
        /*
         * Como há necessidade de autenticação é criada uma autenticacao que
         * responsavel por solicitar e retornar o usuário e senha para
         * autenticação
         */
        Session session = Session.getDefaultInstance(props, auth);
        session.setDebug(true); //Habilita o LOG das ações executadas durante o envio do email

        //Objeto que cont�m a mensagem
        Message msg = new MimeMessage(session);
        
        try {
            //Setando o destinatários
            int arrayLength = email.getPara().size();
            InternetAddress[] enderecosDestinatarios = new InternetAddress[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                enderecosDestinatarios[i] =
                        new InternetAddress(email.getPara().get(i));
            }
            msg.setRecipients(Message.RecipientType.BCC, enderecosDestinatarios);

            //Setando a origem do email
            msg.setFrom(new InternetAddress(email.getDe()[0]));
            
            //Setando o assunto
            msg.setSubject(email.getAssunto());
            //Setando o conteúdo/corpo do email
            msg.setContent(email.getMensagem(), "text/html");
//            Setando anexos
            MimeMultipart part = new MimeMultipart();
            
            MimeBodyPart body1 = new MimeBodyPart();
            body1.setContent(email.getMensagem(), "text/html");
            
            part.addBodyPart(body1);
            
            if (email.getAnexos().size() > 0) {
                for (int i = 0; i < email.getAnexos().size(); i++) {
                    MimeBodyPart body = new MimeBodyPart();
                    body.attachFile(email.getAnexos().get(i));
                    part.addBodyPart(body);
                }
            }
            msg.setContent(part);
        } catch (Exception e) {
            System.out.println(">> Erro: Completar Mensagem");
            e.printStackTrace();
        }

        //Objeto encarregado de enviar os dados para o email
        Transport tr;
        try {
            tr = session.getTransport("smtp"); //define smtp para transporte
            /*
             * 1 - define o servidor smtp 2 - seu nome de usuario do gmail 3 -
             * sua senha do gmail
             */
            tr.connect(mailSMTPServer, email.getDe()[0], email.getDe()[1]);//Usuario e senha novamente
            msg.saveChanges(); // don't forget this
            //envio da mensagem
            tr.sendMessage(msg, msg.getAllRecipients());
            tr.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(">> Erro: Envio Mensagem");
        }
        
    }
}

class SimpleAuth extends Authenticator {
    
    public String username = null;
    
    public String password = null;
    
    public SimpleAuth(String user, String pwd) {
        username = user;
        password = pwd;
    }
}
