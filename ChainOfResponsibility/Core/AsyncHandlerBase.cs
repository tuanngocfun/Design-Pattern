namespace ChainOfResponsibility.Core
{
    public abstract class AsyncHandlerBase<TRequest, THandled> : IAsyncHandler<TRequest, THandled>
        where TRequest : class
        where THandled : class
    {
        public Task<THandled> HandleAsync(TRequest request, THandled obj, Func<Task<THandled>> next)
        {
            return ShouldHandle(request, obj) ? ExecuteAsync(request, obj, next) : next.Invoke();
        }

        protected virtual bool ShouldHandle(TRequest request, THandled obj)
        {
            return true;
        }

        protected abstract Task<THandled> ExecuteAsync(TRequest request, THandled obj, Func<Task<THandled>> next);
    }

    public abstract class AsyncHandlerBase<THandled> : IAsyncHandler<THandled>
        where THandled : class
    {
        public Task<THandled> HandleAsync(THandled obj, Func<Task<THandled>> next)
        {
            return ShouldHandle(obj) ? ExecuteAsync(obj, next) : next.Invoke();
        }

        protected virtual bool ShouldHandle(THandled obj)
        {
            return true;
        }

        protected abstract Task<THandled> ExecuteAsync(THandled obj, Func<Task<THandled>> next);
    }
}
