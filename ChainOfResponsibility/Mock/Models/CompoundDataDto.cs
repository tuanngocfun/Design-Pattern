namespace ChainOfResponsibility.Mock.Models
{
    public class CompoundDataDto
    {
        public DataFormattingRequest Request { get; set; } = default!;

        public DataDto Data { get; set; } = default!;
    }
}
