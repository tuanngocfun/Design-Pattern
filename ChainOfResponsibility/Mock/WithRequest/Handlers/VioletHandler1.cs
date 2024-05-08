using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.Utilities;
using ChainOfResponsibility.Mock.WithRequest.Bases;

namespace ChainOfResponsibility.Mock.WithRequest.Handlers
{
    public class VioletHandler1 : VioletHandlerBase
    {
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
