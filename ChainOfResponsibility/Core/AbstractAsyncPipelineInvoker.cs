namespace ChainOfResponsibility.Core
{
    public abstract class AbstractAsyncPipelineInvoker<TRequest, THandled> 
        where TRequest : class 
        where THandled : class
    {
        protected IList<IAsyncHandler<TRequest, THandled>> Pipeline { get; set; }

        protected AbstractAsyncPipelineInvoker(IList<IAsyncHandler<TRequest, THandled>> pipeline)
        {
            Pipeline = pipeline;
        }

        protected async Task<THandled> InvokePipelineAsync(TRequest request, THandled obj)
        {
            var i = 0;
            Func<Task<THandled>> callNext = default!;

            callNext = () =>
            {
                if (i < Pipeline.Count)
                {
                    return Pipeline[i++].HandleAsync(request, obj, callNext);
                }
                else
                {
                    return Task.FromResult(obj);
                }
            };

            // Give subclasses a chance to preprocess the request and object before passing it to the pipeline
            await Preprocess(request, obj);

            // Invoke the pipeline
            return await callNext.Invoke();
        }

        protected virtual Task Preprocess(TRequest request, THandled obj)
        {
            // Default implementation is do nothing
            return Task.CompletedTask;
        }
    }

    public abstract class AbstractAsyncPipelineInvoker<THandled> 
        where THandled : class
    {
        protected IList<IAsyncHandler<THandled>> Pipeline { get; set; }

        protected AbstractAsyncPipelineInvoker(IList<IAsyncHandler<THandled>> pipeline)
        {
            Pipeline = pipeline;
        }

        protected async Task<THandled> InvokePipelineAsync(THandled obj)
        {
            var i = 0;
            Func<Task<THandled>> callNext = default!;

            callNext = () =>
            {
                if (i < Pipeline.Count)
                {
                    return Pipeline[i++].HandleAsync(obj, callNext);
                }
                else
                {
                    return Task.FromResult(obj);
                }
            };

            // Give subclasses a chance to preprocess the object before passing it to the pipeline
            await Preprocess(obj);

            // Invoke the pipeline
            return await callNext.Invoke();
        }

        protected virtual Task Preprocess(THandled obj)
        {
            // Default implementation is do nothing
            return Task.CompletedTask;
        }
    }
}
