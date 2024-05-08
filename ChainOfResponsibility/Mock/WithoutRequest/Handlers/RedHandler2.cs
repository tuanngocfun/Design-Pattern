using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.Utilities;
using ChainOfResponsibility.Mock.WithoutRequest.Bases;

namespace ChainOfResponsibility.Mock.WithoutRequest.Handlers
{
    public class RedHandler2 : RedHandlerBase
    {
        protected override bool ShouldHandle(CompoundDataDto obj)
        {
            return base.ShouldHandle(obj) && obj.Request.Number > 200;
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
