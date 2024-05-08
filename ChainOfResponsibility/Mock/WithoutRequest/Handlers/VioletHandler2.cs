using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.Utilities;
using ChainOfResponsibility.Mock.WithoutRequest.Bases;

namespace ChainOfResponsibility.Mock.WithoutRequest.Handlers
{
    public class VioletHandler2 : VioletHandlerBase
    {
        protected override bool ShouldHandle(CompoundDataDto obj)
        {
            return base.ShouldHandle(obj) && obj.Data.Field2 == default;
        }

        protected override Task<CompoundDataDto> ExecuteAsync(CompoundDataDto obj, Func<Task<CompoundDataDto>> next)
        {
            obj.Data.Message = this.AddMessage(obj.Data.Message);

            // Do something
            // Do something
            // Do something

            return next();
        }
    }
}
