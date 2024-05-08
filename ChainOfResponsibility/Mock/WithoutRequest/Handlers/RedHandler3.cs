using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.Utilities;
using ChainOfResponsibility.Mock.WithoutRequest.Bases;

namespace ChainOfResponsibility.Mock.WithoutRequest.Handlers
{
    public class RedHandler3 : RedHandlerBase
    {
        protected override bool ShouldHandle(CompoundDataDto obj)
        {
            return base.ShouldHandle(obj) && string.IsNullOrEmpty(obj.Data.Field1);
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
