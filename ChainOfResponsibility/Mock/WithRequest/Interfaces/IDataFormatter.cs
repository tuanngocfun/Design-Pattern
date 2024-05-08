using ChainOfResponsibility.Mock.Models;

namespace ChainOfResponsibility.Mock.WithRequest.Interfaces
{
    public interface IDataFormatter
    {
        Task FormatAsync(DataFormattingRequest request, DataDto dto);
    }
}
