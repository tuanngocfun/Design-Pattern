using ChainOfResponsibility.Core;
using ChainOfResponsibility.Mock.Models;
using ChainOfResponsibility.Mock.WithoutRequest.Interfaces;

namespace ChainOfResponsibility.Mock.WithoutRequest.Formatters
{
    public class DataFormatter : AbstractAsyncPipelineInvoker<CompoundDataDto>, IDataFormatter
    {
        public DataFormatter(IList<IAsyncHandler<CompoundDataDto>> handlers) : base(handlers)
        {

        }

        public Task FormatAsync(CompoundDataDto dto)
        {
            return InvokePipelineAsync(dto);
        }

        protected override Task Preprocess(CompoundDataDto obj)
        {
            obj.Data.Field1 = string.Empty;
            obj.Data.Field2 = string.Empty;
            obj.Data.Message = string.Empty;

            return Task.CompletedTask;
        }
    }
}
