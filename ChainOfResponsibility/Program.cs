using ChainOfResponsibility.Core;
using ChainOfResponsibility.Mock.Enums;
using ChainOfResponsibility.Mock.WithoutRequest.Formatters;
using ChainOfResponsibility.Mock.WithoutRequest.Handlers;
using ChainOfResponsibility.Mock.Models;

//var handlers = new List<IAsyncHandler<DataFormattingRequest, DataDto>>();
var handlers = new List<IAsyncHandler<CompoundDataDto>>();
var formatter = new DataFormatter(handlers);

handlers.Add(new RedHandler2());
handlers.Add(new VioletHandler1());
handlers.Add(new RedHandler1());
handlers.Add(new RedHandler3());
handlers.Add(new VioletHandler2());

var request = new DataFormattingRequest()
{
    Color = Color.Red,
    Number = 555
};
var dto = new DataDto()
{
    Message = "Hello World!",
    Field1 = "Lorem Ipsum"
};
var compountDto = new CompoundDataDto()
{
    Request = request,
    Data = dto
};

//await formatter.FormatAsync(request, dto);
await formatter.FormatAsync(compountDto);

Console.WriteLine(dto.Message);
