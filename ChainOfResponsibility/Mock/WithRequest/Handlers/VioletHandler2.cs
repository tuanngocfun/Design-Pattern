using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.Utilities;
using ChainOfResponsibility.Mock.WithRequest.Bases;

namespace ChainOfResponsibility.Mock.WithRequest.Handlers
{
    public class VioletHandler2 : VioletHandlerBase
    {
        protected override bool ShouldHandle(DataFormattingRequest request, DataDto obj)
        {
            return base.ShouldHandle(request, obj) && obj.Field2 == default;
        }

        protected override Task<DataDto> ExecuteAsync(DataFormattingRequest request, DataDto obj, Func<Task<DataDto>> next)
        {
            obj.Message = this.AddMessage(obj.Message);

            // Do something
            // Do something
            // Do something

            return next();
        }
    }
}
