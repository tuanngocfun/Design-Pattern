using ChainOfResponsibility.Mock.Models;

namespace ChainOfResponsibility.Mock.WithoutRequest.Interfaces
{
    public interface IDataFormatter
    {
        Task FormatAsync(CompoundDataDto dto);
    }
}
