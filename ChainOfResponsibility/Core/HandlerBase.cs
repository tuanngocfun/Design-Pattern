namespace ChainOfResponsibility.Core
{
    public abstract class HandlerBase<TRequest, THandled> : IHandler<TRequest, THandled> 
        where TRequest : class 
        where THandled : class
    {
        public THandled Handle(TRequest request, THandled obj, Func<THandled> next)
        {
            return ShouldHandle(request, obj) ? Execute(request, obj, next) : next.Invoke();
        }

        protected virtual bool ShouldHandle(TRequest request, THandled obj)
        {
            return true;
        }

        protected abstract THandled Execute(TRequest request, THandled obj, Func<THandled> next);
    }

    public abstract class HandlerBase<THandled> : IHandler<THandled> 
        where THandled : class
    {
        public THandled Handle(THandled obj, Func<THandled> next)
        {
            return ShouldHandle(obj) ? Execute(obj, next) : next.Invoke();
        }

        protected virtual bool ShouldHandle(THandled obj)
        {
            return true;
        }

        protected abstract THandled Execute(THandled obj, Func<THandled> next);
    }
}
