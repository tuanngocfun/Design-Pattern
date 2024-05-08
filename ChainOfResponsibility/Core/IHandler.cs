namespace ChainOfResponsibility.Core
{
    public interface IHandler<in TRequest, THandled> 
        where TRequest : class 
        where THandled : class
    {
        THandled Handle(TRequest request, THandled obj, Func<THandled> next);
    }

    public interface IHandler<THandled> 
        where THandled : class
    {
        THandled Handle(THandled obj, Func<THandled> next);
    }
}
