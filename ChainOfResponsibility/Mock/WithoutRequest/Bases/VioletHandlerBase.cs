using ChainOfResponsibility.Core;
using ChainOfResponsibility.Mock.Enums;
using ChainOfResponsibility.Mock.Models;

namespace ChainOfResponsibility.Mock.WithoutRequest.Bases
{
    public abstract class VioletHandlerBase : AsyncHandlerBase<CompoundDataDto>
    {
        protected override bool ShouldHandle(CompoundDataDto obj)
        {
            return obj.Request.Color == Color.Violet;
        }
    }
}
