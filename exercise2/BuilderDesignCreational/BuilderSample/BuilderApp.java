package BuilderSample;

public class BuilderApp {

    public static  void main(String args []){

        GeneralMail toBeyazMasa = GeneralMail.Builder.STANDART_FLOW.CREATE.
                mandatory("tr.tayfundogan@gmail.com", "beyazmasa@ibb.gov.tr", "TRAFFIC", "Your Problem's Content").
                wihMailSeverity(GeneralMail.MailSeverity.NORMAL).
                addCc("mayor@ibb.gov.tr").
                withAttachments().
                    addAttachment().
                        withFileName("TRAFFIC_PROBLEM_CONTENT").withFileType(Attachment.FileType.DOCX).withFileSizeUnit(Attachment.FileSizeUnit.MBYTE).
                        addToList().
                    addAttachment().
                        withFileName("TRAFFIC_PROBLEM_IMAGE").withFileType(Attachment.FileType.JPG).withFileSizeUnit(Attachment.FileSizeUnit.KBYTE).
                        addToList().
                buildAttachmentList().
                addBcc("webinfo@iletisim.gov.tr").
        build();

        GeneralMail toIett = GeneralMail.Builder.MANAGER_FLOW.CREATE.
                mandatory(toBeyazMasa.getTo(), "iett@ibb.gov.tr", toBeyazMasa.getSubject(), toBeyazMasa.getTextMessage(), toBeyazMasa.getCc()).
                withAttachments().
                    addAllAttachment(toBeyazMasa.getAttachments()).
                buildAttachmentList().
                addBcc("private@iletisim.gov.tr").
                wihMailSeverity(GeneralMail.MailSeverity.IMPORTANT).
        build();

        GeneralMail toMinistry = GeneralMail.Builder.PRIVATE_MANAGER_FLOW.CREATE.
                mandatory(toIett.getTo(), "basin@icisleri.gov.tr", toIett.getSubject(), toIett.getTextMessage(), toIett.getBcc()).
                withAttachments().
                    addAllAttachment(toBeyazMasa.getAttachments()).
                buildAttachmentList().
                addAllCc(toIett.getCc()).
                wihMailSeverity(GeneralMail.MailSeverity.HIGH_IMPORTANT).
                build();

        System.out.println(toBeyazMasa);
        System.out.println(toIett);
        System.out.println(toMinistry);
    }
}
