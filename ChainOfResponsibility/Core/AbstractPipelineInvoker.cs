namespace ChainOfResponsibility.Core
{
    public abstract class AbstractPipelineInvoker<TRequest, THandled> 
        where TRequest : class 
        where THandled : class
    {
        protected IList<IHandler<TRequest, THandled>> Pipeline { get; set; }

        protected AbstractPipelineInvoker(IList<IHandler<TRequest, THandled>> pipeline)
        {
            Pipeline = pipeline;
        }

        protected THandled InvokePipeline(TRequest request, THandled obj)
        {
            var i = 0;
            Func<THandled> callNext = default!;

            callNext = () =>
            {
                if (i < Pipeline.Count)
                {
                    return Pipeline[i++].Handle(request, obj, callNext);
                }
                else
                {
                    return obj;
                }
            };

            // Give subclasses a chance to preprocess the request and object before passing it to the pipeline
            Preprocess(request, obj);

            // Invoke the pipeline
            return callNext.Invoke();
        }

        protected virtual void Preprocess(TRequest request, THandled obj)
        {
            // Default implementation is do nothing
        }
    }

    public abstract class AbstractPipelineInvoker<THandled> 
        where THandled : class
    {
        protected IList<IHandler<THandled>> Pipeline { get; set; }

        protected AbstractPipelineInvoker(IList<IHandler<THandled>> pipeline)
        {
            Pipeline = pipeline;
        }

        protected THandled InvokePipeline(THandled obj)
        {
            var i = 0;
            Func<THandled> callNext = default!;

            callNext = () =>
            {
                if (i < Pipeline.Count)
                {
                    return Pipeline[i++].Handle(obj, callNext);
                }
                else
                {
                    return obj;
                }
            };

            // Give subclasses a chance to preprocess the object before passing it to the pipeline
            Preprocess(obj);

            // Invoke the pipeline
            return callNext.Invoke();
        }

        protected virtual void Preprocess(THandled obj)
        {
            // Default implementation is do nothing
        }
    }
}
