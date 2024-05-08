using ChainOfResponsibility.Mock.Enums;

namespace ChainOfResponsibility.Mock.Models
{
    public record class DataFormattingRequest
    {
        public Color Color { get; set; }

        public int Number { get; set; }
    }
}
