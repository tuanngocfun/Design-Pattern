package BuilderSample;

public class Attachment {

    private FileType fileType;
    private String fileName;
    private double fileSize;
    private FileSizeUnit fileSizeUnit;

    Attachment(AttachmentBuilder builder){
        this.fileType = builder.fileType;
        this.fileName = builder.fileName;
        this.fileSize = builder.fileSize;
        this.fileSizeUnit = builder.fileSizeUnit;
    }

    public static class AttachmentBuilder{

        private FileType fileType;
        private String fileName;
        private double fileSize;
        private FileSizeUnit fileSizeUnit;

        private GeneralMail.AttachmentListBuilder attachmentListBuilder;

        public AttachmentBuilder(){}

        public AttachmentBuilder(GeneralMail.AttachmentListBuilder attachmentListBuilder){
            this.attachmentListBuilder = attachmentListBuilder;
        }

        public AttachmentBuilder withFileType(FileType fileType) {
            this.fileType = fileType;
            return this;
        }

        public AttachmentBuilder withFileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public AttachmentBuilder withFileSize(double fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public AttachmentBuilder withFileSizeUnit(FileSizeUnit fileSizeUnit) {
            this.fileSizeUnit = fileSizeUnit;
            return this;
        }

        public Attachment build(){
            return new Attachment(this);
        }

        // go list again
        public GeneralMail.AttachmentListBuilder addToList(){
            Attachment attachment = build();
            this.attachmentListBuilder.addAttachment(attachment);
            return this.attachmentListBuilder;
        }

    }

    public enum FileType{
        DOCX,
        PDF,
        JPG,
        PNG;
    }

    public enum FileSizeUnit{
        KBYTE,
        MBYTE,
        GBYTE;
    }
}
