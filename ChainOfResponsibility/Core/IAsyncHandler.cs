namespace ChainOfResponsibility.Core
{
    public interface IAsyncHandler<in TRequest, THandled> 
        where TRequest : class 
        where THandled : class
    {
        Task<THandled> HandleAsync(TRequest request, THandled obj, Func<Task<THandled>> next);
    }

    public interface IAsyncHandler<THandled> 
        where THandled : class
    {
        Task<THandled> HandleAsync(THandled obj, Func<Task<THandled>> next);
    }
}
