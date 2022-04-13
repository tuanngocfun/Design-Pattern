package BuilderSample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GeneralMail implements Serializable {

    private String from;
    private String to;
    private String subject;
    private String textMessage;
    private List<String> cc;
    private List<String> bcc;
    private List<Attachment> attachments;
    private MailSeverity mailSeverity = MailSeverity.NORMAL;

    private GeneralMail () {};

    public static class Builder{
        public enum STANDART_FLOW {
            CREATE;
            private GeneralFunctionalSteps steps;

            public GeneralFunctionalSteps mandatory(String from, String to, String subject, String textMessage){
                steps = new GeneralFunctionalSteps();
                steps.generalMailInfo = new GeneralMail();
                steps.generalMailInfo.from = from;
                steps.generalMailInfo.to = to;
                steps.generalMailInfo.subject = subject;
                steps.generalMailInfo.textMessage = textMessage;
                return steps;
            }

            public GeneralMail build(){
                return steps.generalMailInfo;
            }

        };
        public enum MANAGER_FLOW{
            CREATE;
            private GeneralFunctionalSteps steps;

            public GeneralFunctionalSteps mandatory(String from, String to, String subject, String textMessage, List<String> cc){
                steps = new GeneralFunctionalSteps();
                steps.generalMailInfo = new GeneralMail();
                steps.generalMailInfo.from = from;
                steps.generalMailInfo.to = to;
                steps.generalMailInfo.subject = subject;
                steps.generalMailInfo.textMessage = textMessage;
                steps.generalMailInfo.cc = cc;
                return steps;
            }
        };
        public enum PRIVATE_MANAGER_FLOW{
            CREATE;
            private GeneralFunctionalSteps steps;

            public GeneralFunctionalSteps mandatory(String from, String to, String subject, String textMessage, List<String> bcc){
                steps = new GeneralFunctionalSteps();
                steps.generalMailInfo = new GeneralMail();
                steps.generalMailInfo.from = from;
                steps.generalMailInfo.to = to;
                steps.generalMailInfo.subject = subject;
                steps.generalMailInfo.textMessage = textMessage;
                steps.generalMailInfo.bcc = bcc;
                return steps;

            }
        };
        public static class GeneralFunctionalSteps {

            private GeneralMail generalMailInfo;
            private AttachmentListBuilder attachmentListBuilder;

            public GeneralFunctionalSteps addAllCc(List<String> cc) {
                generalMailInfo.cc = cc;
                return this;
            }

            public GeneralFunctionalSteps addAllBcc(List<String> bcc) {
                generalMailInfo.bcc.addAll(bcc);
                return this;
            }

            public GeneralFunctionalSteps addCc(String ccItem) {
                if (generalMailInfo.cc == null) {
                    generalMailInfo.cc = new ArrayList<String>();
                }
                generalMailInfo.cc.add(ccItem);
                return this;
            }

            public GeneralFunctionalSteps addBcc(String bccItem) {
                if (generalMailInfo.bcc == null) {
                    generalMailInfo.bcc = new ArrayList<String>();
                }
                generalMailInfo.bcc.add(bccItem);
                return this;
            }

            public GeneralFunctionalSteps wihMailSeverity(MailSeverity mailSeverity) {
                generalMailInfo.mailSeverity = mailSeverity;
                return this;
            }

            public AttachmentListBuilder withAttachments() {
                attachmentListBuilder = new AttachmentListBuilder(this);
                return attachmentListBuilder;
            }

            public GeneralMail build() {
                generalMailInfo.attachments = attachmentListBuilder.attachments;
                return generalMailInfo;
            }
        }
    }

    public static class AttachmentListBuilder{

        private List<Attachment> attachments = new ArrayList<Attachment>();
        private Builder.GeneralFunctionalSteps steps;

        public AttachmentListBuilder(Builder.GeneralFunctionalSteps steps){
            this.steps = steps;
        }

        public Attachment.AttachmentBuilder addAttachment(){
            return new Attachment.AttachmentBuilder(this);
        }

        public AttachmentListBuilder addAttachment(Attachment attachment){
            attachments.add(attachment);
            return this;
        }

        public AttachmentListBuilder addAllAttachment(List<Attachment> attachment){
            attachments.addAll(attachment);
            return this;
        }

        // go parent
        public Builder.GeneralFunctionalSteps buildAttachmentList(){
            return steps;
        }

    }

    public enum MailSeverity{
        NORMAL,
        IMPORTANT,
        HIGH_IMPORTANT;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public List<String> getCc() {
        return cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public MailSeverity getMailSeverity() {
        return mailSeverity;
    }

    @Override
    public String toString() {
        return "GeneralMailInfo{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", textMessage='" + textMessage + '\'' +
                ", cc=" + cc +
                ", bcc=" + bcc +
                ", mailSeverity=" + mailSeverity +
                '}';
    }
}
