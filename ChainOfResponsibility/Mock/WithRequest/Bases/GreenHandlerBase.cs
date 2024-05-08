using ChainOfResponsibility.Core;
using ChainOfResponsibility.Mock.Enums;
using ChainOfResponsibility.Mock.Models;

namespace ChainOfResponsibility.Mock.WithRequest.Bases
{
    public abstract class GreenHandlerBase : AsyncHandlerBase<DataFormattingRequest, DataDto>
    {
        protected override bool ShouldHandle(DataFormattingRequest request, DataDto obj)
        {
            return request.Color == Color.Green;
        }
    }
}
