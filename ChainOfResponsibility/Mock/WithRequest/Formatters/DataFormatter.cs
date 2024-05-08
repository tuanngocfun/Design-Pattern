using ChainOfResponsibility.Core;
using ChainOfResponsibility.Mock.WithRequest.Interfaces;
using ChainOfResponsibility.Mock.Models;

namespace ChainOfResponsibility.Mock.WithRequest.Formatters
{
    public class DataFormatter : AbstractAsyncPipelineInvoker<DataFormattingRequest, DataDto>, IDataFormatter
    {
        public DataFormatter(IList<IAsyncHandler<DataFormattingRequest, DataDto>> handlers) : base(handlers)
        {

        }

        public Task FormatAsync(DataFormattingRequest request, DataDto dto)
        {
            return InvokePipelineAsync(request, dto);
        }

        protected override Task Preprocess(DataFormattingRequest request, DataDto obj)
        {
            obj.Field1 = string.Empty;
            obj.Field2 = string.Empty;
            obj.Message = string.Empty;

            return Task.CompletedTask;
        }
    }
}
